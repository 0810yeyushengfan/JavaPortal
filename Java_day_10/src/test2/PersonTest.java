package test2;
/*
2.练习2
2.1. 在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18
2.2. 修改上题中类和构造器，增加name属性，使得每次创建Person对象的同时初始化对象的age属性值和name属性
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person("Tom",21);
        System.out.println("name="+p1.getName()+'\n'+"age="+p1.getAge());
        Person p2=new Person("haha");
        System.out.println("name="+p2.getName()+'\n'+"age="+p2.getAge());
        Person p3=new Person();
        System.out.println("name="+p3.getName()+'\n'+"age="+p3.getAge());
    }
}
