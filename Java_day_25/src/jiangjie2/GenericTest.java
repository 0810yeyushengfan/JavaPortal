package jiangjie2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求:如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
        GenericClass genericClass=new GenericClass();
        genericClass.setOrderT(123);
        genericClass.setOrderT("ABC");
        //建议:在实例化时指明类的泛型
       GenericClass<String> genericClass1=new GenericClass<String>();
        genericClass1.setOrderT("AA:hello");
    }

    @Test
    public void test2(){
        SubGenericClass sub1=new SubGenericClass();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        sub1.setOrderT(1122);
        //编译不通过
        //sub1.setOrderT("ABC");
        SubGenericClass1<String> sub2=new SubGenericClass1<String>();
        sub2.setOrderT("ABC");
    }

    @Test
    public void test3(){
        ArrayList<String> list1=null;
        ArrayList<Integer> list2=new ArrayList<>();
        //泛型不同的引用之间不能相互赋值
        //因为每个ArrayList中存的每个数据的位数不同
        //list1=list2;
    }

    //测试泛型方法
    @Test
    public void test4(){
        GenericClass<String> genericClass=new GenericClass<String>();
        Integer[] arr=new Integer[]{1,2,3,4};
        List<Integer> list=genericClass.copyFromArrayTolist(arr);
        System.out.println(list);

    }
}

/*
父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型
1.子类不保留父类的泛型:按需实现
1.1.没有类型 擦除
1.2.指出具体类型
2.子类保留父类的泛型:泛型子类
2.1.全部保留
2.2.部分保留
结论:子类必须是"富二代",子类除了指定或保留父类的泛型，还可以增加自己的泛型
 */
//子类未设置自己的泛型
//class Father<T1, T2> {
//}
//// 子类不保留父类的泛型
//// 1)没有类型 擦除
//class Son1 extends Father {// 等价于class Son extends Father<Object,Object>{
//}
//// 2)具体类型
//class Son2 extends Father<Integer, String> {
//}
//// 子类保留父类的泛型
//// 1)全部保留
//class Son3<T1, T2> extends Father<T1, T2> {
//}
//// 2)部分保留
//class Son4<T2> extends Father<Integer, T2> {
//}

//子类设置了自己的泛型
class Father<T1, T2> {
}
// 子类不保留父类的泛型
// 1)没有类型 擦除
class Son<A, B> extends Father{//等价于class Son extends Father<Object,Object>{
}
// 2)具体类型
class Son2<A, B> extends Father<Integer, String> {
}
// 子类保留父类的泛型
// 1)全部保留
class Son3<T1, T2, A, B> extends Father<T1, T2> {
}
// 2)部分保留
class Son4<T2, A, B> extends Father<Integer, T2> {
}
