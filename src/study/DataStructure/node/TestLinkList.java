package study.DataStructure.node;

/**
 * @date 2018/11/2
 */
public class TestLinkList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        //插入
        linkList.insertFirst(34);
        linkList.insertFirst(23);
        linkList.insertFirst(12);
        linkList.insertFirst(2);
        linkList.insertFirst(3);
        //遍历
        linkList.display();
        //删除头部
        linkList.deleteFirst();
        linkList.display();
        //查找
        Node node = linkList.find(23);
        node.display();
        System.out.println();
        //删除指定值
        Node delNode = linkList.delete(23);
        linkList.display();

    }
}
