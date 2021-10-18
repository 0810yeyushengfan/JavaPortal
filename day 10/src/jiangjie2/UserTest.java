package jiangjie2;
/*
总结：
1.默认初始化
2.显式初始化
3.构造器中赋值
4，通过“对象.方法”或“对象.属性”的方式赋值
以上操作的先后顺序：1->2->3->4(即越靠后优先级越大)
 */
public class UserTest {
    public static void main(String[] args) {
        User u=new User();
        System.out.println(u.age);//证明1<2
        User u1=new User(2);
        System.out.println(u1.age);//证明2<3
        User u2=new User(3);
        u2.setAge(4);
        System.out.println(u2.age);//证明3<4
    }
}
