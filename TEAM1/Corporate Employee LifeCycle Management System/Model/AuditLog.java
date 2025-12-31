package Model;

import java.time.LocalDateTime;

public class AuditLog {

    private String message;
    private LocalDateTime time;

    public AuditLog(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return time + " : " + message;
    }
}
