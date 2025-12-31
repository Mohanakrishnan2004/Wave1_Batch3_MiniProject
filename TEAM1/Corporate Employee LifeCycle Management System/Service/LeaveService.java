package Service;

import Model.Employee;
import Model.LeaveRequest;

public class LeaveService {

    public void applyLeave(Employee e, LeaveRequest request) {
        if (e.canApproveLeave()) {
            System.out.println("Leave approved");
        } else {
            System.out.println("Leave sent for approval");
        }
    }
}
