import java.util.Arrays;
import java.util.List;

import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        
        //Create employees
        Employee e1 = new Employee("E1", "Aiswarya", Arrays.asList("Java", "SQL"), 40, 500);
        Employee e2 = new Employee("E2", "Roshini", Arrays.asList("Python"), 30, 400);
        Employee e3 = new Employee("E3", "Arjun", Arrays.asList("Java", "Python"), 35, 450);
        Employee e4 = new Employee("E4", "John", Arrays.asList("SQL", "Python"), 25, 420);
        
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);
        
        //Create projects
        Project javaProject = new ClientProject("P1", "Banking App", "Java", 20, "ABC Corp");
        Project pythonProject = new InternalProject("P2", "Data Analysis", "Python", 25, "Analytics Dept");
        
        //Choose allocation strategy
        AllocationStrategy strategy = new SkillBasedAllocation();
        
        //Allocate employees to projects
        System.out.println("--- Allocating Java Project ---");
        strategy.allocate(javaProject, employees);
        
        System.out.println("\n--- Allocating Python Project ---");
        strategy.allocate(pythonProject, employees);
        
        //Display project details
        System.out.println("\n=== Project Details ===");
        System.out.println(javaProject);
        System.out.println(pythonProject);
        
        //Forecast employee workload
        WorkloadForecaster forecaster = new WorkloadForecaster();
        System.out.println("\n=== Employee Workload ===");
        for (Employee e : employees) {
            forecaster.forecast(e);
        }
        
        //Generate billing
        BillingService billing = new BillingService();
        System.out.println("\n=== Billing Summary ===");
        billing.generateBill(javaProject);
        billing.generateBill(pythonProject);
    }
}
