package jiangjie1;

/*
try-catch-finally中finally的使用:
1.finally是可选的
2.finally中声明的是一定会被执行的代码。即使catch中又出现异常了或者是try中有return语句，catch中有return
语句等情况，finally中的代码也会执行出来。
3.像数据库连接，输入输出流，网络编程Socket等资源，JVM是不能自动回收的，我们需要自己手动的进行资源
   的释放，此时的资源释放，就需要声明在finally中，保证其一定能被释放。
 */
public class FinallyTest1 {
    public static void main(String[] args) {
        FinallyTest1 test1=new FinallyTest1();
        int num=test1.method();
        System.out.println(num);
    }
    public int method(){
        try{
            int[] arr=new int[10];
            //System.out.println(arr[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("我一定会被执行！");
        }
    }

}
