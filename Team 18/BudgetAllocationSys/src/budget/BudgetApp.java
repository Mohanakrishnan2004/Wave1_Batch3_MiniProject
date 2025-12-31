//Main Class
package budget;

import java.util.Scanner;

public class BudgetApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Budget budget = null;
		
		//We are going to choose the type of budget
		System.out.println("Choose budget type:");
		System.out.println("1. Operational budget,");
		System.out.println("2. Capital budget.");
		int choice = scan.nextInt();
		
		//Entering the budget amount
		System.out.println("Enter total budget amount");
		double totalAmount = scan.nextDouble();
		
		if(choice == 1) {
			budget = new OperationalBudget(totalAmount);
		} else if(choice == 2) {
			budget = new CapitalBudget(totalAmount);
		} else {
			System.out.println("Invalid choice");
			scan.close();
			return;
		}
		
		//Entering number of expenses
		System.out.println("Enter number of expenses:");
		int count = scan.nextInt();
		
		//Adding expenses
		for(int i=1;i<=count;i++) {
			
			System.out.println("Enter expense ID:");
			int id = scan.nextInt();
			
			System.out.println("Enter expense amount:");
			double amount = scan.nextDouble();
			
			  if (amount > budget.getRemainingAmount()) {
			        System.out.println("Exception: Budget limit exceeded");
			        break;
			    }
			
			scan.nextLine(); //Consuming newline
			
			System.out.println("Enter expense description:");
			String description = scan.nextLine();
		
		
		
		try{
			budget.addExpense(new Expense(id, amount, description));
		} 
		catch(OverspendException e) {
			System.out.println("Exception: " + e.getMessage());	
			break;
		}
	}
		
		//Displaying dashboard
		FinancialDashboard.displayDashboard(budget);
		
		//Forecasting
		System.out.println("-----------------------------------------");
		System.out.println("Enter expected amount of future expenses:");
		int futureCount = scan.nextInt();
		
		double forecast = budget.forecastRemainingBudget(futureCount);
		
		System.out.println("Forecasted remaining budget: " + forecast);
		System.out.println("-----------------------------------------");
		
		scan.close();
	}
}
