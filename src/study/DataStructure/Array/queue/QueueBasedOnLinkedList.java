package study.DataStructure.Array.queue;

/**
 * 基于链表实现的队列
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/15 16:01
 */
public class QueueBasedOnLinkedList {

    private Node head = null;

    private Node tail = null;


    /**
     * 链表的空间可以无限增长
     * @param value 值
     */
    public void enqueue(String value){
        //可以使用哨兵进行优化
        if (tail == null){
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        }else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }


    public String dequeue(){
        if (head == null){
            return null;
        }
        String ret = head.getData();
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret;
    }


    public int getSize(){
        Node curNode = head;
        int len = 0;
        while (curNode != null){
            curNode = curNode.next;
            len++;
        }
        return len;
    }


    private static class Node{
        private String data;

        private Node next;

        public Node(String data,Node next){
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return data;
        }
    }


    public static void main(String[] args) {
        QueueBasedOnLinkedList queueBasedOnLinkedList = new QueueBasedOnLinkedList();
        System.out.println("入队初始5个数据");
        queueBasedOnLinkedList.enqueue("1");
        queueBasedOnLinkedList.enqueue("2");
        queueBasedOnLinkedList.enqueue("3");
        queueBasedOnLinkedList.enqueue("4");
        queueBasedOnLinkedList.enqueue("5");
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());

        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        queueBasedOnLinkedList.enqueue("6");
        System.out.println("入队6");
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        queueBasedOnLinkedList.enqueue("7");
        System.out.println("入队7");
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
        System.out.println("出队：" + queueBasedOnLinkedList.dequeue());
        System.out.println("队列大小：" + queueBasedOnLinkedList.getSize());
    }

}
