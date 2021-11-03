package test;

import dao.EmployeeMapper;
import bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
    /*
    一般步骤
    1.xml配置文件(全局配置文件):有数据源和一些运行环境信息
    2.sql映射文件:配置了每一个sql以及sql的封装规则等
    3.将sql映射文件注册在全局配置文件中
    4.写代码:
      4.1.根据全局配置文件得到sqlSessionFactory
      4.2.使用sqlSessionFactory工厂，获取到sqlSession对象，使用它来执行增删改查，一个sqlSession就是代表和数据库的一次会话，用完要将sqlSession关闭
      4.3.使用sql的唯一标识来告诉MyBatis执行哪一个sql，sql都是保存在sql映射文件中的
 */
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
}
