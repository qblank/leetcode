package study.DataStructure.Array.queue;

/**
 * @date 2018/10/26
 */
public class TestQueue {
    public static void main(String[] args) {
        /*MyQueue mq = new MyQueue(4);
        mq.insert(1);
        mq.insert(2);
        mq.insert(3);
        mq.insert(4);
        System.out.println(mq.isEmpty());
        System.out.println(mq.isFull());
        System.out.println(mq.peek());
        while (!mq.isEmpty()){
            System.out.println(mq.remove());
        }
        System.out.println(mq.isEmpty());
        mq.insert(1);*/

        MyCycleQueue mq = new MyCycleQueue(4);
        mq.insert(1);
        mq.insert(2);
        mq.insert(3);
        mq.insert(4);
        System.out.println(mq.isEmpty());
        System.out.println(mq.isFull());
        System.out.println(mq.peek());
        while (!mq.isEmpty()){
            System.out.println(mq.remove());
        }
        System.out.println(mq.isEmpty());
        mq.insert(1);

    }
}
