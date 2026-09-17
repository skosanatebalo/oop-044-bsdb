package za.co.wethinkcode.gym;

public class MonthlyMembership extends Membership {

    public static final double MONTHLY_RATE = 350.00;
    private static final int NOTICE_DAYS = 30;

    public MonthlyMembership(String memberId, int monthsSubscribed) {
        super(memberId, monthsSubscribed);
    }

    @Override
    public double totalCost() {
        return getMonthsSubscribed() * MONTHLY_RATE;
    }

    @Override
    public int cancellationNoticeDays() {
        return NOTICE_DAYS;
    }
}
