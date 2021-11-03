package test;

import bean.Employee;
import dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisCacheTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
        MyBatis的两级缓存机制:
        一级缓存(本地缓存):sqlSession级别的缓存，一级缓存是一直开启的，本质是qlSession级别的一个map
        与数据库同一次会话期间查询到的数据会放在本地缓存中，如果以后需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库
        一级缓存失效的情况(没有使用到当前一级缓存的情况，效果就是还需要向数据库发出查询):
        1.sqlSession不同
        2.sqlSession相同，查询条件不同(即当前一级查询中还没有这个数据)
        3.sqlSession相同，两次查询之间执行了增删改操作(即这次增删改可能对当前数据有影响)
        4.sqlSession相同，手动清除了一级缓存(即缓存清空)
        二级缓存(全局缓存):基于namesapce级别的缓存，一个namespace对应一个二级缓存
        工作机制:
        1.一个会话(sqlSession)，查询一条数据，这个数据就会被放在当前会话的一级缓存中
        2.如果会话关闭，一级缓存中的数据会被保存到二级缓存中，新的会话查询信息，就可以参照二级缓存
        3.sqlSession1===>EmployeeMapper===>Employee
          sqlSession2===>DepartmentMapper===>Department
          不同的namespace查出的数据会放在自己对应的缓存中(map)
          效果:数据会从二级缓存中获取
              查出的数据都会被默认先放在一级缓存中
              只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中

        使用:
        1.开启全局二级缓存配置:在mybatis-config.xml中的settings标签内加入<setting name="cacheEnabled" value="true"/>
        2.去对应的mapper.xml中配置使用二级缓存，即在xxxxMapper.xml的mapper标签里面加入<cache></cache>
        3.我们的POJO需要实现序列化接口(即implements Serializable)
        和缓存有关的设置/属性
        1.cacheEnabled="true/false":false为关闭缓存(二级缓存关闭，一级缓存仍然可用)
        2.每个select标签都有useCache="true/false":false为不使用缓存(不使用二级缓存，一级缓存仍然可用)
        3.每个增删改标签都有flushCache="true/false":true时表示增删改执行完成后就会清除缓存(一级二级都会清除)
          如果设置查询标签的flushCache="true"，每次查询只会都会清除缓存，这样就没有缓存可以保存和获取了
        4.sqlSession.clearSession():只是清除当前session的一级缓存
        5.localCacheScpoe:本地缓存作用域，(默认值为一级缓存SESSION)，即当前会话的所有数据保存在会话缓存中
          可以设置为STATEMENT，表示禁用一级缓存

     */

    //使用了一级缓存的形式
    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            //使用了一级缓存的形式
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee emp01=employeeMapper.getEmpById(1);
            System.out.println(emp01);
            Employee emp02=employeeMapper.getEmpById(1);
            System.out.println(emp02);
            System.out.println(emp01==emp02);
        }finally {
            sqlSession.close();
        }
    }

    //一级缓存失效的情况
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        SqlSession sqlSession2=sqlSessionFactory.openSession();
        try{
//            1.sqlSession不同
            EmployeeMapper employeeMapper1=sqlSession1.getMapper(EmployeeMapper.class);
            EmployeeMapper employeeMapper2=sqlSession2.getMapper(EmployeeMapper.class);
            Employee emp01=employeeMapper1.getEmpById(1);
            System.out.println(emp01);
            Employee emp02=employeeMapper2.getEmpById(1);
            System.out.println(emp02);
            System.out.println(emp01==emp02);
//            2.sqlSession相同，查询条件不同(即当前一级查询中还没有这个数据)
            Employee emp03=employeeMapper1.getEmpById(2);
            System.out.println(emp03);
            System.out.println(emp01==emp03);
//            3.sqlSession相同，两次查询之间执行了增删改操作(即这次增删改可能对当前数据有影响)
            employeeMapper1.addEmp(new Employee(null,"testCache","testCache@test.com","1"));
            Employee emp04=employeeMapper1.getEmpById(1);
            System.out.println(emp04);
            System.out.println(emp01==emp04);
//            4.sqlSession相同，手动清除了一级缓存(即缓存清空)
            sqlSession1.clearCache();
            Employee emp05=employeeMapper1.getEmpById(1);
            System.out.println(emp05);
            System.out.println(emp01==emp05);

        }finally {
            sqlSession1.close();
            sqlSession2.close();
        }
    }

    //使用了第三方缓存的形式
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
        SqlSession sqlSession1=sqlSessionFactory.openSession();
        SqlSession sqlSession2=sqlSessionFactory.openSession();
        try{
            //使用了第三方缓存的形式
            //第二次查询是从第三方缓存中拿到的数据，并没有发送新的sql
            EmployeeMapper employeeMapper1=sqlSession1.getMapper(EmployeeMapper.class);
            EmployeeMapper employeeMapper2=sqlSession2.getMapper(EmployeeMapper.class);
            Employee emp01=employeeMapper1.getEmpById(10);
            System.out.println(emp01);
            sqlSession1.close();
            Employee emp02=employeeMapper2.getEmpById(10);
            System.out.println(emp02);
            System.out.println(emp01==emp02);
            sqlSession2.close();
        }finally {

        }

    }

}
