package Study.designMode.state_work;

/**
 * @version 1.0
 * @date 2019/1/31 13:18
 */
public class Client {
    public static void main(String[] args) {
        Work emergencyProject = new Work();
        for (int i = 9; i <= 24; i++) {
            try {
                Thread.sleep(10);
                if (i == 24){
                    emergencyProject.setHour(i);
                    emergencyProject.setFinish(true);
                    emergencyProject.writeProgram();
                    return;
                }
                emergencyProject.setHour(i);
                emergencyProject.writeProgram();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
