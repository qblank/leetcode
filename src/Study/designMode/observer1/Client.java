package Study.designMode.observer1;

/**
 * @version 1.0
 * @date 2019/1/21 22:18
 */
public class Client {
    public static void main(String[] args) {
        ConcreateSubject s = new ConcreateSubject();
        s.attach(new ConcreateObserver("X",s));
        s.attach(new ConcreateObserver("Y",s));
        s.attach(new ConcreateObserver("Z",s));

        s.setSubjectState("ABC");
        s.notifyIt();

    }
}
