package Service;

import Model.Payroll;
import util.SalaryCalculator;

public class PayrollService {

    public Payroll generatePayroll(int empId, double salary) {
        double net = SalaryCalculator.calculate(salary);
        return new Payroll(empId, net);
    }
}
