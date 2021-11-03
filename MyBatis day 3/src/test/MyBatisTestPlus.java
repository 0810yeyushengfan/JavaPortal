package test;

import bean.Department;
import bean.Employee;
import dao.DepartmentMapper;
import dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTestPlus {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperPlus employeeMapperPlus=openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = employeeMapperPlus.getEmpById(1);
            System.out.println(employeeMapperPlus.getClass());
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperPlus employeeMapperPlus=openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = employeeMapperPlus.getEmpAndDept(1);
            System.out.println(employeeMapperPlus.getClass());
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperPlus employeeMapperPlus=openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = employeeMapperPlus.getEmpByIdStep(1);
            System.out.println(employeeMapperPlus.getClass());
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperPlus employeeMapperPlus=openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = employeeMapperPlus.getEmpByIdStep(1);
            System.out.println(employeeMapperPlus.getClass());
            System.out.println(employee.getEmail());
            System.out.println(employee.getDept());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test5() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper=openSession.getMapper(DepartmentMapper.class);
            Department department=departmentMapper.getDeptById(1);
            System.out.println(department);
            System.out.println(department.getEmps());
        }finally {
            openSession.close();
        }
    }


    @Test
    public void test6() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper=openSession.getMapper(DepartmentMapper.class);
            Department department=departmentMapper.getDeptByIdPlus(1);
            System.out.println(department);
            System.out.println(department.getEmps());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test7() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            DepartmentMapper departmentMapper=openSession.getMapper(DepartmentMapper.class);
            Department department=departmentMapper.getDeptByIdStep(1);
            System.out.println(department);
            System.out.println(department.getEmps());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test8() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapperPlus employeeMapperPlus=openSession.getMapper(EmployeeMapperPlus.class);
            Employee empsByDis = employeeMapperPlus.getEmpsByDis(3);
            System.out.println(empsByDis);
            System.out.println(empsByDis.getEmail());
            System.out.println(empsByDis.getDept());
        }finally {
            openSession.close();
        }
    }

}
