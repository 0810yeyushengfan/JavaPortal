package bean;


import java.util.List;

public class Department {
    private Integer id;
    private String departmentName;

    public List<Employee> getEmps() {
        return emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public Department(Integer id, String departmentName, List<Employee> emps) {
        this.id = id;
        this.departmentName = departmentName;
        this.emps = emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    private List<Employee> emps;

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
