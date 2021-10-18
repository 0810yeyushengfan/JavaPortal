package jiangjie1;
/*
抽象类的匿名子类
 */
public class PersonTest {
    public static void main(String[] args) {
        method(new Student());//匿名对象
        Worker worker=new Worker();
        method1(worker);//非匿名的类的非匿名的对象
        method1(new Worker());//非匿名的类的匿名的对象
        System.out.println("***************");
        //创建一个匿名的子类的非匿名对象：p(即创建的是Person的匿名子类的对象，而非Person的对象）
         Person p=new Person() {
             @Override
             public void eat() {
                 System.out.println("吃");
             }

             @Override
             public void breath() {
                 System.out.println("好好活着");
             }
         };
        //Person p1=new Person();//Person类是抽象类，不能实例化
        method1(p);
        System.out.println("****************");
        method1(new Person() {
            @Override
            public void eat() {
                System.out.println("吃吃吃");
            }

            @Override
            public void breath() {
                System.out.println("呼吸呼吸呼吸");

            }
        });
    }
    public static void method1(Person p){
        p.eat();
        p.breath();
    }
    public static void method(Student s){
        System.out.println(s.age);
    }

}
class Worker extends Person {
    public void eat() {
        System.out.println("干饭人开饭了");
    }

    public void breath() {
        System.out.println("带薪呼吸");
    }
}