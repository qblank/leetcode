package study.designmode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:12
 */
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attrack() {
        System.out.println(String.format("前锋%s进攻",name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("前锋%s防守",name));
    }
}
