package ssa;

public class Savings extends Account {

    private double interestRate; // local variable for interest rate
    private double minimumBalance; // local variable for minimum balance
    private double totalInterestEarned; // local variable for total interest
                                        // earned
    private final String typeOfAccount = "S";

    public String getType() {
        return this.typeOfAccount;
    }

    // default constructor
    public Savings() {
        super();
    }

    // returns a string that contains account print() and also total interest
    // earned
    public String print() {
//        return getType() + "\t" + super.print() + " \t\t" + interestFormat.format(getInterestRate()*100);
        return String.format("%-2s%-45s%s",getType(),super.print(),interestFormat.format(getInterestRate()*100));
    }

    // constructor that accepts a description
    public Savings(String description) {
        super(description);
    }

    // constructor that will accept an id and a description
    // if the input for id is a duplicate id, an unused one will be
    // assigned automatically
    public Savings(int id, String description) {
        super(id, description);
    }

    // returns the total interest earned
    public double getTotalInterestEarned() {
        // this is a different alternative for rounding
        // double val = this.totalInterestEarned;
        // val *= 100;
        // val = (double)((int) val);
        // val /= 100;
        // return val;

        return this.totalInterestEarned;

    }

    // returns the minimum balance
    public double getMinimumBalance() {
        return minimumBalance;
    }

    // sets the minimum balance
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    // returns the interest rate
    public double getInterestRate() { // gets the interest rate
        return this.interestRate;
    }

    // sets the interest rate
    public void setIntRate(double interestRate) { // sets the interest rate
        this.interestRate = interestRate;
    }

    // calculates and deposits the interest, only if the minimum balance is met
    public double calcDepositInterest(int months) {

        double calculatedInterest = ((getInterestRate() / 12) * months);
        double depositedAmount = calculatedInterest * super.getBalance();

        if (getBalance() >= getMinimumBalance()) {

            super.deposit(depositedAmount);
            this.totalInterestEarned += depositedAmount;

            return depositedAmount;

        } else {

            return 0.00;

        }

    }

}
