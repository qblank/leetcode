package study.designmode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:23
 */
public class ForeignCenter {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void jinGong(){
        System.out.println(String.format("外籍中锋%s进攻",name));
    }

    public void fangShou(){
        System.out.println(String.format("外籍中锋%s防守",name));
    }
}
