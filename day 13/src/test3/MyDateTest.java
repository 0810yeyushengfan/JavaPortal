package test3;
/*
2.请根据以下代码自行定义能满足需要的MyDate类,在MyDate类中覆盖equals方法，
  使其判断当两个MyDate类型对象的年月日都相同时，结果为true，否则为false。
*/
public class MyDateTest {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(14, 3, 1976);
        MyDate m2 = new MyDate(14, 3, 1976);
        if (m1 == m2) {
            System.out.println("m1==m2");
        } else {
            System.out.println("m1!=m2"); // m1 != m2
        }
        if (m1.equals(m2)) {
            System.out.println("m1 is equal to m2");// m1 is equal to m2
        } else {
            System.out.println("m1 is not equal to m2");
        } }
}
