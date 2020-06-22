package study.designmode.state;

/**
 * @version 1.0
 * @date 2019/1/31 11:17
 */
public class ConcreateStateB implements State {
    @Override
    public void handle(Context context) {
        //设置B的状态一定是A
        context.setState(new ConcreateStateA());
    }
}
