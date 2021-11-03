package dao;


import bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//用于接口式编程，不需要显式写出此接口的实现类
public interface EmployeeMapper {
    //返回多条记录封装的一个map，Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的JavaBean
    @MapKey("id")
    public Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);

    //返回一条记录的map，key就是列名，值就是对应的值
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    public List<Employee> getEmpsByLastNameLike(String lastName);

    public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);

    public Employee getEmpByMap(Map<String,Object> map);

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public boolean deleteEmpById(Integer id);
}
