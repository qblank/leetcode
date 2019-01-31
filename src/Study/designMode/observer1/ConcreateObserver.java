package Study.designMode.observer1;

/**
 * 具体观察者
 * @version 1.0
 * @date 2019/1/21 22:13
 */
public class ConcreateObserver implements Observer{
    private String name;

    private String observerState;

    private ConcreateSubject subject;

    public ConcreateObserver(String name, ConcreateSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者" + name + "的新状态是:" + observerState);
    }

    public ConcreateSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreateSubject subject) {
        this.subject = subject;
    }
}
