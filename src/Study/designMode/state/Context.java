package Study.designMode.state;

/**
 * 用户定义当前的状态
 * @version 1.0
 * @date 2019/1/31 11:15
 */
public class Context {
    private State state;

    public Context(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request(){
        state.handle(this);
    }
}
