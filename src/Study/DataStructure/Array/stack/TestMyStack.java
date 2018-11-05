package Study.DataStructure.Array.stack;


/**
 * @date 2018/10/26
 * 测试类
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyStack ms = new MyStack(4);
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.isEmpty());
        System.out.println(ms.isFull());

        while (!ms.isEmpty()){
            System.out.println(ms.pop());
        }
        System.out.println(ms.isEmpty());

    }
}
