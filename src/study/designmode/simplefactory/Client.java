package study.designmode.simplefactory;

/**
 * @author yqb
 * @version 1.0
 * @date 2018/12/18 22:43
 */
public class Client {
    public static void main(String[] args) {
        Operation operate = OperationFactory.createOperate("-");
        operate.setNumA(1);
        operate.setNumB(2);
        double result = operate.getResult(operate);
        System.out.println(result);
    }
}
