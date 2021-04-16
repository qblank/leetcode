package study.DataStructure.Array.queue;

/**
 * 用数组实现的队列
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/15 14:03
 */
public class ArrayQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            //迁移数据
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }


    public String dequeue() {
        if (head == n) {
            return null;
        }
        String item = items[head];
        head++;
        return item;
    }


    public int getSize() {
        return tail - head;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println("初始化入队列6个数据:");
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.enqueue("6");

        System.out.println("队列大小：" + arrayQueue.getSize());

        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("入队列：" + arrayQueue.enqueue("7"));

        System.out.println("队列大小：" + arrayQueue.getSize());

        System.out.println("入队列：" + arrayQueue.enqueue("8"));
        System.out.println("队列大小：" + arrayQueue.getSize());
        System.out.println("入队列：" + arrayQueue.enqueue("9"));
        System.out.println("队列大小：" + arrayQueue.getSize());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());
        System.out.println("出队列：" + arrayQueue.dequeue());

        System.out.println("队列大小：" + arrayQueue.getSize());
    }
}
