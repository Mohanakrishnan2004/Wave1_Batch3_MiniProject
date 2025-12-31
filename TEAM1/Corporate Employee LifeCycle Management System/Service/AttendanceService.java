package Service;

import Model.Attendance;

public class AttendanceService {

    public Attendance markAttendance(int empId, int days) {
        return new Attendance(empId, days);
    }
}
