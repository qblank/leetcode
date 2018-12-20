package Study.designMode.strategy;

/**
 * 打折收费类
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 22:42
 */
public class CashRebate implements CashSuper{

    private double moneyRebate;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }


    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
