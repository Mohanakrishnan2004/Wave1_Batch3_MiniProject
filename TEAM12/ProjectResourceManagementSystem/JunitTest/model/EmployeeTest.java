package model;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testAllocateHoursSuccess() {
        Employee emp = new Employee(
                "E1", "Roshini",
                Arrays.asList("Java", "Python"),
                40, 500
        );

        assertTrue(emp.allocateHours(15));
        assertEquals(25, emp.getAvailableHours());
        assertEquals(15, emp.getUtilizedHours());
    }

    @Test
    public void testAllocateHoursFailure() {
        Employee emp = new Employee(
                "E2", "Roshini",
                Arrays.asList("Java"),
                10, 500
        );

        assertFalse(emp.allocateHours(20));
        assertEquals(10, emp.getAvailableHours());
        assertEquals(0, emp.getUtilizedHours());
    }

    @Test
    public void testHasSkill() {
        Employee emp = new Employee(
                "E3", "Roshini",
                Arrays.asList("Java", "Python"),
                40, 500
        );

        assertTrue(emp.hasSkill("Java"));
        assertFalse(emp.hasSkill("SQL"));
    }
}
