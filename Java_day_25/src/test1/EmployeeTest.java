package test1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
分别按以下两种方式对集合中的元素进行排序，并遍历输出：
1). 使 Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 */
public class EmployeeTest {

    //问题一:按name排序
    @Test
    public void test1(){
        TreeSet<Employee> treeSet=new TreeSet<Employee>();
        Employee e1=new Employee("huangshaotian",55,new MyDate(2000,8,10));
        Employee e2=new Employee("yeqiu",23,new MyDate(1980,8,13));
        Employee e3=new Employee("sumucheng",19,new MyDate(2001,4,30));
        Employee e4=new Employee("baozi",9,new MyDate(2010,2,10));
        Employee e5=new Employee("lala",35,new MyDate(2000,8,10));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        Iterator<Employee> iterator=treeSet.iterator();
        while (iterator.hasNext()){
            Employee employee=iterator.next();
            System.out.println(employee);
        }

    }

    //问题二:按生日日期的先后排序
    @Test
    public void test2(){
        TreeSet<Employee> treeSet=new TreeSet<Employee>(new Comparator<Employee>() {
            //使用泛型以后的写法:
            //方式一:
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate d1 = o1.getBirthday();
                MyDate d2 = o2.getBirthday();
                return d1.compareTo(d2);
            }
            //方式二:
//            @Override
//            public int compare(Employee e1, Employee e2) {
//               {
//                    MyDate b1=e1.getBirthday();
//                    MyDate b2=e2.getBirthday();
//                    //比较年
//                    int miunsYear=b1.getYear()-b2.getYear();
//                    if(miunsYear!=0){
//                        return miunsYear;
//                    }
//                    //比较月
//                    int miunsMonth=b1.getMonth()-b2.getMonth();
//                    if(miunsMonth!=0){
//                        return miunsMonth;
//                    }
//                    //比较日
//                    int minusDay=b1.getDay()-b2.getDay();
//                        return minusDay;
//        }
            //使用泛型之前的写法:
        }
//            //方式一:
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Employee&&o2 instanceof Employee){
//                    Employee e1=(Employee) o1;
//                    Employee e2=(Employee) o2;
//                    MyDate b1=e1.getBirthday();
//                    MyDate b2=e2.getBirthday();
//                    return b1.compareTo(b2);
//                }
//                throw new RuntimeException("输入的数据类型不一致");
//            }
//            //方式二:
////            @Override
////            public int compare(Object o1, Object o2) {
////                if(o1 instanceof Employee&&o2 instanceof Employee){
////                    Employee e1=(Employee) o1;
////                    Employee e2=(Employee) o2;
////                    MyDate b1=e1.getBirthday();
////                    MyDate b2=e2.getBirthday();
////                    //比较年
////                    int miunsYear=b1.getYear()-b2.getYear();
////                    if(miunsYear!=0){
////                        return miunsYear;
////                    }
////                    //比较月
////                    int miunsMonth=b1.getMonth()-b2.getMonth();
////                    if(miunsMonth!=0){
////                        return miunsMonth;
////                    }
////                    //比较日
////                    int minusDay=b1.getDay()-b2.getDay();
////                        return minusDay;
////                }
////                throw new RuntimeException("输入的数据类型不一致");
////            }
//        }
        );
        Employee e1=new Employee("huangshaotian",55,new MyDate(2000,8,10));
        Employee e2=new Employee("yeqiu",23,new MyDate(1980,8,13));
        Employee e3=new Employee("sumucheng",19,new MyDate(2001,4,30));
        Employee e4=new Employee("baozi",9,new MyDate(2010,2,10));
        Employee e5=new Employee("lala",35,new MyDate(2000,8,10));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);
        Iterator<Employee> iterator=treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
