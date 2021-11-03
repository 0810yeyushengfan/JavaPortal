package test1;
/*
(3)定义类KidsTest，在类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids somekid=new Kids(12);
        somekid.printAge();
        somekid.setSalary(0);
        somekid.setSex(1);
        somekid.employeed();
        somekid.manOrWoman();

    }
}
