package za.co.wethinkcode.gym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonthlyMembershipTest {

    @Test
    void totalCost_isMonthlyRateTimesMonthsSubscribed() {
        MonthlyMembership membership = new MonthlyMembership("GYM-001", 6);
        assertEquals(6 * MonthlyMembership.MONTHLY_RATE, membership.totalCost(), 0.001);
    }

    @Test
    void totalCost_scalesWithMonthsSubscribed() {
        MonthlyMembership few = new MonthlyMembership("GYM-002", 2);
        MonthlyMembership many = new MonthlyMembership("GYM-003", 12);
        assertTrue(many.totalCost() > few.totalCost());
    }

    @Test
    void cancellationNoticeDays_isThirtyDays() {
        MonthlyMembership membership = new MonthlyMembership("GYM-004", 1);
        assertEquals(30, membership.cancellationNoticeDays());
    }

    @Test
    void getMemberId_returnsMemberIdProvided() {
        MonthlyMembership membership = new MonthlyMembership("GYM-005", 3);
        assertEquals("GYM-005", membership.getMemberId());
    }

    @Test
    void getMonthsSubscribed_returnsMonthsProvided() {
        MonthlyMembership membership = new MonthlyMembership("GYM-006", 9);
        assertEquals(9, membership.getMonthsSubscribed());
    }
}
