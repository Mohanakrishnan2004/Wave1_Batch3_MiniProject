package com.billing.model;

public abstract class Plan {
    protected double price;
    public Plan(double price){
        this.price=price;
    }
    public abstract double calculateAmount();
    public abstract String getPlanName();
    public abstract String getDuration();

}
