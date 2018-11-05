package Study.DataStructure.Array.stack;

/**
 * @date 2018/10/26
 * 栈的实现
 */
public class MyStack {
    //底层实现
    private long[] arr;
    private int top;

    public MyStack() {
        arr = new long[10];
        top = -1;
    }

    public MyStack(int maxSize){
        arr = new long[maxSize];
        top = -1;
    }

    /**
     * 添加数据
     * @param value
     */
    public void push(int value){
        arr[++top] = value;
    }

    /**
     * 移除数据
     * @return
     */
    public long pop(){
        return arr[top--];
    }

    /**
     * 查看数据
     * @return
     */
    public long peek(){
        return arr[top];
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 判断是否满了
     * @return
     */
    public boolean isFull(){
        return top == arr.length - 1;
    }

}
