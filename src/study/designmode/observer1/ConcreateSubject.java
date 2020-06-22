package study.designmode.observer1;

/**
 * 具体通知者
 * @version 1.0
 * @date 2019/1/21 22:08
 */
public class ConcreateSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
