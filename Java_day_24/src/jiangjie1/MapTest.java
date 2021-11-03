package jiangjie1;

import org.junit.Test;

import java.util.*;

/*
一.分类
Map接口:双列集合，用来存储一对(key,value)的数据。---->类似于数学中的“函数”
1.HashMap:作为Map的主要实现类，是线程不安全的，效率高，能存储null的key和value
  HashMap的底层:数组＋链表(jdk7.0及以前)
                                    数组＋链表＋红黑树(jdk8.0及之后)
2.LinkedHashMap:是HashMap的子类，保证能在遍历Map元素时，可以按照添加的顺序实现遍历
   原因:在原有的HashMap的底层结构基础上，添加了一对指针，指向前一个元素和后一个元素
             因此对于频繁的遍历操作，此类执行效率高于HashMap
3.TreeMap:保证按照添加的key-value对进行排序，实现排序遍历
4.Hashtable:作为Map的古老实现类(过于古老，导致名称都没满足命名规范)，是线程安全的，效率低，不能存储null的key和value
5.Properties:时Hashtable的子类，常用来处理配置文件，key和value都是String类型的

二.Map结构的理解:
1.Map中的key:无序的，不可重复的，使用Set存储所有的key--->key所在的类要重写equals()和hashCode()(以HashMap为例)
2.Map中的value:无序的，可重复的，使用Collection存储所有的value--->value所在的类要重写equals()
3.一个键值对:key-value构成了一个Entry对象
4.Map中的entry:无序的，不可重复的，使用Set存储所有的entry

三.HashMap的底层实现原理(以jdk7.0为例):
      HashMap map=new HashMap();
      在实例化以后，底层创建了长度是16的一维数组Entry[] table
      ......可能已经执行过多次put.......
      map.put(key1,value1);
      首先，调用key1所在类的hashCode()计算哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置
      如果此位置上的数据为空，此时的key1-value1添加成功。----->情况1
      如果此位置上的数据不为空，意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的一个
      或多个数据的哈希值:
              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功---->情况2
              如果key1的哈希值与已经存在的某一个数据(key2-value2)的哈希值相同，继续比较，调用key1所在类的equals(key2):
                      如果key1.equals(key2)返回false:此时key1-value1添加成功----->情况3
                      如果key1.equals(key2)返回true:使用value1替换value2。
       补充:关于情况2和情况3:此时的key1-value1和原来相同位置上的数据以链表的方式存储
       在不断添加的过程中，会涉及到扩容问题，当超出临界值(容量*填充因子)且要存放的位置非空时，要进行扩容
       默认的扩容方式:扩容为原来容量的2倍，并将原有的数据复制过来，并重新计算哈希值判断存放位置
       jdk8.0相较于jdk7.0在底层实现方面的不同:
       1.new HashMap():底层没有创建一个长度是16的一维数组’
       2.jdk8.0底层的数组是Node[]而非Entry[]
       3.首次调用put()方法时，底层创建了一个长度是16的一维数组
       4.jdk7底层结构只有数组＋链表，jdk8.0底层结构有数组＋链表＋红黑树
          当数组的某一个索引位置上的元素以链表形式存在的数据个数＞8且当前数组的长度＞64时，
          此时此索引位置上的所有数据改为使用红黑树存储。(将查找和删除的时间复杂度从o(n)--->o(1))
       5.形成链表时，遵循七上八下(jdk7.0及以前:新的元素指向旧的元素 jdk8.0及以后:旧的元素指向新的元素)

四.HashMap源码中几的个常用常量
1.DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
2.DEFAULT_LOAD_FACTOR：HashMap的默认加载因子,0.75
3.TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树,8
4.MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。(当桶中Node的数量大到需要变红黑树时，
若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少
是TREEIFY_THRESHOLD的4倍。),64
5.threshold：扩容的临界值，=容量*填充因子=16*0.75=12

五.LinkedHashMap的底层实现原理(了解)
源码中:
static class Entry<K,V> extends HashMap.Node<K,V> {
Entry<K,V> before, after;
Entry(int hash, K key, V value, Node<K,V> next) {
super(hash, key, value, next);
} }

六.Map接口的常用方法(以HashMap为例):
1.添加、删除、修改操作：
   1.1.Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
   1.2.void putAll(Map m):将m中的所有key-value对存放到当前map中
   1.3.Object remove(Object key)：移除指定key的key-value对，并返回value
   1.4.void clear()：清空当前map中的所有数据
2.元素查询的操作：
   2.1. Object get(Object key)：获取指定key对应的value
   2.2. boolean containsKey(Object key)：是否包含指定的key
   2.3.boolean containsValue(Object value)：是否包含指定的value
   2.4. int size()：返回map中key-value对的个数
   2.5.boolean isEmpty()：判断当前map是否为空
   2.6. boolean equals(Object obj)：判断当前map和参数对象obj是否相等
3.元视图操作的方法：
   3.1. Set keySet()：返回所有key构成的Set集合
   3.2. Collection values()：返回所有value构成的Collection集合
   3.3.Set entrySet()：返回所有key-value对构成的Set集合
4.总结:常用方法:
   4.1.添加:Object put(Object key,Object value)
   4.2.删除:Object remove(Object key)
   4.3.修改:Object put(Object key,Object value)
   4.4.查询:Object get(Object key)
   4.5.长度:int size()
   4.6.遍历: Set keySet(),Collection values(),Set entrySet()



 */
