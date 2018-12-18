package Study.designMode.simplefactory;

/**
 * @author yqb
 * @version 1.0
 * @date 2018/12/18 22:39
 */
public class OperationFactory {

    private OperationFactory(){}

    public static Operation createOperate(String operate){
        Operation operation = null;
        switch (operate){
            case "+":
                operation = new OperatoryAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
        }
        return operation;
    }
}
