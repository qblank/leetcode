package Study.designMode.strategy;

/**
 * 返利收费子类
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 22:44
 */
public class CashReturn implements CashSuper{
    //返利条件
    private double moneyCondition;
    //返利金额
    private double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition){
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
