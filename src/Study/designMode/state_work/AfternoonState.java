package Study.designMode.state_work;

/**
 * 下午
 * @version 1.0
 * @date 2019/1/31 13:11
 */
public class AfternoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17){
            System.out.println(String.format("当前时间：%f点 下午状态还不错，继续努力",work.getHour()));
        }else{
            //晚上
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
