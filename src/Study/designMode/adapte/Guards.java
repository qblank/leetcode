package Study.designMode.adapte;

/**
 * @version 1.0
 * @date 2019/1/31 15:19
 */
public class Guards extends Player{
    public Guards(String name) {
        super(name);
    }

    @Override
    public void attrack() {
        System.out.println(String.format("后卫%s进攻",name));
    }

    @Override
    public void defense() {
        System.out.println(String.format("后卫%s防守",name));
    }
}
