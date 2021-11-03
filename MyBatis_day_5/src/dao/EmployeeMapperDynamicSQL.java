package dao;

import bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    //参数携带了哪个字段，查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void setEmpsByConditionIf(Employee employee);

    //查询在给定集合中的员工id的员工信息
    public List<Employee> getEmpsByconditionForeach(@Param("ids") List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
