package bean;

public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    //员工状态
    private EmpStatus empStatus=EmpStatus.LOGOUT;

    public Employee(String lastName, String email, String gender, EmpStatus empStatus) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.empStatus = empStatus;
    }

    public Employee(Integer id, String lastName, String email, String gender, EmpStatus empStatus) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.empStatus = empStatus;
    }

    public EmpStatus getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(EmpStatus empStatus) {
        this.empStatus = empStatus;
    }

    public Employee() {
    }

    public Employee(String lastName, String email, String gender) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public Employee(Integer id, String lastName, String email, String gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
