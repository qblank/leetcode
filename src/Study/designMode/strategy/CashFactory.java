package Study.designMode.strategy;

/**
 * 现金收费工厂
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 22:49
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type){
        CashSuper cashSuper = null;
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
        }
        return cashSuper;
    }
}
