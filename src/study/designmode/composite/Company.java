package study.designmode.composite;

/**
 * @version 1.0
 * @date 2019/1/31 17:02
 */
public abstract class Company {
    protected String name;

    public Company(String name){
        this.name = name;
    }

    public abstract void add(Company c);

    public abstract void remove(Company c);

    public abstract void display(int depth);

    /**
     * 履行职责
     */
    public abstract void lineOfDuty();
}
