package review;

public class ReviewTest1 {

    public static void main(String[] args) {
        //区别手动写的和自动生成的equals（）方法
        Person p=new Person("Tom",12);
        Man m=new Man("Tom",12);
        System.out.println(p.equals(m));//手动写的输出true，自动生成的输出false
    }

}
