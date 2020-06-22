package study.designmode.adapte;

/**
 * @author evan_qb
 * @version 1.0
 * @date 2019/1/31 15:10
 */
public abstract class Player {
    protected String name;

    public Player(String name){
        this.name = name;
    }

    public abstract void attrack();

    public abstract void defense();
}
