package com.billing.model;

public class Invoice {
    public void printInvoice(String user,Plan plan){
        System.out.println("-------- INVOICE --------");
        System.out.println("Customer Name : " + user);
        System.out.println("Plan Type     : " + plan.getPlanName());
        System.out.println("Duration      : " + plan.getDuration());
        System.out.println("Base Price    : ₹" + plan.price);
        System.out.println("Total Amount  : ₹" + plan.calculateAmount());
        System.out.println("-------------------------");
    }
}
