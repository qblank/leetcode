package study.DataStructure.Array.queue;

/**
 * 数组实现循环队列
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/15 14:38
 */
public class CircularQueue {


    private String[] items;

    private int n;

    private int head = 0;

    private int tail = 0;


    public CircularQueue(int capacity){
        //由于循环队列会有一个空间存不了数据，则需要多申请一个空间
        capacity++;
        items = new String[capacity];
        n = capacity;
    }


    public boolean enqueue(String item){
        //队列满了
        if ((tail + 1) % n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    public String dequeue(){
        if (head == tail){
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }


    public int getSize(){
        return (tail - head + n) % n;
    }


    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        System.out.println("初始化入队列6个数据:");
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
        circularQueue.enqueue("4");
        circularQueue.enqueue("5");
        circularQueue.enqueue("6");

        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("入队列：" + circularQueue.enqueue("7"));
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());
        System.out.println("出队列：" + circularQueue.dequeue());
        System.out.println("队列大小：" + circularQueue.getSize());

    }

}
