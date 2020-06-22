package study.designmode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:18
 */
public class Center extends Player {
    public Center(String name) {
        super(name);
    }

    @Override
    public void attrack() {
        System.out.println(String.format("中锋%s进攻",name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("中锋%s防守",name));
    }
}
