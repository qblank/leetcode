package study.DataStructure.node;

/**
 * @date 2018/10/31
 * 单链表
 */
public class LinkList {

    private Node first;

    /**
     * 插入一个节点,在头节点结束后进行插入
     * @param value
     */
    public void insertFirst(long value){
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    /**
     * 删除一个节点，在头节点结束后进行删除
     */
    public Node deleteFirst(){
        Node tmp = first;
        first = tmp.next;
        return tmp;
    }

    /**
     * 遍历链表
     */
    public void display(){
        Node current = first;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 查找
     * @param value
     * @return
     */
    public Node find(long value){
        Node current = first;
        while (current.data != value){
            if (current.next == null) return null;
            current = current.next;
        }
        return current;
    }

    /**
     * 删除方法，根据数据删除
     * 找到它前面的节点
     * @param value
     * @return
     */
    public Node delete(long value){
        Node current = first;
        Node prev = first;
        while (current.data != value){
            if (current.next == null) return null;
            prev = current;
            current = current.next;
        }
        if (current == first){
            first = first.next;
        }else{
            prev.next = current.next;
        }
        return current;
    }
}
