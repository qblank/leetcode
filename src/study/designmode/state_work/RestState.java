package study.designmode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 13:16
 */
public class RestState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间：%f点 下班回家",work.getHour()));
    }
}
