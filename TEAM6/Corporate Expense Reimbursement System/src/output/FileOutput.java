package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import model.Expense;
import model.Employee;

public class FileOutput {

    public static void writeOutput(Employee employee,
                                   Expense expense,
                                   double reimbursedAmount) {

        try {

            String projectPath = System.getProperty("user.dir");
            File file = new File(projectPath + "/src/reimbursement_output.txt");

            FileWriter writer = new FileWriter(file, true);

            writer.write("Employee ID      : " + employee.getEmpId() + "\n");
            writer.write("Employee Name    : " + employee.getName() + "\n");
            writer.write("Expense ID       : " + expense.getExpenseId() + "\n");
            writer.write("Expense Category : " + expense.getCategory() + "\n"); 
            writer.write("Expense Amount   : " + expense.getAmount() + "\n");
            writer.write("Reimbursed Amt   : " + reimbursedAmount + "\n");
            writer.write("Final Status     : " + expense.getStatus() + "\n");
            writer.write("-----------------------------------\n");

            writer.close();

            System.out.println("File created at: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}
