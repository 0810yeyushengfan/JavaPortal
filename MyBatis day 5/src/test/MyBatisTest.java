package test;

import dao.EmployeeMapper;
import dao.EmployeeMapperAnnotation;
import bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
小结:
1.接口式编程:
原生:         Dao         ====>   DaoImp1
mybatis:    Mapper       ====>   xxMapper.xml
2.SqlSession代表和数据库的一次绘画，用完必须关闭
3.SqlSession和Connection一样都是非线程安全的，每次使用都应该去获取新的对象，不可以写成成员变量的形式，会在多线程情况下发生资源竞争
4.mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象(将接口和xml进行绑定)
   EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
5.两个重要的配置文件:
  5.1.mybatis的全局配置文件:包含数据库连接池信息，事务管理器信息等系统运行环境信息
  5.2.sql映射文件:保存了每一个sql语句的映射信息，mybatis通过这个配置文件将sql抽取出来
 */
public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws Exception {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //获取sqlSession实例，能直接执行已经映射的sql语句
            SqlSession openSession=sqlSessionFactory.openSession();
            try{
                //selectOne(String statement,Object parameter)的两个参数:
                //statement:Unique identifier matching the statement to use.
                //parameter:A parameter object to pass to the statement.
                Employee employee = openSession.selectOne("helloWorld.EmployeeMapper.selectEmp", 1);
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
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmpById(1);
            System.out.println(employeeMapper.getClass());
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
            EmployeeMapperAnnotation employeeMapperAnnotation=openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = employeeMapperAnnotation.getEmpById(1);
            System.out.println(employeeMapperAnnotation.getClass());
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }


    /*
    测试增删改:
    1.mybatis允许增删改直接定义以下类型返回值
      Integer,Long,Boolean,void
    2.我们需要手动提交数据
      sqlSessionFactory.openSession()====>手动提交
      sqlSessionFactory.openSession(true)====>自动提交
     */
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //1.获取到的SqlSession不会自动提交数据
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            //测试添加
            Employee employee=new Employee(null,"jerry","jerry@qq.com","1");
            employeeMapper.addEmp(employee);
            System.out.println(employee.getId());
            //测试修改
//            Employee employee=new Employee(1,"haha","haha@163.com","1");
//            employeeMapper.updateEmp(employee);
            //测试删除
//            boolean deleteEmp=employeeMapper.deleteEmpById(2);
//            System.out.println(deleteEmp);
            //2.手动提交数据
            openSession.commit();
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
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmpByIdAndLastName(1,"haha");
            System.out.println(employeeMapper.getClass());
            System.out.println(employee);
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
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            Map<String,Object> map=new HashMap();
            map.put("id",1);
            map.put("lastName","haha");
            Employee employee = employeeMapper.getEmpByMap(map);
            System.out.println(employeeMapper.getClass());
            System.out.println(employee);
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
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            List<Employee> listEmployee= employeeMapper.getEmpsByLastNameLike("%h%");
            System.out.println(employeeMapper.getClass());
           for(Employee employee:listEmployee){
               System.out.println(employee);
           }
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
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            Map<String,Object> mapEmployee= employeeMapper.getEmpByIdReturnMap(1);
            System.out.println(employeeMapper.getClass());
            System.out.println(mapEmployee);
        }finally {
            openSession.close();
        }
    }


    @Test
    public void test9() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            Map<Integer,Employee> mapEmployee= employeeMapper.getEmpByLastNameLikeReturnMap("%e%");
            System.out.println(employeeMapper.getClass());
            System.out.println(mapEmployee);
        }finally {
            openSession.close();
        }
    }
}
