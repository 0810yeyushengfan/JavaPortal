package test1;
/*
关于char类型数组直接使用的一个疑问:
1.前置知识
   1.1数值型数组如int型数组，初始化后直接打印数组名，默认调用Object类中的toString方法，输出的是地址值。
   1.2引用型变量存储的是对象实例的地址值，如果直接打印变量，默认调用Object类中的toString方法，输出的是地址值。
   1.3String类重写了toString方法，因此直接打印变量名时，输出的是字符串的内容。
2.疑问
   char类型的数组无论是new还是直接赋值初始化，直接打印后显示的居然不是地址值，而时数组内容。
3.解释
   因为输出流System.out是PrintStream对象，PrintStream有多个重载的println方法，其中一个就是public void println(char[] x;
   因此直接打印字符数组的名时，会直接调用这个方法来打印，因而可以打印出数组内容而非地址值。
4.总结
   4.1直接输出char数组名，将数组以字符串形式打印
   4.2输出前面加字符（串），输出的是地址
   4.3输出前面有字符（串）的情况下想要输出数组内容，要调用Arrays类中的toString方法将数组内容以数组形式打印。
 */
public class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b'; }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
        int[] a=new int[10];
        System.out.println(a);
    } }