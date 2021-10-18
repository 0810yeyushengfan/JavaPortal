package domain;

public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary, equipment);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary) {
        super(id, name, age, salary);
    }

    public Designer(int id, String name, int age, double salary, double bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public String toString() {
        return getDetails() + "\t" + "设计师\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
    }
    public String getDetailsForTeam(){
        return getTeamBaseDetails()+"\t设计师\t"+bonus;
    }
}
