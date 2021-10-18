package jiangjie5;

public class InterviewTest {
    public void test1(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);//1.0  因为三元运算符会将后面两个数据进行自动类型提升，只有类型一样才可以使用三元运算符
        //关于三元运算符？的自动类型提升问题详见ImproveTest
    }
    public void test2(){
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//1
    }
    /*
    Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[]，保存了从-128~127范围内的整数（因为这些数常用）
    如果我们使用自动装箱的方式，给Integer赋值的范围在-128~127范围内，可以直接使用数组中的元素，不用再去new了。
    如果给Integer赋值的范围不在-128~127范围内，则会和其他赋值方式一样，再去new一个新的Integer，
     */
    public void test3(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        Integer x = 128;//相当于new了一个新的Integer对象
        Integer y = 128;
        System.out.println(x == y);//false
    }
}
