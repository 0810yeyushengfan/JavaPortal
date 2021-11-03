package domain;

import service.Status;

public class Programmer extends Employee {
    private int memberID;//开发团队中的id
    private Equipment equipment;
    private Status status = Status.FREE;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary) {
        super(id, name, age, salary);
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public String toString() {
        return getDetails() + "\t" + "程序员\t" + status + "\t\t\t" + equipment.getDescription();
    }
    public String getTeamBaseDetails(){
        return memberID+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary();
    }
    public String getDetailsForTeam(){
        return getTeamBaseDetails()+"\t程序员";
    }
}
