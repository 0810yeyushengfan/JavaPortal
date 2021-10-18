package test1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {
    /*
    练习一:字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth="2020-09-08";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(birth);
        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    练习二:“三天打鱼两天晒网”  从1990-01-01开始第一天打鱼，到xxxx-xx-xx是打鱼还是晒网
    举例:2021-05-25是打鱼还是晒网?
    总天数%5==1,2,3:打鱼
    总天数%5==0,4:晒网

    总天数的计算:
    方式一:(datenow.getTime()-date.getTime())/(1000*60*60*24)+1
    方式二:1990-01-01--->2020-12-31+2021-01-01--->2021-05-25
     */
}
