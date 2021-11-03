package domain;

public class Architect extends Designer {
    private int stock;//公司奖励的股票数量

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary, equipment);
    }

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return getDetails() + "\t" + "架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }
    public String getDetailsForTeam(){
        return getTeamBaseDetails()+"\t架构师\t"+getBonus()+"\t"+stock;
    }
}
