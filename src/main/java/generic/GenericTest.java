package generic;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 22:40
 *
 * 泛型
 *   1.泛型接口
 *   2.泛型类
 *   3.泛型方法
 *
 */
public class GenericTest {
    public static void main(String[] args) {
        Generic genericInt = new Generic<Integer>(888);
        Generic genericStr = new Generic<String>("AAA");
        System.out.println(genericInt.getClass());
        System.out.println(genericStr.getClass());
        System.out.println(genericInt.getClass() == genericStr.getClass());
    }
}
