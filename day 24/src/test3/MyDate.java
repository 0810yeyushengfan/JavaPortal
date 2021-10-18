package test3;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int dat) {
        this.day = dat;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(obj instanceof MyDate)
        {
            MyDate date=(MyDate) obj;
            return this.year==date.year&&this.month==date.month&&this.day==date.day;
        }
        return false;
    }
}
