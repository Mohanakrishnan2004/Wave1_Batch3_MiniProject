package company.leave;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class TravelManagementTest {

    // ---------- Travel Request Creation ----------
    @Test
    void testTravelRequestCreation() {
        Travelrequest req =
                new DomesticTravel(1, "Amirtha", "Tamil Nadu", 50000);

        assertEquals("PENDING", req.getStatus());
    }

    // ---------- Domestic Policy Approval ----------
    @Test
    void testDomesticPolicyApproved() {
        DomesticTravel req =
                new DomesticTravel(2, "Amirtha", "Kerala", 80000);

        req.applyPolicy();
        assertEquals("BOOKED", req.getStatus());
    }

    @Test
    void testDomesticPolicyRejected() {
        DomesticTravel req =
                new DomesticTravel(3, "Amirtha", "Delhi", 120000);

        req.applyPolicy();
        assertEquals("REJECTED", req.getStatus());
    }

    // ---------- International Policy Approval ----------
    @Test
    void testInternationalPolicyApproved() {
        InternationalTravel req =
                new InternationalTravel(4, "Amirtha", "USA", 140000);

        req.applyPolicy();
        assertEquals("BOOKED", req.getStatus());
    }

    @Test
    void testInternationalPolicyRejected() {
        InternationalTravel req =
                new InternationalTravel(5, "Amirtha", "UK", 200000);

        req.applyPolicy();
        assertEquals("REJECTED", req.getStatus());
    }

    // ---------- Exception Tests ----------
    @Test
    void testDuplicateRequestException() {
        Exception ex = assertThrows(
                DuplicateRequestException.class,
                () -> {
                    throw new DuplicateRequestException("Duplicate ID");
                }
        );
        assertEquals("Duplicate ID", ex.getMessage());
    }

    @Test
    void testRequestNotFoundException() {
        Exception ex = assertThrows(
                RequestNotFoundException.class,
                () -> {
                    throw new RequestNotFoundException("Request not found");
                }
        );
        assertEquals("Request not found", ex.getMessage());
    }

    @Test
    void testInvalidExpenseException() {
        Exception ex = assertThrows(
                InvalidExpenseException.class,
                () -> {
                    throw new InvalidExpenseException("Invalid expense");
                }
        );
        assertEquals("Invalid expense", ex.getMessage());
    }
}