package jiangjie1;

public class Chinese {
    String name;
    int age;
    static String nation;
    public void eat(){
        System.out.println("中国人吃中餐");
        //可以用非静态结构
        info();//省略了this.
        System.out.println("name is "+name);//省略了this.
        //也可以调用静态结构
        System.out.println("nation is "+nation);//省略了Chinese.
    }
    public static void show(){
        System.out.println("我是一个中国人！");
        //不能调用非静态的结构
        //eat();
        //name="Tom";
        //可以调用静态的结构
        System.out.println(nation);//省略的是Chinese.而非this.
        walk();
    }
    public void info(){
        System.out.println("name is "+name+" age is "+age);
    }
    public static void walk(){
        System.out.println("中国人走路就是帅");
    }
}
