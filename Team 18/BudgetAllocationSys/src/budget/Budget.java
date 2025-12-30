//Encapsulation + Polymorphism + Collections

package budget;

import java.util.List;
import java.util.ArrayList;

public abstract class Budget {
	private double totalAmount;
	private double usedAmount;
	private List<Expense> expenses;
	
	public Budget(double totalAmount) {
		this.totalAmount = totalAmount;
		this.usedAmount = 0;
		this.expenses = new ArrayList<>();
	}
	
	public double getRemainingAmount() {
		return totalAmount - usedAmount;
	}
	
	public List<Expense> getExpenses(){
		return expenses;
	}
	
	public void addExpense(Expense expense) throws OverspendException{
		if(validateExpense(expense.getAmount())) {
			expenses.add(expense);
			usedAmount += expense.getAmount();
		}else {
			throw new OverspendException ("Budget limit exceeded");
		}
	}
	
	protected abstract boolean validateExpense(double amount);
}
