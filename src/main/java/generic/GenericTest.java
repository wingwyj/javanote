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
        Generic BB = new Generic<EmployBB>(new EmployBB());
        Generic AA = new Generic<EmployeeAA>(new EmployeeAA());
//        Generic AA = new Generic<EmployeeCC>(new EmployeeAA());
        
        AA.work();
        BB.work();
    }
}
