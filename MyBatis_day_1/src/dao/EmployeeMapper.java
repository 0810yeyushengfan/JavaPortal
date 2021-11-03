package dao;

import bean.Employee;

//用于接口式编程，不需要显式写出此接口的实现类
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);
}
