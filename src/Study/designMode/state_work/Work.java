package Study.designMode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 11:26
 */
public class Work {
    private State current;

    private double hour;

    private boolean finish = false;

    public Work(){
        current = new ForenoonState();
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setState(State s){
        current = s;
    }

    public void writeProgram(){
        current.writeProgram(this);
    }
}
