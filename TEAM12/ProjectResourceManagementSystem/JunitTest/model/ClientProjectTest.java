package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClientProjectTest {

    @Test
    public void testClientProject() {
        ClientProject project = new ClientProject(
                "P1", "Banking App", "Java", 20, "ABC Corp");

        assertEquals("ABC Corp", project.getClientName());
        assertTrue(project.toString().contains("Client: ABC Corp"));
    }
}
