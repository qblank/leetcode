package study.designmode.interpreter;

/**
 * @version 1.0
 * @date 2019/2/17 11:26
 */
public class Speed extends AbstractExpression {
    @Override
    void execute(String key, double value) {
        String speed = "";
        if (value < 500){
            speed = "快速";
        }else if (value >= 1000){
            speed = "慢速";
        }else {
            speed = "中速";
        }
        System.out.print(speed + " ");
    }
}
