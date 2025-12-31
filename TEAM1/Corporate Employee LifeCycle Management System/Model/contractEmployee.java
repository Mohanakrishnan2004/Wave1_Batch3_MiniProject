package Model;

public class contractEmployee extends Employee {

    public contractEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
    }

    @Override
    public String getRole() {
        return "Contract";
    }

    @Override
    public boolean canApproveLeave() {
        return false;
    }
}
