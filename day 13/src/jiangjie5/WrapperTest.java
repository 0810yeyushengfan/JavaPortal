package jiangjie5;


/*
包装类的使用:
1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征。
2.掌握的:基本数据类型，包装类，String三者之间的相互转换。
 */
public class WrapperTest {
    //基本数据类型--->包装类:调用包装类的构造器
    public void test1(){
        int num1=10;
        //System.out.println(num1.toString());因为基本数据类型不是类，所以不能之间调用Object类中的方法。
        Integer in1=new Integer(num1);
        System.out.println(in1.toString());
        Integer in2=new Integer("123");
        System.out.println(in2.toString());
        //报异常
        //Integer in3=new Integer("123abc");
        //System.out.println(in3.toString());
        Float f1=new Float(12.3f);
        Float f2=new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);
        Boolean b1=new Boolean(true);
        Boolean b2=new Boolean("TrUe");
        System.out.println(b2);//true 由此知Boolean包装类不区分大小写（从源码层次可以验证）
        Boolean b3=new Boolean("true123");
        System.out.println(b3);//false  由此知Boolean包装类只要是在忽略大小写之后不是”true“，就一定返回false（从源码层次可以验证）
        Order order=new Order();
        System.out.println(order.isMale);//false
        System.out.println(order.isFemale);//null 证明基本数据类型和包装类的默认值不同
    }
    //包装类--->基本数据类型:调用包装类xxx的xxxValue（）
    public void test2(){
        Integer in1=new Integer(12);
        int i1=in1.intValue();
        System.out.println(i1+1);
        Float f1=new Float(12.2);
        float f2=f1.floatValue();
        System.out.println(f2+1);
    }
    //JDK5.0新特性:自动装箱和自动拆箱。
    public void test3(){
        //自动装箱:基本数据类型--->包装类
        int num1=10;
        Integer in1=num1;//自动装箱
        method(in1);
        boolean b1=true;
        Boolean b2=b1;//自动装箱
        //自动拆箱:包装类--->基本数据类型
        System.out.println(in1.toString());
        int num3=in1;//自动拆箱

    }
    public void method(Object obj)
    {

    }
    //基本数据类型，包装类--->String类型
    public void test4(){
        int num1=10;
        //方式一:连接运算。
        String str1=num1+"";
        //方式二:调用String的valueOf（Xxx xxx）方法。
        float f1=12.3f;
        String str2=String.valueOf(f1);//"12.3"
        Double d1=new Double(12.4);//因为有自动拆箱的特性，所以包装类也能调用String的valueOf方法
        String str3=String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);
    }
    //String类型--->基本数据类型，包装类，调用包装类的parseXxx(String s)
    public void test5(){
        String str1="123";
        //错误的情况:
        //int num1=(int)str1;//想要强转一定要有子父类的关系
        //Integer in1=(Integer)str1;//想要强转一定要有子父类的关系
        //可能会报NumberFormatException的异常
        int num2=Integer.parseInt(str1);
        System.out.println(num2+1);
        //注意boolean类型的特殊性
        String str2="true1";
        boolean b1=Boolean.parseBoolean(str2);
        System.out.println(b1);

    }

}
class Order {
    boolean isMale;
    Boolean isFemale;
}