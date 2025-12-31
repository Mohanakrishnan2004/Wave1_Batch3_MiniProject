package service;

import java.util.List;
import model.Employee;
import model.Project;

public interface AllocationStrategy {
    void allocate(Project project, List<Employee> employees);
}
