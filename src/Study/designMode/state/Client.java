package Study.designMode.state;

/**
 * @version 1.0
 * @date 2019/1/31 11:19
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreateStateA());

        context.request();
        context.request();
        context.request();
        context.request();
    }
}
