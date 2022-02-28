package sourcecode.bean;

/**
 * clone()是浅拷贝
 * 1.如果对象中的引用类型clone后会也原对象使用的是一个对象
 * 2.可以在最外层对象的clone方法中同时clone对象的引用类型 可以实现深拷贝
 *
 * @author wangyingjie
 * @version 1.0
 * @date 2021/8/21 11:50
 */
public class CloneTest {
    public static void main(String[] args) throws Exception {
        School sc1 = new School();
        sc1.setAddress("上海松江");

        Student stu1 = new Student();
        stu1.setIdenty(1001);
        stu1.setAge(20);
        stu1.setClassNamber("软件开发");
        stu1.setName("james");
        sc1.setStudent(stu1);

        School sc2 = sc1.clone();
        System.out.println(sc1.hashCode() == sc2.hashCode());
        System.out.println(sc1.getStudent().hashCode() == sc2.getStudent().hashCode());
        System.out.println(sc1);
        System.out.println(sc2);
    }
}
