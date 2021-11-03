package service;

import domain.*;

import static service.Data.*;

/**
 * 功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        //1.根据项目提供的Data()类构造相应大小的employees数组
        //2.再根据Data类中的数据构建不同的对象，包括Employee,Programmer,Designer和Architect
        //3.将对象存于数组中
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            //获取员工的类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的四个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bouns;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bouns);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bouns, stock);
                    break;
            }
        }
    }

    //获取指定index位置上的员工的设备
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        switch (key) {
            case PC://21
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName, display);
            case NOTEBOOK://22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName, price);
            case PRINTER://23
                String type = EQUIPMENTS[index][2];
                return new Printer(modelOrName, type);
        }
        return null;
    }

    //获取当前所有员工。
    //返回：包含所有员工对象的数组
    public Employee[] getAllEmployees() {
        return employees;
    }

    //获取指定ID的员工对象。
    //参数：指定员工的ID
    //返回：指定员工对象
    //异常：找不到指定的员工
    public Employee getEmployee(int id) throws TeamExpection {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamExpection("找不到指定的员工！");
    }


}
