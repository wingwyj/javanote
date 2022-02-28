package sourcecode.bean;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/8/21 11:49
 */
public class School implements Cloneable {
    private String address;
    private Student student;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "address='" + address + '\'' +
                ", student=" + student +
                '}';
    }

    @Override
    protected School clone() throws CloneNotSupportedException {
        School sc = null;
        sc = (School)super.clone();
        sc.student = student.clone();
        return sc;
    }
}
