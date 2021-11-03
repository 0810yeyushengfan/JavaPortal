package Junit;

import domain.Employee;
import service.NameListService;
import service.TeamExpection;

public class NameListServiceTest {
    public static void main(String[] args) {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        int id = 1;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamExpection e) {
            System.out.println(e.getMessage());
        }
    }
}
