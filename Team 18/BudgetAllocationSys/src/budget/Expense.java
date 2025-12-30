//Encapsulation
package budget;

public class Expense {
	
	private int expenseID;
	private double amount;
	private String description;
	
	public Expense(int expenseID,double amount,String description) {
		this.expenseID = expenseID;
		this.amount = amount;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
}
