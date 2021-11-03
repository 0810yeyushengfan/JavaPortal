package jiangjie2;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
jdk8之前的日期时间的API测试
1.System类中的currentTimeMillis()
2.java.util.Date和其子类java.sql.Date
3.SimpleDateFormat
4.Calendar
 */
public class DateTimeTest {
    /*
SimpleDateFormat的使用:SimpleDateFormat对日期Date类的格式化和解析

1.两个操作
1.1.格式化(format):日期--->字符串
1.2.解析(parse):格式化的逆过程，字符串--->日期

2.SimpleDateFormat的实例化

 */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化(format):日期--->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析(parse):格式化的逆过程，字符串--->日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //********************按照指定的方式格式化和解析:调用带参的构造器**********************
        //SimpleDateFormat sdf1=new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
        //格式化(format):
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析(parse):要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),否则会抛异常
        Date date2 = sdf1.parse("2021-05-25 10:03::38");
        System.out.println(date2);


    }
    /*
    Calendar日历类(抽象类)的使用
     */

    @Test
    public void testCalendar() {
        //1.实例化
        //方式一:创建其子类(GregorianCalendar)的对象
        //方式二:调用其静态方法getInstance()
        Calendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getClass());

        //2.常用方法
        //get():获取日期
        //注意: 获取月份时：一月是0，二月是1，以此类推，12月是11
        // 获取星期时：周日是1，周二是2 ， 。。。。周六是7
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //set():修改日期
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add():添加日期
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类--->Date
        Date date=calendar.getTime();
        System.out.println(date);

        //setTime():Date--->日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }
}
