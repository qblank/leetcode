package Study.DataStructure.node;

/**
 * @date 2018/10/31
 * 节点
 */
public class Node {
    //数据域
    public long data;
    //指针域
    public Node next;

    public Node() {

    }

    public Node(long data) {
        this.data = data;
    }

    public void display(){
        System.out.print(this.data + " ");
    }
}