public class MapTest {

    @Test
    public void  test1(){
        Map map=new HashMap();
        //1.1.Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        //添加
        map.put("CC",123);
        map.put("BB",123);
        //修改
        map.put("BB",11);
        System.out.println(map);
        System.out.println("*********************");

        //  1.2.void putAll(Map m):将m中的所有key-value对存放到当前map中
        Map map1=new HashMap();
        map1.put("AA",1);
        map.putAll(map1);
        System.out.println(map);
        System.out.println("*********************");

        //   1.3.Object remove(Object key)：移除指定key的key-value对，并返回value
        Object value=map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        Object value1=map.remove("AAA");
        System.out.println(value);
        System.out.println(map);
        System.out.println("*********************");

        //   1.4.void clear()：清空当前map中的所有数据
        map.clear();//与map=null操作不同
        System.out.println(map.size());
        System.out.println(map);

    }

    @Test
    public void test2(){
        Map map=new HashMap();
        map.put("CC",123);
        map.put("BB",123);
        map.put("AA",1);
        //   2.1. Object get(Object key)：获取指定key对应的value
        System.out.println(map.get("BB"));
        System.out.println("*********************");

        //   2.2. boolean containsKey(Object key)：是否包含指定的key
        boolean isExist=map.containsKey("BB");
        System.out.println(isExist);
        System.out.println("*********************");

        //   2.3.boolean containsValue(Object value)：是否包含指定的value
        isExist=map.containsValue(123);
        System.out.println(isExist);
        System.out.println("*********************");

        //   2.4. int size()：返回map中key-value对的个数
        System.out.println(map.size());
        System.out.println("*********************");

        //   2.5.boolean isEmpty()：判断当前map是否为空
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
        System.out.println("*********************");
        //   2.6. boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        map.put("CC",123);
        map.put("BB",123);
        map.put("AA",1);
        Map map1=new HashMap();
        map1.put("CC",123);
        map1.put("BB",123);
        map1.put("AA",1);
        System.out.println(map.equals(map1));
        Map map2=new HashMap();
        map2.put("CC",123);
        map2.put("BB",123);
        map2.put("AAA",1);
        System.out.println(map.equals(map2));

    }

    @Test
    public void test3(){
        Map map=new HashMap();
        map.put("CC",123);
        map.put("BB",123);
        map.put("AA",1);
        //遍历所有的key集:Set keySet()：返回所有key构成的Set集合
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*********************");

        //遍历所有的value集:Collection values()：返回所有value构成的Collection集合
        Collection collection=map.values();
        Iterator iterator1=collection.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("*********************");

        //遍历所有的key-value
        //方式一:Set entrySet()：返回所有key-value对构成的Set集合
        Set entrySet=map.entrySet();
        Iterator iterator2=entrySet.iterator();
        while (iterator2.hasNext()){
//            System.out.println(iterator2.next());
            //entrySet集合中的元素都是entry
            Object object=iterator2.next();
            Map.Entry entry=(Map.Entry) object;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        System.out.println("*********************");
        //方式二:
        Set keySet=map.keySet();
        Iterator iterator3=keySet.iterator();
        while (iterator3.hasNext()){
            Object key=iterator3.next();
            Object value=map.get(key);
            System.out.println(key+"----->"+value);
        }

    }

}
