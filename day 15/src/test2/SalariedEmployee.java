package test2;
/*
定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。
该类包括：private成员变量monthlySalary；
实现父类的抽象方法earnings(),该方法返回monthlySalary值；
toString()方法输出员工类型信息及员工的name，number,birthday
 */
 public class SalariedEmployee extends Employee {
    private double  monthlySalary;

    public SalariedEmployee(String name, int number, Mydate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee() {
    }

    public double earnings(){
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return " SalariedEmployee["+super.toString()+"]";
    }
}
