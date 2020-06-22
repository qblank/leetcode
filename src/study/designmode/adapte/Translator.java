package study.designmode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:25
 */
public class Translator extends Player {
    private ForeignCenter wjzf = new ForeignCenter();

    public Translator(String name) {
        super(name);
        wjzf.setName(name);
    }

    @Override
    public void attrack() {
        wjzf.jinGong();
    }

    @Override
    public void defense() {
        wjzf.fangShou();
    }
}
