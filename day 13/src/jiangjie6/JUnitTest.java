package jiangjie6;

import org.junit.Test;

/*
java中的Junit单元测试（eclipse版）
步骤:
1.选中当前工程-右键选择:build path-add libraries-JUnit 4-下一步
2.创建java类，进行单元测试。
  此时java类的要求:2.1此类是public。
                 2.2此类要提供公共的无参的构造器。
3.此类中声明单元测试方法。
  此时的单元测试方法:方法的权限是public，没有返回值，没有形参。
4.此单元测试方法上需要声明注解:@Test，并在单元测试类中导入:import org.junit.Test
5.声明好单元测试方法以后，就可以再方法体内测试相关的代码。
6.写好代码以后，左键双击单元测试方法名，右键，run 奥赛-JUnit Test
说明:
1.如果执行结果没有任何异常，绿条。
2.如果执行结果有异常，红条。

 */
public class JUnitTest {
    int num=10;
    public void testEquals(){
        String s1="MM";
        String s2="MM";
        System.out.println(s1.equals(s2));
        //ClassCastException的异常
        //Object obj=new String("GG);
        //Date date=(Date)obj;
        System.out.println(num);

    }
    public void show(){
        num=20;
        System.out.println("show()..........");
    }
    public void testToString(){
        String s2="MM";
        System.out.println(s2.toString());
    }
    @Test
    public void test1(){
        System.out.println("我是单元测试方法");
    }

}
