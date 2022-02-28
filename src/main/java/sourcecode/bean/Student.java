package sourcecode.bean;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/8/21 11:47
 */
public class Student implements Cloneable {
    private int identy;
    private int age;
    private String name;
    /**
     * 班级
     */
    private String classNamber;

    public int getIdenty() {
        return identy;
    }

    public void setIdenty(int identy) {
        this.identy = identy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassNamber() {
        return classNamber;
    }

    public void setClassNamber(String classNamber) {
        this.classNamber = classNamber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "identy=" + identy +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", classNamber='" + classNamber + '\'' +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}
