package Model;

public class permanentEmployee extends Employee {

    public permanentEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
    }

    @Override
    public String getRole() {
        return "Permanent";
    }

    @Override
    public boolean canApproveLeave() {
        return true;
    }
}
