package service;

import static org.junit.Assert.*;
import java.util.Arrays;
import model.*;
import org.junit.Test;

public class BillingServiceTest {

    @Test
    public void testGenerateBill() {
        Employee emp = new Employee(
                "E1", "John",
                Arrays.asList("Java"), 20, 500);

        emp.allocateHours(10);

        Project project = new ClientProject(
                "P1", "Test Project", "Java", 10, "Client");

        project.addEmployee(emp);

        BillingService billing = new BillingService();

        billing.generateBill(project);
        assertTrue(true);
    }
}
