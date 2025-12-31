package model;

public class InternalProject extends Project {
    private String department;

    public InternalProject(String id, String name, String requiredSkill, int requiredHours, String department) {
        super(id, name, requiredSkill, requiredHours);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return getName() + " (Department: " + department +
               ", Skill: " + getRequiredSkill() +
               ", Hours: " + getRequiredHours() +
               ", Employees Allocated: " + getAllocatedEmployees().size() + ")";
    }
}
