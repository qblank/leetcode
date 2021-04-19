package Stack.min_stack_155;

/**
 * 155.最小栈
 * 使用一个链表实现栈
 * 新增一个min字段，用于统计最小值
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/18 23:00
 */
public class MinStack {

    private Node head;


    public MinStack(){

    }

    public void push(int val){
        if (head == null){
            head = new Node(val,val);
        }else {
            head = new Node(val,this.min(val,head.min),head);
        }
    }

    public void pop(){
        head = head.next;
    }

    public int top(){
        return head.val;
    }


    public int getMin(){
        return head.min;
    }


    private class Node{
        int val;

        int min;

        Node next;

        private Node(int val,int min){
            this(val,min,null);
        }

        private Node(int val,int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private int min(int x,int y){
        return x < y ? x : y;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("min:" + minStack.getMin());
        minStack.pop();
        System.out.println("top:" + minStack.top());
        System.out.println("min:" + minStack.getMin());
    }
}
