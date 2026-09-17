package za.co.wethinkcode.gym;

public class AnnualMembership extends Membership {

    public static final double FLAT_ANNUAL_RATE = 3000.00;
    private static final int NOTICE_DAYS = 60;

    public AnnualMembership(String memberId, int monthsSubscribed) {
        super(memberId, monthsSubscribed);
    }

    @Override
    public double totalCost() {
        return FLAT_ANNUAL_RATE;
    }

    @Override
    public int cancellationNoticeDays() {
        return NOTICE_DAYS;
    }
}
