package company.leave;

import java.util.*;

public class Main {

    static Map<Integer, Travelrequest> requestMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Travel Request");
            System.out.println("2. Policy-Based Approval");
            System.out.println("3. Booking Tracking");
            System.out.println("4. Linked Expense");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> travelRequest(sc);
                    case 2 -> policyApproval(sc);
                    case 3 -> bookingTracking(sc);
                    case 4 -> linkedExpense(sc);
                    case 5 -> System.out.println("Exited Successfully");
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }

    // -------- Travel Request --------
    static void travelRequest(Scanner sc) throws DuplicateRequestException {

        System.out.print("Request ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (requestMap.containsKey(id))
            throw new DuplicateRequestException("Request ID already exists");

        System.out.print("Employee Name: ");
        String name = sc.nextLine();

        System.out.println("1. Domestic  2. International");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Destination: ");
        String dest = sc.nextLine();

        System.out.print("Amount: ");
        double amt = sc.nextDouble();

        Travelrequest req =
                (type == 1)
                        ? new DomesticTravel(id, name, dest, amt)
                        : new InternationalTravel(id, name, dest, amt);

        requestMap.put(id, req);
        System.out.println("Request submitted. Status: PENDING");
    }

    // -------- Policy Approval --------
    static void policyApproval(Scanner sc) throws RequestNotFoundException {

        System.out.print("Enter Request ID: ");
        int id = sc.nextInt();

        Travelrequest req = requestMap.get(id);
        if (req == null)
            throw new RequestNotFoundException("Request not found");

        if (req instanceof DomesticTravel)
            ((DomesticTravel) req).applyPolicy();
        else
            ((InternationalTravel) req).applyPolicy();

        System.out.println("Updated Status: " + req.getStatus());
    }

    // -------- Booking Tracking --------
    static void bookingTracking(Scanner sc) throws RequestNotFoundException {

        System.out.print("Enter Request ID: ");
        int id = sc.nextInt();

        Travelrequest req = requestMap.get(id);
        if (req == null)
            throw new RequestNotFoundException("Request not found");

        System.out.println("Current Status: " + req.getStatus());
    }

    // -------- Linked Expense --------
    static void linkedExpense(Scanner sc)
            throws RequestNotFoundException, InvalidExpenseException {

        System.out.print("Enter Request ID: ");
        int id = sc.nextInt();

        Travelrequest req = requestMap.get(id);
        if (req == null)
            throw new RequestNotFoundException("Request not found");

        if (!req.getStatus().equals("BOOKED"))
            throw new InvalidExpenseException("Expense allowed only after booking");

        System.out.print("Enter Expense Amount: ");
        double expense = sc.nextDouble();

        if (expense <= req.amount) {
            req.status = "APPROVED";
            System.out.println("Expense approved");
        } else {
            throw new InvalidExpenseException("Expense exceeds approved amount");
        }
    }
}
