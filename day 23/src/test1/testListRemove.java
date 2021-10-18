package test1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
区分list中remove(int index)和remove(Object obj)
当remove的元素又能当下标又能当集合中的一个对象时，优先当下标，即优先使用的是remove(int index)
 */
public class testListRemove {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//[1, 2]
    }
    private static void updateList(List list) {
        list.remove(2);
    }
}
