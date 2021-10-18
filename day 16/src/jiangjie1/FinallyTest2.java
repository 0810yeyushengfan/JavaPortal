package jiangjie1;

public class FinallyTest2 {
    public static void main(String[] args) {
        try{
            int a=10;
            int b=0;
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            //e.printStackTrace();
            int[] arr=new int[10];
            System.out.println(arr[10]);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("一号被执行");
        finally{
            System.out.println("二号被执行");
        }
    }
}

