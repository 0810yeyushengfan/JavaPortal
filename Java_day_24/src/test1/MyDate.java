package test1;


/*
MyDate 类包含:
private 成员变量 year,month,day；并为每一个属性定义 getter, setter 方法；
 */
public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof MyDate){
            MyDate m=(MyDate) o;
            //比较年
            int miunsYear=this.getYear()-m.getYear();
            if(miunsYear!=0){
                return miunsYear;
            }
            //比较月
            int miunsMonth=this.getMonth()-m.getMonth();
            if(miunsMonth!=0){
                return miunsMonth;
            }
            //比较日
            int minusDay=this.getDay()-m.getDay();
            return minusDay;
        }
        throw new RuntimeException("输入的数据类型不一致");
    }
}

