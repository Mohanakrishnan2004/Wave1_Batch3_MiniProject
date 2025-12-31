package service;

import java.util.List;
import model.Employee;
import model.Project;

public class SkillBasedAllocation implements AllocationStrategy {

    @Override
    public void allocate(Project project, List<Employee> employees) {

        if (project == null || employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Project or employee list cannot be null or empty");
        }

        int remainingHours = project.getRequiredHours();

        for (Employee emp : employees) {

            if (remainingHours <= 0)
                break;

            try {
                if (emp.hasSkill(project.getRequiredSkill()) && emp.getAvailableHours() > 0) {

                    int hoursToAllocate = Math.min(remainingHours, emp.getAvailableHours());
                    emp.allocateHours(hoursToAllocate);
                    project.addEmployee(emp);

                    remainingHours -= hoursToAllocate;

                    System.out.println("Allocated " + project.getName() +
                            " to " + emp.getId() + " - " + emp.getName());
                }
            } catch (Exception e) {
                System.out.println("Error allocating employee " + emp.getName() + ": " + e.getMessage());
            }
        }

        if (remainingHours > 0) {
            System.out.println("Warning: " + project.getName()
                    + " still needs " + remainingHours + " hours.");
        }
    }
}
