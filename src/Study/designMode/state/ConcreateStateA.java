package Study.designMode.state;


/**
 * @version 1.0
 * @date 2019/1/31 11:14
 */
public class ConcreateStateA implements State {
    @Override
    public void handle(Context context) {
        //设置A的状态一定是B
        context.setState(new ConcreateStateB());
    }
}
