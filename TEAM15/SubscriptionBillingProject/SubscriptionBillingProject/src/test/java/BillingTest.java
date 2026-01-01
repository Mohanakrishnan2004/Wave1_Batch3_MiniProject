
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.billing.model.AnnualPlan;
import com.billing.model.MonthlyPlan;
import com.billing.model.Plan;
import com.billing.service.PaymentService;

public class BillingTest {

    @Test
    public void testMonthlyPlanAmount() {
        Plan plan = new MonthlyPlan(300);
        assertEquals(300, plan.calculateAmount());
    }

    @Test
    public void testAnnualPlanAmount() {
        Plan plan = new AnnualPlan(300);
        assertEquals(3240, plan.calculateAmount());
    }

    @Test
    public void testInvalidPayment() {
        PaymentService service = new PaymentService();

        Exception exception = assertThrows(Exception.class, () -> {
            service.validatePayment(-10);
        });

        assertTrue(exception.getMessage().contains("Payment"));
    }
}
