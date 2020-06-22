package study.designmode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:20
 */
public class Client {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attrack();
        Player m = new Guards("麦克格雷迪");
        m.attrack();
        Player ym = new Translator("姚明");
        ym.attrack();
        ym.defense();

    }
}
