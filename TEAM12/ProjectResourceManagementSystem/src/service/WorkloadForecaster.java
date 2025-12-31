package service;

import model.Employee;

public class WorkloadForecaster {

    public void forecast(Employee e) {
        if (e == null) {
            System.out.println("Employee data not available");
            return;
        }

        System.out.println(
            "Employee ID: " + e.getId() +
            ", Name: " + e.getName() +
            ", Utilized Hours: " + e.getUtilizedHours() +
            ", Remaining Hours: " + e.getAvailableHours()
        );
    }
}
