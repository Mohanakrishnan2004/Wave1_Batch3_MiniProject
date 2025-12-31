package Model;

public class Payroll {

    private int empId;
    private double netSalary;

    public Payroll(int empId, double netSalary) {
        this.empId = empId;
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Payroll -> EmpId: " + empId + ", Net Salary: " + netSalary;
    }
}
