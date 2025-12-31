package service;

import static org.junit.Assert.*;
import java.util.Arrays;
import model.Employee;
import org.junit.Test;

public class WorkloadForecasterTest {

	@Test
    public void testForecast() {
        Employee emp = new Employee(
                "E1", "Arjun",
                Arrays.asList("Python"), 30, 450);

        emp.allocateHours(10);

        WorkloadForecaster forecaster = new WorkloadForecaster();
        forecaster.forecast(emp);

        assertEquals(20, emp.getAvailableHours());
        assertEquals(10, emp.getUtilizedHours());
    }
}

