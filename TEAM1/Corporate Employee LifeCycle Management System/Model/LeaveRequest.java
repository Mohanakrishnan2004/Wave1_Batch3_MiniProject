package Model;

public class LeaveRequest {

    private int empId;
    private int days;

    public LeaveRequest(int empId, int days) {
        this.empId = empId;
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
