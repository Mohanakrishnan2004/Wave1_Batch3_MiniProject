package service;

import static org.junit.Assert.*;
import java.util.Arrays;
import model.*;
import org.junit.Test;

public class SkillBasedAllocationTest {

    @Test
    public void testAllocation() {
        Employee emp = new Employee(
                "E1", "Aiswarya",
                Arrays.asList("Java"), 20, 500);

        Project project = new ClientProject(
                "P1", "Banking App", "Java", 15, "ABC Corp");

        AllocationStrategy strategy = new SkillBasedAllocation();
        strategy.allocate(project, Arrays.asList(emp));

        assertEquals(1, project.getAllocatedEmployees().size());
        assertEquals(15, emp.getUtilizedHours());
        assertEquals(5, emp.getAvailableHours());
    }
}
