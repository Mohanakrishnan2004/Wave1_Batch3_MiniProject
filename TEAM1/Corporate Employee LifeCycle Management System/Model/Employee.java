package Model;

public abstract class Employee {

    protected int id;
    protected String name;
    protected String department;
    protected double salary;
    protected String status;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.status = "Active";
    }

    public int getId() {
        return id;
    }
    public double getSalary() {
    return salary;
}


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void exitEmployee() {
        this.status = "Exited";
    }

    public abstract String getRole();
    public abstract boolean canApproveLeave();

    @Override
    public String toString() {
        return "ID=" + id +
                ", Name=" + name +
                ", Dept=" + department +
                ", Role=" + getRole() +
                ", Salary=" + salary +
                ", Status=" + status;
    }
}
