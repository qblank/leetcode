package study.DataStructure.Array.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数组实现阻塞队列
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/15 16:47
 */
public class BlockingQueue2 {

    private Object[] items;

    private int head;

    private int tail;

    private int count;

    public BlockingQueue2(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        items = new Object[capacity];
    }

    /*显式锁*/
    private final ReentrantLock lock = new ReentrantLock();

    /*锁对应的条件变量*/
    private final Condition condition = lock.newCondition();


    /**
     * 将元素插入队列
     *
     * @param o
     * @throws InterruptedException
     */
    public void put(Object o) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == items.length){
                //队列已满进入休眠
                condition.await();
            }
            enqueue(o);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 从队列中弹出一个元素
     *
     * @return
     * @throws InterruptedException
     */
    public Object take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                condition.await();
            }
            Object o = dequeue();
            //唤醒所有等待线程
            condition.signalAll();
            return o;
        }finally {
            lock.unlock();
        }

    }


    /**
     * 入队
     */
    public void enqueue(Object item) {
        items[tail] = item;
        if (++tail == items.length){
            tail = 0;
        }
        count++;
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
        count--;
        return item;
    }



    public static void main(String[] args) throws InterruptedException {
        final BlockingQueue2 queue = new BlockingQueue2(2);

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
