package jiangjie5;
/*
三元运算符？的自动类型提升:
1.假如表达式1和表达式2具有相同的类型，那么整个条件运算符结果的类型就是这个类型。
2.假如一个表达式的类型是T，T是byte或short或char，另一个表达式的类型是int类型的常量表达式，
而且这个常量表达式的值是可以用类型T表示的（也就是说，常量表达式的值是在类型T的取值范围之内），那么整个条件运算符结果的类型就是T。
3.除以上情况外，假如表达式1和表达式2的类型不同，那么将进行类型提升，整个条件运算符结果的类型就是提升后的类型
 */
public class ImproveTest {
    public static void main(String[] args) {
        //两个操作数不可以转换，返回对应的对象类型
        Object o = true?1:"a";
        System.out.println(o.toString()+" and "+o.getClass());
        //两个操作数直接是数字，返回范围大的
        o = true?1:2.0;
        System.out.println(o.toString()+" and "+o.getClass());
        //两个操作数都是明确类型的表达式，如果是不可以转换，返回对应的对象类型，可以转换返回范围大的
        o=true?new Integer(1):new String("1");
        System.out.println(o.toString()+" and "+o.getClass());

        o=true?new Integer(1):new Double(2);
        System.out.println(o.toString()+" and "+o.getClass());

        //两个操作数一个是数字一个是明确类型的表达式，如果是不可以转换，返回对应的对象类型，可以转换返回范围大的
        o=true?1:new String("1");
        System.out.println(o.toString()+" and "+o.getClass());

        o=true?1:new Double(2);
        System.out.println(o.toString()+" and "+o.getClass());
        //两个操作数一个是byte或short或char类型的表达式，另一个表达式的类型是int类型的常量表达式，
        //而且常量表达式的值在另一个表达式类型的取值范围之内），那么整个条件运算符结果的类型就是另一个表达式类型。
        //如果不在其范围内，则整个条件运算符结果的类型是int。
        //char的范围为0~65535,byte的范围为-128~127，short的范围为-32768~32767.
        o=true?'a':65535;
        System.out.println(o.toString()+" and "+o.getClass());

        o=true?'a':65536;
        System.out.println(o.toString()+" and "+o.getClass());

        o=true?'a':-1;
        System.out.println(o.toString()+" and "+o.getClass());
    }
}
