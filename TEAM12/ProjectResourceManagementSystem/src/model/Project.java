package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Project {
    protected String id;
    protected String name;
    protected String requiredSkill;
    protected int requiredHours;
    protected List<Employee> allocatedEmployees;

    public Project(String id, String name, String requiredSkill, int requiredHours) {
        this.id = id;
        this.name = name;
        this.requiredSkill = requiredSkill;
        this.requiredHours = requiredHours;
        this.allocatedEmployees = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        if (e != null) {
            allocatedEmployees.add(e);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public int getRequiredHours() {
        return requiredHours;
    }

    public List<Employee> getAllocatedEmployees() {
        return allocatedEmployees;
    }

    @Override
    public String toString() {
        return name + " (Skill: " + requiredSkill +
               ", Hours: " + requiredHours +
               ", Employees: " + allocatedEmployees.size() + ")";
    }
}
