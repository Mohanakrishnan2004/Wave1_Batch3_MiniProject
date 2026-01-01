package com.billing.service;
import com.billing.model.Subscription;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionService {
    private List<Subscription> subscriptions = new ArrayList<>();
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }



}
