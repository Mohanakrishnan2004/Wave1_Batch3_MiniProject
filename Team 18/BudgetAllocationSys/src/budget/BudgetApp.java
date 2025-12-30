//Main Class
package budget;

public class BudgetApp {
	public static void main(String[] args) {
		Budget operational = new OperationalBudget(50000);
		Budget capital = new CapitalBudget(200000);
		
		try {
			operational.addExpense(new Expense(1, 10000, "Electricity"));
			operational.addExpense(new Expense(2, 20000, "Office Supplies"));
			
			capital.addExpense(new Expense(3, 100000, "Machinery"));
			operational.addExpense(new Expense(4, 30000, "Extra Expense"));
		}catch(OverspendException e) {
			System.out.println("Exception: " + e.getMessage());	
		}
		
		System.out.println("Operational Remaining: " + operational.getRemainingAmount());
		System.out.println("Capital Remaining: " + capital.getRemainingAmount());
	}
}
