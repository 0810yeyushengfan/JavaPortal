package test3;

import org.junit.Test;

import java.util.List;

/*
定义一个测试类：
创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
使用 Junit 单元测试类进行测试
 */
public class DAOTest {
    @Test
    public void test(){
        DAO<User> dao=new DAO<User>();
        dao.save("1001",new User(1001,20,"黄少天"));
        dao.save("1002",new User(1002,24,"叶修"));
        dao.save("1003",new User(1003,18,"苏沐橙"));
        dao.update("1003",new User(1003,30,"苏沐秋"));
        dao.delete("1002");
        List<User> list=dao.list();
       // System.out.println(list);
        list.forEach(System.out::println);
    }
}
