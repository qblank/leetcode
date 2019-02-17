package study.designmode.interpreter;

/**
 * @version 1.0
 * @date 2019/2/17 11:08
 */
public class Scale extends AbstractExpression {
    @Override
    void execute(String key, double value) {
        String scale = "";
        switch ((int) value){
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
            default:
                scale = "低音";
                break;
        }
        System.out.print(scale + " ");
    }
}
