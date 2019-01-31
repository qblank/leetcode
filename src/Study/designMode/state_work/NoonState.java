package Study.designMode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 13:09
 */
public class NoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13){
            System.out.println(String.format("当前时间：%f点 饿了；犯困，午休。",work.getHour()));
        }else{
            work.setState(new AfternoonState());
        }
    }
}
