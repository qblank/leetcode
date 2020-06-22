package study.designmode.simplefactory;

/**
 * 运算类
 * @author yqb
 * @version 1.0
 * @date 2018/12/18 22:29
 */
public class Operation {
    double numA = 0;

    double numB = 0;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public double getResult(Operation operation){
        return 0;
    }

}
