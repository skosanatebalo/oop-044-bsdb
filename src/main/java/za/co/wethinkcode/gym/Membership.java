package za.co.wethinkcode.gym;

public  abstract  class Membership {

    private final String memberId;
    private final int monthsSubscribed;

    protected Membership(String memberId, int monthsSubscribed) {
        this.memberId = memberId;
        this.monthsSubscribed = monthsSubscribed;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthsSubscribed() {
        return monthsSubscribed;
    }

    public abstract double totalCost();

    public abstract int cancellationNoticeDays();

    @Override
    public String toString() {
        return String.format(
                "%s[memberId=%s, monthsSubscribed=%d, totalCost=%.2f, cancellationNoticeDays=%d]",
                getClass().getSimpleName(), memberId, monthsSubscribed, totalCost(), cancellationNoticeDays());
    }
}
