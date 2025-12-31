package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class InternalProjectTest {

    @Test
    public void testInternalProject() {
        InternalProject project = new InternalProject(
                "P2", "Data Analysis", "Python", 25, "Analytics Dept");

        assertEquals("Analytics Dept", project.getDepartment());
        assertTrue(project.toString().contains("Department"));
    }
}
