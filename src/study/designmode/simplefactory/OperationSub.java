package study.designmode.simplefactory;

/**
 * @author yqb
 * @version 1.0
 * @date 2018/12/18 22:42
 */
public class OperationSub extends Operation {

    @Override
    public double getResult(Operation operation) {
        double result = 0;
        result = operation.getNumA() - operation.getNumB();
        return result;
    }
}
