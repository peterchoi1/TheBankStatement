package ssa;

public class Checking extends Account {

    private final String typeOfAccount = "C";
    private int lastCheckNumber;

    public Checking() {
        super();
    }

    public String getType() {
        return this.typeOfAccount;
    }

    public String print() {
//        return getType() + "\t" + super.print() + "\t\t" +getLastCheckNbr();
        return String.format("%-2s%-4s%d",getType(),super.print(),getLastCheckNbr());
    }

    public void setLastCheckNbr(int checkNumber) {
        this.lastCheckNumber = checkNumber;
    }

    public int getLastCheckNbr() {
        return this.lastCheckNumber;
    }

}
