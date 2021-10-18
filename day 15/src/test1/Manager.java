package test1;
/*
对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 */
public  class Manager extends Employee {
    private double bouns;

    public Manager() {
    }

    public Manager(double bouns) {
        this.bouns = bouns;
    }

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    public Manager(String name, int id, double salary, double bouns) {
        super(name, id, salary);
        this.bouns = bouns;
    }
   public void work(){
        System.out.println("管理员工");
   }

}
