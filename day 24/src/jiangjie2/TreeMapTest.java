package jiangjie2;

import org.junit.Test;

import java.util.*;

/*
向TreeMap中添加key-value，要求key必须是同一个类创建的对象
因为要按照key进行排序:自然排序，定制排序
不能按照value进行排序
 */
public class TreeMapTest {
    //自然排序
    @Test
    public void test1(){
        TreeMap treeMap=new TreeMap();
        User u1=new User("Tom",12);
        User u2=new User("Tony",17);
        User u3=new User("Jary",54);
        User u4=new User("Jark",32);
        User u5=new User("Ancy",124);
        treeMap.put(u1,94);
        treeMap.put(u2,54);
        treeMap.put(u3,34);
        treeMap.put(u4,35);
        treeMap.put(u5,56);
        Set entrySet= treeMap.entrySet();
        Iterator iterator=entrySet.iterator();
        while(iterator.hasNext()){
            Object object=iterator.next();
            Map.Entry entry=(Map.Entry) object;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }
    //定制排序
    @Test
    public void test2(){
        TreeMap treeMap=new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User&&o2 instanceof User){
                    User u1=(User) o1;
                    User u2=(User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        User u1=new User("Tom",12);
        User u2=new User("Tony",17);
        User u3=new User("Jary",54);
        User u4=new User("Jark",32);
        User u5=new User("Ancy",124);
        treeMap.put(u1,94);
        treeMap.put(u2,54);
        treeMap.put(u3,34);
        treeMap.put(u4,35);
        treeMap.put(u5,56);
        Set entrySet= treeMap.entrySet();
        Iterator iterator=entrySet.iterator();
        while(iterator.hasNext()){
            Object object=iterator.next();
            Map.Entry entry=(Map.Entry) object;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }
}
