package Service;

import Model.AuditLog;
import java.util.ArrayList;
import java.util.List;

public class AuditService {

    private List<AuditLog> logs = new ArrayList<>();

    public void log(String message) {
        logs.add(new AuditLog(message));
    }

    public void showLogs() {
        for (AuditLog log : logs) {
            System.out.println(log);
        }
    }
}
