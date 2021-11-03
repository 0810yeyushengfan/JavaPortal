package jiangjie1;

import org.junit.Test;

import java.util.*;

/*
泛型的使用:
1.jdk5.0新增的特性
2.在集合中使用泛型:
总结:
2.1.集合接口或集合类在jdk5.0时都修改为带泛型的结构。
2.2.在实例化集合类时，可以指明具体的泛型类型
2.3.指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如方法，构造器，属性等)使用到类的泛型的位置，都指定为实例化的泛型类型。
      比如，add(E e)---->实例化以后:add(Integer e)
2.4.注意点:泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，拿包装类替换
2.5.如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型
3.如何自定义泛型结构:泛型类，泛型接口和泛型方法，见jiangjie2
 */
public class GenericTest {
    //不使用泛型会出现的问题
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        //需求:存放学生的成绩
        list.add(100);
        list.add(30);
        list.add(56);
        list.add(69);
        //问题一:类型不安全
        //list.add("Tom");
        for(Object score:list){
            //问题二:强转时可能会出现ClassCastException的异常
            int subscore=(Integer)score;
            System.out.println(subscore);
        }
    }

    //使用泛型能够解决的问题
    @Test
    public void test2(){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(100);
        list.add(30);
        list.add(56);
        list.add(69);
        //编译时，就会进行类型检查，保证数据的安全
        //list.add("Tom");
        for(Integer score:list){
            //避免了强转操作
            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("Tom",87);
        map.put("Jerry",93);
        map.put("Jack",29);
        //map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key=next.getKey();
            int value=next.getValue();
            System.out.println(key+"------>"+value);
        }
    }
}
