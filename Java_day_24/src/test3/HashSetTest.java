package test3;

import org.junit.Test;

import java.util.HashSet;

public class HashSetTest {
    @Test
    public void test(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";//虽然p1的内容改变了，但是存在于set集合内的p1的 hashCode的值不会变化。
        // 仍然是之前的(1001,"AA")的hashCode的值，也就是存放的位置没有改变
        set.remove(p1);//因为这个remove操作是要先找到此时p1内容对应的hashCode值的位置并将其remove，此时需要重新计算hashCode值
        //但是这个值并不是存在与set集合内的p1的hashCode的值，因此没有去掉集合内的p1
        System.out.println(set);
        set.add(new Person(1001,"CC"));//由于set集合内的p1存的是之前(1001,"AA")的位置，所以此时(1001,"CC")位置处并没有元素，因此可以插入
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}
