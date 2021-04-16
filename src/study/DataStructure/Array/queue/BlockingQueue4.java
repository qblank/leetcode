package study.DataStructure.Array.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数组实现阻塞队列
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/15 16:47
 */
public class BlockingQueue4 {

    private Object[] items;

    private int head;

    private int tail;

    /*队列中的元素总数*/
    private AtomicInteger count = new AtomicInteger(0);

    public BlockingQueue4(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        items = new Object[capacity];
    }

    /*显式插入锁*/
    private final ReentrantLock putLock = new ReentrantLock();

    /*锁对应的notFull变量*/
    private final Condition notFull = putLock.newCondition();

    /*显式弹出锁*/
    private final ReentrantLock takeLock = new ReentrantLock();

    /*锁对应的notEmpty变量*/
    private final Condition notEmpty = takeLock.newCondition();


    /**
     * 将元素插入队列
     *
     * @param o
     * @throws InterruptedException
     */
    public void put(Object o) throws InterruptedException {
        int c = -1;
        putLock.lockInterruptibly();
        try {
            while (count.get() == items.length) {
                //队列已满进入休眠
                // 等待队列未满条件得到满足
                notFull.await();
            }
            enqueue(o);

            //增加元素总数
            c = count.getAndIncrement();
            //如果在插入后队列仍然没满，则唤醒其他等待插入的线程
            if (c + 1 < items.length) {
                notFull.signal();
            }
        } finally {
            putLock.unlock();
        }
        //如果插入之前队列为空，才唤醒等待弹出元素的线程
        // 为了防止死锁，不能在释放putLock之前获取takeLock
        if (c == 0) {
            signalNotEmpty();
        }
    }

    /**
     * 从队列中弹出一个元素
     *
     * @return
     * @throws InterruptedException
     */
    public Object take() throws InterruptedException {
        Object o;
        int c = -1;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            o = dequeue();

            //减少元素总数
            c = count.getAndDecrement();
            //如果队列在弹出一个元素后仍然非空，则唤醒其他等待队列非空的线程
            if (c - 1 > 0) {
                notEmpty.signal();
            }
        } finally {
            takeLock.unlock();
        }
        //只有在弹出之前队列已满的情况下才唤醒等待插入元素的线程
        //为了防止死锁，不能在释放takeLock之前获取putLock
        if (c == items.length) {
            signalNotFull();
        }
        return o;
    }


    /**
     * 入队
     */
    public void enqueue(Object item) {
        items[tail] = item;
        if (++tail == items.length) {
            tail = 0;
        }
    }


    /**
     * 出队
     *
     * @return
     */
    public Object dequeue() {
        Object item = items[head];
        items[head] = null;
        if (++head == items.length) {
            head = 0;
        }
        return item;
    }


    /**
     * 唤醒等待队列非空条件的线程
     */
    private void signalNotEmpty() {
        // 为了唤醒等待队列非空条件的线程，需要先获取对应的takeLock
        takeLock.lock();
        try {
            // 唤醒一个等待非空条件的线程
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }


    /**
     * 唤醒等待队列未满条件的线程
     */
    private void signalNotFull() {
        // 为了唤醒等待队列未满条件的线程，需要先获取对应的putLock
        putLock.lock();
        try {
            // 唤醒一个等待队列未满条件的线程
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }




    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue4 queue = new BlockingQueue4(2);

        //创建2个线程
        final int thread = 300;

        //每个线程执行10次
        final int times = 100;

        List<Thread> threadList = new ArrayList<>(thread * 2);
        long startTime = System.currentTimeMillis();
        //创建2个生产者线程，向队列中并发放入数字0到19，每个线程放入10个数字
        for (int i = 0; i < thread; i++) {
            final int offset = i * times;
            Thread producer = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    try {
                        queue.put(new Integer(offset + j));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(producer);
            producer.start();
        }

        //创建2个消费者，从队列中弹出20次数字并打印弹出的数字
        for (int i = 0; i < thread; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    try {
                        Integer element = (Integer) queue.take();
                        System.out.println("消费：" + element);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadList.add(consumer);
            consumer.start();
        }


        //等待所有线程执行完毕
        for (Thread t : threadList){
            t.join();
        }
        //打印消耗时间
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("总耗时：%.2fs", (endTime - startTime) / 1e3));
    }
}
