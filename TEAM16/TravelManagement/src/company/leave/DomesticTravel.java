package company.leave;

import java.util.HashSet;

class DomesticTravel extends Travelrequest {

    private static final double LIMIT = 100000;
    private static HashSet<String> allowedPlaces = new HashSet<>();

    static {
        allowedPlaces.add("Chennai");
        allowedPlaces.add("Bangalore");
        allowedPlaces.add("Ooty");
        allowedPlaces.add("Munnar");
        allowedPlaces.add("Coorg");
        allowedPlaces.add("Wayanad");
        allowedPlaces.add("Hyderabad");
    }

    DomesticTravel(int id, String name,
                   String destination, double amount) {
        super(id, name, destination, amount);
    }

    public void applyPolicy() {
        if (allowedPlaces.contains(destination) && amount <= LIMIT) {
            status = "BOOKED";
        } else {
            status = "REJECTED";
        }
    }
}
