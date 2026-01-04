package model;

public abstract class Expense {

    private int expenseId;
    private double amount;
    private String status;
    private Receipt receipt;   
    private String category;

    public Expense(int expenseId, double amount) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.status = "SUBMITTED";
    }

    public int getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Receipt getReceipt() {
        return receipt;
    }
    
    public String getCategory() {
        return category;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public abstract double calculateReimbursement();
}
