package Study.designMode.strategy;

/**
 * 上下文
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 23:08
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(String type) {
        switch (type){
            case "normal":
                cashSuper = new CashNormal();
                break;
            case "cashReturn":
                cashSuper = new CashReturn(300,100);
                break;
            case "rebate":
                cashSuper = new CashRebate(0.8);
                break;
            default:
                cashSuper = new CashNormal();
                break;
        }
    }

    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}
