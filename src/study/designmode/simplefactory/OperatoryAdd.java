package study.designmode.simplefactory;

/**
 * 加法
 * @author yqb
 * @version 1.0
 * @date 2018/12/18 22:31
 */
public class OperatoryAdd extends Operation{

    @Override
    public double getResult(Operation operation) {
        double result = operation.getNumA() + operation.getNumB();
        return result;
    }
}
