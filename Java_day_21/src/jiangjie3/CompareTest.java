package jiangjie3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.sort;

/*
一.说明:java中的对象，在正常情况下，只能进行 ==和！=比较，不能使用>或<。
                但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
                如何实现?使用两个接口中的任何一个:Comparable/Comparator
二.Comparable的使用
 */
public class CompareTest {
    /*
    Comparable接口的使用举例:自然排序(在sort()方法外使用)
    1.像String,包装类等自己已经实现了Comparable接口，重写了compareTo(Object obj)方法，给出了比较两个对象规则
    2.像String,包装类重写了compareTo(Object obj)方法以合，进行了从小到大的排列
    3.重写compareTo(Object obj)的规则:
       如果当前对象this大 于形参对象obj，则返回正整数。
       如果当前对象this小于形参对象obj，则返回负整数。
       如果当前对象this等于形参对象obj，则返回零。
    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(Object obj)方法，
       在compareTo(Object obj)方法中指明如何排序
     */

    @Test
    public void testComparable1(){
        String[] arr=new String[]{"AA","BB","CC","DD","EE","FF","GG"};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void testComparable2(){
        Goods[] goods=new Goods[5];
        goods[0]=new Goods("lenovoMouse",34);
        goods[1]=new Goods("xiaomiMouse",45);
        goods[2]=new Goods("huaweiMouse",575);
        goods[3]=new Goods("microsoftMouse",23);
        goods[4]=new Goods("dellMouse",314);
        sort(goods);
        System.out.println(Arrays.toString(goods));

    }

    /*
    Comparator接口的使用:定制排序(在sort()方法中使用)
    1.背景
     当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口
     的排序规则不适合当前的操作，那么可以考虑把使用Comparator的对象来排序
     2.重写compare(object o1,Object o2)方法:比较o1和o2的大小
     如果方法返回正整数，则表示o1大于o2
     如果返回0，表示相等
     如果返回负整数，表示o1小于o2
     */

    @Test
    public void test3(){
        String[] arr=new String[]{"AA","BB","CC","DD","EE","FF","GG"};
        //因为Comparator的对象实例化后基本上只会用到一次，所以直接通过匿名子类的方式实例化即可
        sort(arr,new Comparator(){
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String&&o2 instanceof String){
                    String s1=(String) o1;
                    String s2=(String) o2;
                    return -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException(("输入的数据类型不一致"));
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] goods=new Goods[6];
        goods[0]=new Goods("lenovoMouse",34);
        goods[1]=new Goods("xiaomiMouse",45);
        goods[2]=new Goods("huaweiMouse",575);
        goods[3]=new Goods("microsoftMouse",23);
        goods[4]=new Goods("dellMouse",314);
        goods[5]=new Goods("huaweiMouse",5751);
        sort(goods, new Comparator() {
            @Override
            public int compare(Object o1,Object o2) {
                //指明商品比较大小的方式:按照产品名称从低到高排序，再按照价格从高到低排序
                if(o1 instanceof Goods&&o2 instanceof Goods){
                    Goods g1=(Goods) o1;
                    Goods g2=(Goods) o2;
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(goods));
    }

}
