package test;

import bean.EmpStatus;
import bean.Employee;
import dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    //测试批量插入
    @Test
    public void test1() throws IOException {
        //1.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory =getSqlSessionFactory();
        //2.获取可以执行批量操作的sqlSession对象
        SqlSession openSession=sqlSessionFactory.openSession(ExecutorType.BATCH);
        long start = System.currentTimeMillis();
        try{
            //3.获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
            for(int i=0;i<10000;i++){
                employeeMapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0,5),"test@henu.com","0"));
            }
            openSession.commit();
            //批量操作:预编译sql1次->设置参数1w次->批量执行1次
            //非批量操作:(预编译sql+设置参数+执行)1万次
            long end = System.currentTimeMillis();
            System.out.println("执行时常:"+(end-start));
        }finally {
            openSession.close();
        }

    }

    @Test
    public void testEnumUse(){
        EmpStatus login=EmpStatus.LOGIN;
        System.out.println("枚举的索引:"+login.ordinal());
        System.out.println("枚举的名字:"+login.name());
        System.out.println("枚举的状态码:"+login.getCode());
        System.out.println("枚举的提示信息:"+login.getMsg());
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=new Employee("test_enum","enum@haha.com","1",EmpStatus.LOGIN);
            mapper.addEmpWithStatus(employee);
            sqlSession.commit();
            Employee employee1=mapper.getEmpById(10031);
            System.out.println(employee1.getEmpStatus());
        }finally {
            sqlSession.close();
        }
    }

}
