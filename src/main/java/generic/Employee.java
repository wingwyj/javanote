package generic;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/20 0:01
 * 员工基础类
 */
public abstract class Employee{

    public abstract void work();

    private int employeeId;
    private String name;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
