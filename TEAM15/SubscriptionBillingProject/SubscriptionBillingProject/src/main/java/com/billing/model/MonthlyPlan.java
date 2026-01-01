package com.billing.model;

public class MonthlyPlan extends Plan {
    public MonthlyPlan(double price){
        super(price);
    }
    @Override
    public double calculateAmount(){
        return price;
    }
    @Override
    public String getPlanName() {
        return "Monthly Plan";
    }

    @Override
    public String getDuration() {
        return "1 Month";
    }
}
