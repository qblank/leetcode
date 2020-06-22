package study.designmode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 11:28
 */
public class ForenoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12){
            System.out.println(String.format("当前时间：%f点 上午工作，精神百倍",work.getHour()));
        }else{
            //超过12点,转换到中午状态
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
