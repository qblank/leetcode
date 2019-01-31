package Study.designMode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 13:15
 */
public class SleepingState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间：%f点 不行了，睡着了",work.getHour()));
    }
}
