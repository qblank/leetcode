package study.designmode.strategy;

/**
 * 客户端
 * @author yqb
 * @version 1.0
 * @date 2018/12/19 23:01
 */
public class Client {
    public static void main(String[] args) {
        double total = 0;
        int count = 3;
        /*简单工厂方法*/
        /*CashSuper cashSuper = CashFactory.createCashAccept("cashReturn");
        double totalPrice = cashSuper.acceptCash(4) * count;
        total += totalPrice;
        System.out.println(total);*/
        /*策略模式+简单工厂*/
        CashContext context = new CashContext("cashReturn");
        double result = context.getResult(100 * count) ;
        System.out.println(result);
    }
}
