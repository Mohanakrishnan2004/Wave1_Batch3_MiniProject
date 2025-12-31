package Model;

public class Attendance {

    private int empId;
    private int daysPresent;

    public Attendance(int empId, int daysPresent) {
        this.empId = empId;
        this.daysPresent = daysPresent;
    }

    public int getDaysPresent() {
        return daysPresent;
    }
}
