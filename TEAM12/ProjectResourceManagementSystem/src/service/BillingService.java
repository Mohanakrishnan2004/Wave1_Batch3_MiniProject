package service;

import model.Employee;
import model.Project;

public class BillingService {

    public void generateBill(Project project) {

        if (project == null || project.getAllocatedEmployees().isEmpty()) {
            System.out.println("No billing information available.");
            return;
        }

        double totalCost = 0;

        System.out.println("----- Billing for " + project.getName() + " -----");

        for (Employee e : project.getAllocatedEmployees()) {
            double cost = e.getUtilizedHours() * e.getHourlyRate();
            totalCost += cost;

            System.out.println(
                e.getId() + " - " + e.getName() + ": " +
                e.getUtilizedHours() + " hours × ₹" +
                e.getHourlyRate() + " = ₹" + cost
            );
        }

        System.out.println("Total Cost: ₹" + totalCost);
        System.out.println("--------------------------------------");
    }
}
