package pattern.single;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 22:12
 */
public class SingleTest {
    public static void main(String[] args) {
        SingleEnum.INSTANCE.hello();
        SingleInclass.getInstance().hello();
    }
}
