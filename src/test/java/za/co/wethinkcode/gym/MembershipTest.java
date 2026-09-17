package za.co.wethinkcode.gym;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MembershipTest {

    @Test
    void membership_cannotBeInstantiatedOnItsOwn() {
        assertTrue(Modifier.isAbstract(Membership.class.getModifiers()),
                "Membership should be an abstract class - every membership is a MonthlyMembership or an AnnualMembership");
    }

    @Test
    void totalCost_isDeclaredAbstract() throws NoSuchMethodException {
        Method totalCost = Membership.class.getDeclaredMethod("totalCost");
        assertTrue(Modifier.isAbstract(totalCost.getModifiers()),
                "Membership cannot work out a total cost on its own - each subclass must supply it");
    }

    @Test
    void cancellationNoticeDays_isDeclaredAbstract() throws NoSuchMethodException {
        Method cancellationNoticeDays = Membership.class.getDeclaredMethod("cancellationNoticeDays");
        assertTrue(Modifier.isAbstract(cancellationNoticeDays.getModifiers()),
                "Membership cannot work out its cancellation notice on its own - each subclass must supply it");
    }
}
