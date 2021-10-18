package test2;

import java.util.Calendar;

/*
定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
    public static void main(String[] args) {
        //方式一:
        //Scanner scanner=new Scanner(System.in);
        //System.out.println("请输出当前的月份为:");
        //int month=scanner.nextInt();
        //方式二:
        Calendar calendar=Calendar.getInstance();//Calendar为日历
        int month=calendar.get(calendar.MONTH);//获取当前月份，但是从一月份开始且一月份是0而非1.
        Employee[] emps=new Employee[4];//是Employee类型的数组，抽象类的数组可以创建，只是不能（在数组中）创建抽象类的对象，但是可以使用多态思想创建抽象类的子类对象
        emps[0]=new SalariedEmployee("张三",1001,new Mydate(1992,2,28),10000);
        emps[1]=new HourlyEmployee("李四",1002,new Mydate(1991,3,31),60,240);
        emps[2]=new SalariedEmployee("王五",1001,new Mydate(1999,1,18),8000);
        emps[3]=new HourlyEmployee("马六",1002,new Mydate(2001,4,1),30,240);
        for(int i=0;i<emps.length;i++)
        {
            System.out.println(emps[i]);//自动输出emps[i]的toString方法。
            double salary=emps[i].earnings();
            System.out.println("月工资为"+salary);
            if(month==emps[i].getBirthday().getMonth())
                System.out.println("生日快乐，奖励一百元");
        }
    }
}
