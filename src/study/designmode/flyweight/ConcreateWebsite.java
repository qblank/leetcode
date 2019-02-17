package study.designmode.flyweight;

/**
 * @version 1.0
 * @date 2019/2/17 10:15
 */
public class ConcreateWebsite implements Website {
    private String name;

    public ConcreateWebsite(String name){
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类：" + name + ",用户：" + user.getName());
    }
}
