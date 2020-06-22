package study.DataStructure.FirstNodeLast;

/**
 * @date 2018/11/5
 */
public class TestFirstLinkList {
    public static void main(String[] args) {
        FirstLastLinkList fl = new FirstLastLinkList();
        fl.insertFirst(1);
        fl.insertFirst(3);
        fl.insertFirst(5);

        fl.deleteFirst();
        fl.display();

        fl.insertLast(7);
        fl.insertLast(9);
        fl.insertLast(10);

        fl.delete(10);
        fl.display();

    }
}
