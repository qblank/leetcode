package Study.designMode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 13:12
 */
public class EveningState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()){
            //下班
            work.setState(new RestState());
            work.writeProgram();
        }else{
            if (work.getHour() < 21){
                System.out.println(String.format("当前时间：%f点 加班中，疲累之极",work.getHour()));
            }else{
                //超过21点，睡眠工作状态
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
