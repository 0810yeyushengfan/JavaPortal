package test;

import bean.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

  /*
        插件原理:
        1.在四大对象创建的时候，每个创建出来的对象不是直接返回的，而是调用了interceptorChain.pluginAll(parameterHandler)进行包装
        2.获取到所有的Interceptor(拦截器即插件需要实现的接口)，调用interceptor.plugin(target)，返回target包装后的对象
        3.插件机制:我们可以使用插件为目标对象创建一个代理对象，思想类似于Spring的AOP(面向切面编程)思想，我们的插件可以为四大对象
                  创建出一个代理对象，代理对象就可以拦截到四大对象的每一个执行并对指定执行进行性能增强
        插件编写:
        1.编写Interceptor的实现类
        2.使用@Intercepts注解完成插件签名
        3.将写好的插件注册到全局配置文件中

   */

    @Test
    public void test1() throws IOException {
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

    //分页插件(PageHelper)的使用
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
            Page<Object> page = PageHelper.startPage(4, 3);
            List<Employee> list = employeeMapper.getEmps();
            //第二个参数传入要连续显示多少页
            PageInfo<Employee> pageInfo= new PageInfo<>(list,3);
             for(Employee employee:list){
              System.out.println(employee);
            }
//            System.out.println("当前页码:"+page.getPageNum());
//            System.out.println("总记录数:"+page.getTotal());
//            System.out.println("每页的记录数:"+page.getPageSize());
//            System.out.println("总页码:"+page.getPages());
              System.out.println("当前页码:"+pageInfo.getPageNum());
              System.out.println("总记录数:"+pageInfo.getTotal());
              System.out.println("每页的记录数:"+pageInfo.getPageSize());
              System.out.println("总页码:"+pageInfo.getPages());
              System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
            for (int navigatepageNum : pageInfo.getNavigatepageNums()) {
                System.out.println(navigatepageNum);
            }
        }finally {
            openSession.close();
        }

    }
}
