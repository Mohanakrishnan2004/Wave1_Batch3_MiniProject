package model;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class ProjectTest {

    @Test
    public void testAddEmployee() {
        Project project = new ClientProject(
                "P1", "Test Project", "Java", 10, "ClientX");

        Employee emp = new Employee(
                "E1", "Aiswarya",
                Arrays.asList("Java"), 40, 500);

        project.addEmployee(emp);

        assertEquals(1, project.getAllocatedEmployees().size());
        assertEquals("Aiswarya",
                project.getAllocatedEmployees().get(0).getName());
    }
}
