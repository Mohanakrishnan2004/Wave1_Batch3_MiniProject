package com.billing.service;
import com.billing.model.Invoice;
import com.billing.model.Subscription;

public class BillingService {
    public void generateBill(Subscription subscription) {
        Invoice invoice = new Invoice();
        invoice.printInvoice(
                subscription.getUserName(),
                subscription.getPlan()
        );
    }
}
