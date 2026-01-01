package com.billing.model;

public class Subscription {
    private String userName;
    private Plan plan;
    public Subscription(String userName,Plan plan){
        this.userName=userName;
        this.plan=plan;
    }
    public String getUserName(){
        return userName;
    }
    public double getAmount(){
        return plan.calculateAmount();
    }
    public Plan getPlan() {
        return plan;
    }

}
