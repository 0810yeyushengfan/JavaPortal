package review;

public class ReviewTest3 {
    //调用String类中自动重写过的的toString方法输出的内容和直接输出String内本身的字符串内容不一样的情况
    public static void main(String[] args) {
        String s=null;
        System.out.println(s);//null
        System.out.println("******************");
        System.out.println(s.toString());//出现NullPointerException
        //看源码知道了println有保护机制，能在输出对象为null时不继续进行以至于报错，并且直接输出null，//
        // 而toString没有这样的保护机制，所以报错。

    }
}
