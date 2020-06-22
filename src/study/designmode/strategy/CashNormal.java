package study.designmode.strategy;

/**
 * 正常收费类
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 22:38
 */
public class CashNormal implements  CashSuper{

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
