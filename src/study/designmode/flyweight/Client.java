package study.designmode.flyweight;

/**
 * @version 1.0
 * @date 2019/2/17 10:21
 */
public class Client {
    public static void main(String[] args) {
        WebsiteFactory factory = new WebsiteFactory();
        //实例化“产品展示”的“网站”对象
        Website fx = factory.getWebsiteCategory("productShow");
        fx.use(new User("evan_qb"));
        //共享上方的对象，不再进行实例化
        Website fy = factory.getWebsiteCategory("productShow");
        fy.use(new User("evan_qc"));
        Website fz = factory.getWebsiteCategory("productShow");
        fz.use(new User("evan_qd"));

        Website fm = factory.getWebsiteCategory("blog");
        fm.use(new User("evan_qe"));
        Website fn = factory.getWebsiteCategory("blog");
        fn.use(new User("evan_qf"));

        System.out.println("网站分类总数为:" + factory.getWebsiteCount());
    }
}
