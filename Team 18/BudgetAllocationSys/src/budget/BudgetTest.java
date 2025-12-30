package budget;

import static org.junit.Assert.*;
import org.junit.Test;

public class BudgetTest {
	
	@Test
	public void testRemainingBudgetAfterExpenses() throws OverspendException {
		
		Budget budget = new OperationalBudget(10000);
		budget.addExpense(new Expense(1, 9000, "JUnit Test Expense"));
		
		assertEquals(1000, budget.getRemainingAmount(), 0.0);
	}
}
