package jiangjie2;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
集合元素的遍历操作，使用迭代器Iterator接口
1.内部的方法:hasNext()和next()
2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
3.内部定义了remove()，可以在遍历的时候删除集合中的元素，此方法不同于集合直接调用remove()
 */
public class IteratorTest {

    @Test
    public void  test1(){
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry",20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator=collection.iterator();
        //方式一:
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //报异常:System.out.println(iterator.next());
//         System.out.println(iterator.next());
        //方式二(不推荐):
//        for(int i=0;i<collection.size();i++){
////            System.out.println(iterator.next());
////        }
        //方式三(推荐):
        //hasNext():判断是否还有下一个元素
        while(iterator.hasNext()){
            //Next():1.指针下移2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

        //错误方法一(只能显示一半元素):
//        Iterator iterator1=collection.iterator();
//        while(iterator.next()!=null){
//            System.out.println(iterator.next());
//        }
        //错误方法二(死循环):
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
//        while (collection.iterator().hasNext()){
//            System.out.println(collection.iterator().next());
//        }
    }


    //测试Iterator中的remove()
    // 如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test2(){
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry",20));
        collection.add(new String("Tom"));
        collection.add(false);

        //遍历集合中元素
        //删除集合中“Tom”
        Iterator iterator=collection.iterator();
        while(iterator.hasNext()){
//            iterator.remove();
            Object obj=iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();
            }
        }
    }
}
