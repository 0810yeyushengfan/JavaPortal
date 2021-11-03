package test1;
/*
在PersonTest类中实例化Person类的对象b
调用setAge()和getAge()方法，体会java的封装性

1.练习1
创建程序，在其中定义两个类：Person和PersonTest类。定义如下：
用setAge()设置人的合法年龄（0~130），用getAge（）返回人的年龄。
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
//        p1.age=1;编译不通过
        p1.setAge(12);
        System.out.println("年龄为:"+p1.getAge());
//      p1.doAge(12);
    }

}
