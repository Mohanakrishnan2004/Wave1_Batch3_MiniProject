package company.leave;

class InternationalTravel extends Travelrequest {

    private static final double LIMIT = 150000;

    InternationalTravel(int id, String name,
                        String destination, double amount) {
        super(id, name, destination, amount);
    }

    public void applyPolicy() {
        if (amount <= LIMIT) {
            status = "BOOKED";
        } else {
            status = "REJECTED";

        }
    }
}

