package jiangjie3;

import org.junit.Test;

import java.util.*;

/*

Collections常用方法
1.排序操作：（均为static方法）
   1.1.reverse(List)：反转 List 中元素的顺序
   1.2.shuffle(List)：对 List 集合元素进行随机排序
   1.3.sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
   1.4.sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
   1.5.swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
2.查找、替换
   2.1.Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大(即末尾的元素)元素
   2.2.Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大(即末尾的元素)元素
   2.3.Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小(即开头的元素)元素
   2.4.Object min(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最小(即开头的元素)元素
   2.5.int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
   2.6.void copy(List dest,List src)：将src中的内容复制到dest中
   2.7.boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
3.Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
   从而可以解决多线程并发访问集合时的线程安全问题

 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(-59);
        list.add(-143);
        list.add(16563);
        list.add(45463);
        // 1.1.reverse(List)：反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("***************");

        //   1.2.shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("***************");

        // 1.3.sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);
        System.out.println("***************");

        //   1.4.sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Integer&&o2 instanceof  Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        System.out.println(list);
        System.out.println("***************");

        // 1.5.swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list,1,2);
        System.out.println(list);
        System.out.println("***************");
    }

    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(-59);
        list.add(-143);
        list.add(16563);
        list.add(45463);
        // 2.1.Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println(Collections.max(list));
        System.out.println("***************");

        //2.2.Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大(即末尾的元素)元素
        Object maxn=Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Integer&&o2 instanceof  Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        System.out.println(maxn);
        System.out.println("***************");

        //   2.3.Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小(即开头的元素)元素
        System.out.println(Collections.min(list));

        //   2.4.Object min(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最小(即开头的元素)元素
        Object minn=Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Integer&&o2 instanceof  Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        System.out.println(minn);
        System.out.println("***************");

        //   2.5.int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list,123));
        System.out.println(Collections.frequency(list,-1));
        System.out.println("***************");

        //   2.6.void copy(List dest,List src)：将src中的内容复制到dest中
        //报异常IndexOutOfBoundsException: Source does not fit in dest
        //原因是:dest应该先有大于等于list.size()的size，即dest集合内元素数量应大于等于list集合内的元素数量
        //List dest=new ArrayList();
        //Collections.copy(dest,list);
        List dest= Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);
        System.out.println("***************");
        List dest1= Arrays.asList(new Object[list.size()+5]);
        System.out.println(dest1.size());
        Collections.copy(dest1,list);
        System.out.println(dest1);
        System.out.println("***************");

        //   2.7.boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
        Collections.replaceAll(dest1,null,8);
        System.out.println(dest1);
    }

    @Test
    public void test3(){
        //返回的list1即为线程安全的List
        List list=new ArrayList();
        list.add(123);
        list.add(-59);
        list.add(-143);
        list.add(16563);
        list.add(45463);
        List list1=Collections.synchronizedList(list);
        //返回的set1即为线程安全的Set
        Set set=new HashSet();
        set.add(123);
        set.add(-59);
        set.add(-143);
        set.add(16563);
        set.add(45463);
        Set set1=Collections.synchronizedSet(set);
    }
}
