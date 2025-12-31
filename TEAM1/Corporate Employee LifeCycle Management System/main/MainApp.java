package main;

import Model.*;
import Service.*;
import java.util.Scanner;
import util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeService empService = new EmployeeService();
        AttendanceService attendanceService = new AttendanceService();
        LeaveService leaveService = new LeaveService();
        PayrollService payrollService = new PayrollService();
        AuditService auditService = new AuditService();

        while (true) {

            System.out.println("\n===== CORPORATE EMPLOYEE LIFECYCLE MANAGEMENT =====");
            System.out.println("1 Add Employee");
            System.out.println("2 View Employees");
            System.out.println("3 Change Department");
            System.out.println("4 Apply Leave");
            System.out.println("5 Mark Attendance");
            System.out.println("6 Generate Payroll");
            System.out.println("7 View Audit Trail");
            System.out.println("8 Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {


                case 1:
                    int id = IdGenerator.generateId();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("1 Permanent  2 Contract: ");
                    int type = sc.nextInt();

                    Employee emp = (type == 1)
                            ? new permanentEmployee(id, name, dept, salary)
                            : new contractEmployee(id, name, dept, salary);

                    empService.addEmployee(emp);
                    auditService.log("Employee onboarded: " + id);
                    System.out.println("Employee added successfully");
                    break;

                case 2:
                    empService.viewAll();
                    break;

                case 3:
                    System.out.print("Employee ID: ");
                    emp = empService.search(sc.nextInt());
                    sc.nextLine();

                    if (emp != null) {
                        System.out.print("New Department: ");
                        String newDept = sc.nextLine();
                        emp.setDepartment(newDept);
                        auditService.log("Department changed for Employee ID: " + emp.getId());
                        System.out.println("Department updated");
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 4:
                    System.out.print("Employee ID: ");
                    emp = empService.search(sc.nextInt());

                    if (emp != null) {
                        System.out.print("Number of leave days: ");
                        int days = sc.nextInt();
                        if(days<2){
                        LeaveRequest request = new LeaveRequest(emp.getId(), days);
                        leaveService.applyLeave(emp, request);
                        auditService.log("Leave requested by Employee ID: " + emp.getId());
                    } else {
                        System.out.println("Leave not Approved");
                    }}else{
                        System.out.println("Employee Not Found");
                    }
                    break;

                // 5️⃣ MARK ATTENDANCE
                case 5:
                    System.out.print("Employee ID: ");
                    int empId = sc.nextInt();

                    System.out.print("Days Present: ");
                    int daysPresent = sc.nextInt();

                    Attendance attendance = attendanceService.markAttendance(empId, daysPresent);
                    auditService.log("Attendance marked for Employee ID: " + empId +
                            " Days: " + attendance.getDaysPresent());
                    System.out.println("Attendance recorded");
                    break;

                // 6️⃣ GENERATE PAYROLL
                case 6:
                    System.out.print("Employee ID: ");
                    emp = empService.search(sc.nextInt());

                    if (emp != null) {
                        Payroll payroll = payrollService.generatePayroll(emp.getId(), emp.getSalary());
                        System.out.println(payroll);
                        auditService.log("Payroll generated for Employee ID: " + emp.getId());
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                // 7️⃣ VIEW AUDIT TRAIL
                case 7:
                    auditService.showLogs();
                    break;

                // 8️⃣ EXIT
                case 8:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
