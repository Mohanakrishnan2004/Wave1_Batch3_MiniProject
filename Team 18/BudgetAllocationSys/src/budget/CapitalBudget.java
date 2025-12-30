//inheritance
package budget;

public class CapitalBudget extends Budget{
	public CapitalBudget (double totalAmount) {
		super(totalAmount);
	}
	
	protected boolean validateExpense(double amount) {
		return amount <= getRemainingAmount();
	}
}
