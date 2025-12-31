package Service;

import Model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public Employee search(int id) {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public void viewAll() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
