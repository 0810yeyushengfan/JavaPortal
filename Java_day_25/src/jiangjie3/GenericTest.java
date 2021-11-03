package jiangjie3;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
    /*
    一.泛型在继承方面的体现:
    1.虽然类A是类B的父类，但是G<A>和G<B>二者不具备子父类关系，二者是并列关系
    2.补充:类A是类B的父类，A<G>是B<G>的父类
     */
    @Test
    public void test1(){
        Object obj=null;
        String str=null;
        obj=str;
        Object[] arr1=null;
        String[] arr2=null;
        arr1=arr2;
//        编译不通过
//        Date date=new Date();
//        str=date;
        List<Object> list1=null;
        List<String> list2=null;
        show(list1);
        //编译不通过
        //show(list2);
        show1(list2);
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
        //list1=list2;
        /*
        反证法:
        假设list1=list2
        list1.add(123);导致只能存入String类型的list存入了非String类型的数据。出错
         */

       AbstractList<String> list3=null;
       List<String> list4=null;
        ArrayList<String> list5=null;
        list3=list5;
        list4=list5;
        List<String> list6=new ArrayList<String>();
    }
    public void show(List<Object> list){
    }
    public void show1(List<String> list){

    }
    /*
    二.通配符的使用
    通配符:?
    类A是类B的父类，G<A>和G<B>是没有子父类关系的，二者共同的父类是G<?>
     */
    @Test
    public void test2(){
        List<Object> list1=new ArrayList<Object>();
        List<String> list2=new ArrayList<String>();
        List<?> list3=null;
        list3=list1;
        list3=list2;
        list1.add("1");
        list2.add("2");
        print(list1);
        print(list2);
        List<String> list4=new ArrayList<String>();
        list4.add("AA");
        list4.add("BB");
        list4.add("CC");
        list3=list4;
        //添加(写入):对于List<?>就不能向其内部添加数据，除了添加null之外
        //编译不通过
//        list3.add("DD");
//        list3.add(123);
//        list3.add('?');
        //编译通过
        list3.add(null);

        //获取(读取):允许读取数据，读取的数据类型均为Object
        Object object=list3.get(0);
        System.out.println(object);
    }
    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while (iterator.hasNext()){
            Object object=iterator.next();
            System.out.println(object);
        }
    }

    /*
    三.有限制条件的通配符的使用
    1. ? extends A:
    G<? extends A> 可以作为G<A>和G<B>的父类的，其中B是A的子类
    即能装的类为[A的所有子类,A]
    2. ? super B:
    G<? extends B>可以作为G<A>和G<B>的父类的，其中B是A的父类
    即能装的类为[B,.....,Object类]

     */
    @Test
    public void test3(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;
        List<Student> list3=new ArrayList<Student>();
        List<Person> list4=new ArrayList<Person>();
        List<Object> list5=new ArrayList<Object>();

        list1=list3;
        list1=list4;
//        list1=list5;
//        list2=list3;
        list2=list4;
        list2=list5;

        //读取数据:
        list1=list3;
        Person p=list1.get(0);
        //编译不通过
        //Student s=list1.get(0);//可能会把Person类赋给Student类
        list2=list4;
        Object object=list2.get(0);
        //编译不通过
        //Person per=list2.get(0);//可能会把Object类赋给Person类

        //写入数据
        //编译不通过
//        list1.add(new Person());//可能会出现Person的子类,person不能赋给person的子类
//        list1.add(new Student());//可能会出现Student的子类,person不能赋给Student的子类
        //编译通过，能赋值Person到Object类中的类，因为Student是Person的子类，根据多态，也能赋值
        list2.add(new Person());
        list2.add(new Student());



    }

}
