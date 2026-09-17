package za.co.wethinkcode.gym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnnualMembershipTest {

    @Test
    void totalCost_isFlatAnnualRate_forFewMonthsSubscribed() {
        AnnualMembership membership = new AnnualMembership("GYM-007", 1);
        assertEquals(AnnualMembership.FLAT_ANNUAL_RATE, membership.totalCost(), 0.001);
    }

    @Test
    void totalCost_isFlatAnnualRate_forManyMonthsSubscribed() {
        AnnualMembership membership = new AnnualMembership("GYM-008", 24);
        assertEquals(AnnualMembership.FLAT_ANNUAL_RATE, membership.totalCost(), 0.001);
    }

    @Test
    void totalCost_doesNotScaleWithMonthsSubscribed() {
        AnnualMembership few = new AnnualMembership("GYM-009", 1);
        AnnualMembership many = new AnnualMembership("GYM-010", 12);
        assertEquals(few.totalCost(), many.totalCost(), 0.001);
    }

    @Test
    void cancellationNoticeDays_isSixtyDays() {
        AnnualMembership membership = new AnnualMembership("GYM-011", 2);
        assertEquals(60, membership.cancellationNoticeDays());
    }

    @Test
    void cancellationNoticeDays_isLongerThanMonthlyMembership() {
        AnnualMembership annual = new AnnualMembership("GYM-012", 2);
        MonthlyMembership monthly = new MonthlyMembership("GYM-013", 2);
        assertTrue(annual.cancellationNoticeDays() > monthly.cancellationNoticeDays());
    }

    @Test
    void getMemberId_returnsMemberIdProvided() {
        AnnualMembership membership = new AnnualMembership("GYM-014", 5);
        assertEquals("GYM-014", membership.getMemberId());
    }
}
