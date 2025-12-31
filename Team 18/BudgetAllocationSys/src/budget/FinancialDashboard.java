package budget;

public class FinancialDashboard {
	public static void displayDashboard(Budget budget) {
		System.out.println("----- Financial Dashboard -----");
		
		double totalUsed = 0;
		
		for(Expense e:budget.getExpenses()) {
			totalUsed = totalUsed + e.getAmount();
		}
		
		System.out.println("Total Budget: " + (totalUsed + budget.getRemainingAmount()));
		System.out.println("Used Budget: " + totalUsed);
		System.out.println("Remaining Budget: " + budget.getRemainingAmount());
		System.out.println("Total Expenses: " + budget.getExpenses().size());
		
	}
}
