package jiangjie4;

import org.junit.Test;

import java.util.*;

/*
List接口:存储有序的，可重复的数据。---->“动态”数组，替换原有的数组
一:分类及源码分析
1.ArrayList:作为List接口的主要实现类,是线程不安全的，效率高，底层使用Object[] elementData存储
  1.1.jdk7.0情况下的源码分析:
  ArrayList list=new ArrayList();//底层创建了长度是10的Object[]数组elementData
  list.add(1);//elementData[0]=new Integer(1);
   .......共添加了10个元素
  list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容
  默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
  结论:默认开发中使用带参的构造器:ArrayList List=new ArrayList(int capacity)
  1.2.jdk8.0中ArrayList的变化
  ArrayList list =new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度是10的Object[]数组elementData
  list.add(1);//第一次调用add()时，底层才创建了长度是10的Object[]数组elementData，并将数据1添加到elementData数组中
  ......
  后续的添加和扩容操作与jdk7.0无异。
  1.3.小结:jdk7.0中的ArrayList的对象的创建类似于单例模式的饿汉式，而jdk8.0中的ArrayList的对象的创建
        类似于单例模式的懒汉式，延迟了数组的创建，节省内存。
2.LinkedList:对于频繁的插入和删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
   LinkedList的源码分析:
   LinkedList list=new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
   list.add(123);//将123封装到Node中，创建了Node1对象
   其中，Node定义为:体现了LinkedList的双向链表的说法
   private static class Node<E> {
   E item;
   Node<E> next;
   Node<E> prev;
   Node(Node<E> prev,E element,Node<E> next){
   this.item=element;
   this.next=next;
   this.prev=prev;
      }
   }
3.Vector:作为List接口的古老实现类，是线程安全的，效率低，底层使用Object[] elementData存储
   Vector的源码分析:
   jdk7.0和jdk8.0通过Vector()构造器创建对象时，底层都创建了长度为10的Object[]数组elementData，
   在扩容方面，默认扩容为原来的数组长度的2倍

面试题:ArrayList,LinkedList,Vector三者的异同
同:三个类都是实现了List接口，存储数据的特点相同:存储有序的，可重复的数据
不同:见上

二.List接口中的方法
List除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来操作集合元素的方法。
1.void add(int index, Object ele):在index位置插入ele元素
2.boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
3.Object get(int index):获取指定index位置的元素
4.int indexOf(Object obj):返回obj在集合中首次出现的位置，如果不存在，返回-1
5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置，如果不存在，返回-1
6.Object remove(int index):移除指定index位置的元素，并返回此元素
7.Object set(int index, Object ele):设置指定index位置的元素为ele
8.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置左闭右开区间元素的子集合

总结:针对List接口的常用方法
增:add(Object obj)
删:remove(int index)/remove(Object obj)
改:set(int index,Object ele)
查:get(int index)
插:add(int index,Object ele)
长度:size()
遍历:Iterator迭代器方式遍历
          增强for循环遍历
          普通的循环遍历

三.面试题
请问ArrayList/LinkedList/Vector的异同？谈谈你的理解？ArrayList底层是什么？扩容机制？Vector和ArrayList的最大区别?
1.ArrayList和LinkedList的异同
  二者都线程不安全，相对线程安全的Vector，执行效率高。
  此外，ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。对于随机访问get和set，
  ArrayList觉得优于LinkedList，因为LinkedList要移动指针。对于新增和删除操作add(特指插入)和remove，
  LinkedList比较占优势，因为ArrayList要移动数据。
2.ArrayList和Vector的区别
   Vector和ArrayList几乎是完全相同的,唯一的区别在于Vector是同步类(synchronized)，属于强同步类。
   因此开销就比ArrayList要大，访问要慢。正常情况下,大多数的Java程序员使用ArrayList而不是Vector,
   因为同步完全可以由程序员自己来控制。Vector每次扩容请求其大小的2倍空间，而ArrayList是1.5倍。
   Vector还有一个子类Stack。
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Date());
        list.add(new String("Tom"));
        list.add(false);
        System.out.println(list.size());//6
        System.out.println(list);

        //1.void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list.size());//7
        System.out.println(list);

        //2.boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1= Arrays.asList(1,2,3);
        list.addAll(4,list1);
        System.out.println(list.size());//10
        System.out.println(list);
//        list.add(4,list1);//将list1整体看作一个元素插入list中
//        System.out.println(list.size());//8
//        System.out.println(list);

        //3.Object get(int index):获取指定index位置的元素
        Object obj=list.get(4);
        System.out.println(obj);

    }

    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Date());
        list.add(new String("Tom"));
        list.add(false);
        System.out.println(list.size());//6
        System.out.println(list);
        //4.int indexOf(Object obj):返回obj在集合中首次出现的位置，如果不存在，返回-1
        int index=list.indexOf(123);
        System.out.println(index);
        int index1=list.indexOf(5);
        System.out.println(index1);

        //5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置，如果不存在，返回-1
        list.add(123);
        System.out.println(list.lastIndexOf(123));

        //6.Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj=list.remove(3);
        System.out.println(obj);
        System.out.println(list);

        //7.Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(0,"BB");
        System.out.println(list);

        //8.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置左闭右开区间元素的子集合
        List sublist=list.subList(2,4);
        System.out.println(sublist);
        System.out.println(list);

    }

    @Test
    public void test3(){
        ArrayList list=new ArrayList();
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Date());
        list.add(new String("Tom"));
        list.add(false);

        //方式一:Itreator迭代器方式
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("****************************************");

        //方式二:增强for循环
        for (Object obj:list){
            System.out.println(obj);
        }
        System.out.println("****************************************");

        //方式三:普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
