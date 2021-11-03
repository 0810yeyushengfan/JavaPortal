package test;

import bean.Department;
import bean.Employee;
import dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBatisDynamicSQLTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //测试if/where
    @Test
    public void test1() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee=new Employee(null,"%e%",null,null);
            List<Employee> employeeList=employeeMapperDynamicSQL.getEmpsByConditionIf(employee);
            for(Employee employee1:employeeList){
                System.out.println(employee1);
            }
        }finally {
            sqlSession.close();
        }
    }

    //测试trim
    @Test
    public void test2() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee=new Employee(null,"%e%",null,null);
            List<Employee> employeeList=employeeMapperDynamicSQL.getEmpsByConditionTrim(employee);
            for(Employee employee1:employeeList){
                System.out.println(employee1);
            }
        }finally {
            sqlSession.close();
        }
    }

    //测试choose
    @Test
    public void test3() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee=new Employee(null,null,null,null);
            List<Employee> employeeList=employeeMapperDynamicSQL.getEmpsByConditionChoose(employee);
            for(Employee employee1:employeeList){
                System.out.println(employee1);
            }
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee=new Employee(3,"test","tttt@qq.com","1");
            employeeMapperDynamicSQL.setEmpsByConditionIf(employee);
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void test5() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> employeeList=employeeMapperDynamicSQL.getEmpsByconditionForeach(Arrays.asList(1,2,3,4,5));
            for(Employee employee1:employeeList){
                System.out.println(employee1);
            }
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test6() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL employeeMapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> employeeList=new ArrayList<>();
            employeeList.add(new Employee(null,"test1","test1@163.com","0",new Department(1)));
            employeeList.add(new Employee(null,"test2","test2@163.com","1",new Department(1)));
            employeeList.add(new Employee(null,"test3","test3@163.com","0",new Department(2)));
            employeeList.add(new Employee(null,"test4","test4@163.com","1",new Department(2)));
            employeeMapperDynamicSQL.addEmps(employeeList);
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void test7() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> employeeList=mapperDynamicSQL.getEmpsTestInnerParameter(null);
            for(Employee employee:employeeList){
                System.out.println(employee);
            }
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test8() throws IOException{
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapperDynamicSQL=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee1=new Employee();
            employee1.setLastName("e");
            List<Employee> employeeList=mapperDynamicSQL.getEmpsTestInnerParameter(employee1);
            for(Employee employee:employeeList){
                System.out.println(employee);
            }
        }finally {
            sqlSession.close();
        }
    }
}
