package jiangjie2;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class JDK8DateTimeTest {
    /*
    LocalDate,LocalTime,LocalDateTime的使用
    说明:
    1.LocalDateTime相较于LocalDate,LocalTime，使用频率较高
    2.使用上类似于Calendar
     */
    @Test
    public void testLocalDateTimeTest(){
        //now():获取当前的日期，时间，日期＋时间
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年，月，日，时，分，秒，没有偏移量
        LocalDateTime localDateTime1=LocalDateTime.of(2021,5,25,22,47,0);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//25
        System.out.println(localDateTime.getDayOfWeek());//TUESDAY
        System.out.println(localDateTime.getMonth());//MAY
        System.out.println(localDateTime.getMonthValue());//5
        System.out.println(localDateTime.getMinute());//50

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1=localDate.withDayOfMonth(22);
        System.out.println(localDate1);
        System.out.println(localDate);

        LocalDateTime localDateTime2=localDateTime.withHour(4);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);

        //体现不可变性
        //plusXxx(long value):让相关属性加上value
        LocalDateTime localDateTime3=localDateTime.plusMonths(3);
        System.out.println(localDateTime3);
        System.out.println(localDateTime);

        //minusXxx(long value):让相关属性减去value
        LocalDateTime localDateTime4=localDateTime.minusDays(6);
        System.out.println(localDateTime4);
        System.out.println(localDateTime);
    }

    /*
    Instant的使用
    类似于java.util.Date类
     */

    @Test
    public void testInstant(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);//2021-05-26T04:38:56.930Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));


        //toEpochMilli():获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数---->类似Date类的getTime()方法
        long milli=instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instance实例---->类似Date(long millis)的构造器
        Instant instant1=Instant.ofEpochMilli(1622004286758L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期，时间
    类似于SimpleDateFormat
     */

    @Test
    public void testDateTimeFormatter(){

        //方式一:预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化:日期--->字符串
        LocalDateTime localDateTime=LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析:字符串--->日期
        //TemporalAccessor是localDateTime实现的一个接口
        TemporalAccessor parse=formatter.parse("2021-05-26T20:49:10.905");
        System.out.println(parse);

        //方式二:本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG/FormatStyle.MEDIUM/Formatstyle.SHORT:适用于LocalDateTime
        DateTimeFormatter formatter1=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        //格式化
        String str2=formatter1.format(localDateTime);
        System.out.println(str2);

        //本地化相关的格式。如：ofLocalizedDate(FormatStyle.LONG)
        // FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/Formatstyle.SHORT:适用于LocalDate
        DateTimeFormatter formatter2=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalDate localDate=LocalDate.now();

        //格式化
        String str3=formatter2.format(localDate);
        System.out.println(str3);


        //重点:方式三:自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        //格式化
        String str4=formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor accessor=formatter3.parse("2021-05-26 09:11:05");
        System.out.println(accessor);
    }
}
