package za.co.wethinkcode.gym;

public class Main {

    public static void main(String[] args) {
        Membership monthly = new MonthlyMembership("GYM-1001", 4);
        Membership annual = new AnnualMembership("GYM-2002", 4);

        System.out.println(monthly);
        System.out.println(annual);
    }
}
