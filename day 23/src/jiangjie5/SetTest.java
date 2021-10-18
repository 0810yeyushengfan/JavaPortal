package jiangjie5;

import org.junit.Test;

import java.util.*;

/*
Set接口:存储无序的，不可重复的数据。---->类似于数学中的“集合”
一.Set接口存储数据的特性:(以HashSet为例)
1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
2.不可重复性:保证添加的元素按照equals()判断时，不能返回true，即相同的元素只能添加一个。

二..添加元素的过程:(以HashSet为例)
       我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值。
       此哈希值接着通过某种算法计算出HashSet底层数组中的存放位置(即为索引位置)，并判断
       数组此位置上是否已经有元素。
                如果此位置上没有其他元素，则元素a添加成功。----->情况1
                如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a和元素b的hash值:
                             如果hash值不相同，则元素a添加成功。----->情况2
                             如果hash值相同，进而需要调用元素a所在类的equals()方法:
                                      equals()返回true，元素a添加失败。
                                      equals()返回false，则元素a添加成功。----->情况3
        对于添加成功的情况2和情况3而言:元素a与已经存在指定索引位置上数据以链表的方式存储。
        jdk7.0:元素a放到数组中，指向原来的元素
        jdk8.0:原来的元素在数组中，指向元素a
        总结:七上八下
        HashSet底层:数组+链表的结构。

三.分类
1.HashSet:作为Set接口的主要实现类:线程不安全的:可以存储null值
2.LinkedHashSet:作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历,对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
3.TreeSet:可以按照添加对象的指定属性，进行排序

四:注意:
1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
2.要求:向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
    要求:重写的hashCode()和equals()尽可能保持一致性:相等的对象必须具有相等的散列码
    重写两个方法的小技巧:对象中用作equals()方法比较的Field，都应该用来计算hashCode
 */
public class SetTest {
    //HashSet的使用:
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(new Person1("Tony", 16));
        set.add(new Person2("Tom", 20));
        set.add(new Person1("Tony", 16));//不重写hashCode时，默认使用Object类中的hashCode()，而这个方法返回一个随机值，显然这两次添加极大概率不一样，因此能添加到set集合中
        set.add(new Person2("Tom", 20));//重写hashCode后，显然这两个hashCode值一样，因此调用equals进行比较，返回false，因此第二次添加进入不了set集合中
        System.out.println(set);
    }

    /*
    LinkedHashSet的使用:
    LinkedHashSet作为Set的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个数据和后一个数据
    优点:对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Person2("刘德华", 1001));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
    TreeSet的使用:
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方法:自然排序(实现comparable接口)和定制排序(comparator)
    3.自然排序中，比较两个对象是否相同的标准为:compareTo()是否返回0，不再是equals()返回是否返回true
    4.定制排序中，比较两个对象是否相同的标准为:compareTo()是否返回0，不再是equals()返回是否返回true

     */
    @Test
    public void test3() {
        TreeSet treeSet1 = new TreeSet();
        //失败，不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add("AA");
//        treeSet.add(new User("Tom",15));

        //举例一:
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add(395);
//        treeSet.add(1);
//        Iterator iterator=treeSet.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //举例二:
        treeSet1.add(new User1("Tom", 15));
        treeSet1.add(new User1("Tony", 32));
        treeSet1.add(new User1("Jary", 17));
        treeSet1.add(new User1("Ancy", 24));
        treeSet1.add(new User1("Ancy", 29));
        Iterator iterator1 = treeSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }//只输出了一个名为"Ancy"的元素

        System.out.println("************************");
        TreeSet treeSet2= new TreeSet();
        treeSet2.add(new User2("Tom", 15));
        treeSet2.add(new User2("Tony", 32));
        treeSet2.add(new User2("Jary", 17));
        treeSet2.add(new User2("Ancy", 24));
        treeSet2.add(new User2("Ancy", 29));
        Iterator iterator2 = treeSet2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }//输出了两个名为"Ancy"的元素

        System.out.println("*****************************");
        Comparator comparator=new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User1 && o2 instanceof  User1){
                    User1 user1=(User1) o1;
                    User1 user2=(User1) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet treeSet3=new TreeSet(comparator);
        treeSet3.add(new User1("Tom", 15));
        treeSet3.add(new User1("Tony", 32));
        treeSet3.add(new User1("Jary", 17));
        treeSet3.add(new User1("Jany", 17));
        treeSet3.add(new User1("Ancy", 24));
        treeSet3.add(new User1("Ancy", 29));
        Iterator iterator3 = treeSet3.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }

    }
}
//未定义hashCode的类
class Person1{
    private  String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        System.out.println("调用了Person1的toString方法" );
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person1() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return age == person1.age && Objects.equals(name, person1.name);
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//定义了hashCode的类
class Person2{
    private  String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person2() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public String toString() {
        System.out.println("调用了Person2的toString方法" );
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//用于TreeSet测试的类
class User1 implements Comparable{
   private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User1 user1 = (User1) o;
        return age == user1.age && Objects.equals(name, user1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User1() {
    }

    //按照姓名从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User1){
            User1 user1=(User1) o;
            return this.name.compareTo(user1.name);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}

class User2 implements Comparable{

    private String name;
    private int age;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        return age == user2.age && Objects.equals(name, user2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User2() {
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //先按照姓名从大到小排序，再按照年龄从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User2){
            User2 user2=(User2) o;
            int compare= -this.name.compareTo(user2.name);
            if(compare!=0) {
                return compare;
            } else{
                return Integer.compare(this.age,user2.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}