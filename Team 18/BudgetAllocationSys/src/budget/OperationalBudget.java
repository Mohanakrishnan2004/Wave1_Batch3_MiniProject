//inheritance
package budget;

public class OperationalBudget extends Budget{
	public OperationalBudget(double totalAmount) {
		super(totalAmount);
	}
	
	protected boolean validateExpense(double amount) {
		return amount <= getRemainingAmount();
	}
}
