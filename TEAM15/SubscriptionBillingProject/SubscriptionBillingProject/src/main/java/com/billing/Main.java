package com.billing;

import java.util.Scanner;

import com.billing.exception.InvalidPaymentException;
import com.billing.model.AnnualPlan;
import com.billing.model.MonthlyPlan;
import com.billing.model.Plan;
import com.billing.model.Subscription;
import com.billing.service.BillingService;
import com.billing.service.PaymentService;
import com.billing.service.SubscriptionService;
import com.billing.util.Validator;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String userName = sc.nextLine();

            if (!Validator.isValidUser(userName)) {
                System.out.println("Invalid user name!");
                return;
            }

            System.out.println("\nSelect Plan:");
            System.out.println("1. Monthly Plan (Rs299)");
            System.out.println("2. Annual Plan (Rs299 * 12 with 10% discount)");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            Plan plan;
            switch (choice) {
                case 1:
                    plan = new MonthlyPlan(299);
                    break;
                case 2:
                    plan = new AnnualPlan(299);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            Subscription subscription = new Subscription(userName, plan);

            PaymentService paymentService = new PaymentService();
            paymentService.validatePayment(subscription.getAmount());

            SubscriptionService subscriptionService = new SubscriptionService();
            subscriptionService.addSubscription(subscription);

            BillingService billingService = new BillingService();
            billingService.generateBill(subscription);

        } catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}
