package company.leave;

class Travelrequest {
    protected int requestId;
    protected String employeeName;
    protected String destination;
    protected double amount;
    protected String status;

    Travelrequest(int requestId, String employeeName,
                  String destination, double amount) {
        this.requestId = requestId;
        this.employeeName = employeeName;
        this.destination = destination;
        this.amount = amount;
        this.status = "PENDING";
    }

    public String getStatus() {
        return status;
    }
}
