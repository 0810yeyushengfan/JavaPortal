package jiangjie3;
/*
考查多态的笔试题目：
1.Base和Sub算不算重写？
  算重写。因为之前说过...arr与arr[]不能同时出现，其实就意味着Base和Sub已经算做重写了。
2.
 */
public class InterviewTest {

    public static void main(String[] args) {
        Base base = new Sub();
        base.add(1, 2, 3);//sub_1

//		Sub s = (Sub)base;
//		s.add(1,2,3);输出sub_2，因为输出sub_2的方法和输出sub_1的方法不算重写，
//	   而且之前说过确定多个的方法优先于不确定数目的方法调用，因此输出sub_2。
    }
}

class Base {
    public void add(int a, int... arr) {
        System.out.println("base");
    }
}

class Sub extends Base {

    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }

//	public void add(int a, int b, int c) {//这个和Base不算重写。
//		System.out.println("sub_2");
//	}

}