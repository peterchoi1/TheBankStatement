package ssa;

import java.text.DecimalFormat;
import java.util.ArrayList;

abstract class Account {

    private int id; // local variable for id
    private String description; // local variable for description
    private double balance; // local variable for description
    
    // decimal format used for each $ amount
    DecimalFormat df = new DecimalFormat("0.00"); 
    DecimalFormat interestFormat = new DecimalFormat("0.00"); 
    
    
    // holds all the IDs in order to check for duplicate IDs
    private static ArrayList<Integer> accountIdList = new ArrayList<Integer>();
    
    // used within the constructor for auto generating an Id                                              
    private static Integer count = 1; 
    
    // this constructor automatically sets the account id
    public Account() {
        setId(count);
        accountIdList.add(count);
        count++;

    }

    // this constructor automatically sets the account id and takes a
    // description input
    public Account(String description) {
        setId(count);
        setDescription(description);
        accountIdList.add(count);
        count++;
    }

    // this constructor takes inputs on id and description and checks if the id
    // is not a duplicate id
    // if it is a duplicate - one will be created for you
    public Account(int id, String description) {

        boolean duplicateFound = false;

        do {
            if (accountIdList.contains(id)) {
                id++;
                duplicateFound = true;
            } else {
                setId(id);
                setDescription(description);
                accountIdList.add(id);
                duplicateFound = false;
            }
        } while (duplicateFound == true);

    }

    // uses the checkTransfer method to see if transferring is possible with
    // ">=0" constraints.
    // if transferring is possible, attaches a unique transaction id and
    // transfers the $ amount from each account
    // adds the transaction to the arraylist
    void transferFrom(Account toAccount, double transferAmount) {
        if (checkTransfer(transferAmount) == (true)) {
            this.balance -= transferAmount;
            toAccount.balance += transferAmount;

        } else {
        }

    }

    
     String printHeader() {
//        return "T\tAct\tDescription\tBal\t\tChk\tRate\n"
//                + "============================================================";
         return String.format("%-2s%-4s%-29s%-7s%-5s%s\n= === ============================ ====== ===  ====",
                 "T", "Act","Description","Bal","Chk","Rate");
        
    }
    
    // prints out the user's account status such as ID and balance
    String print() {

        
        
//        return "Account " + getId() + " Balance is: " + df.format(getBalance());

//        return getId() + "\t" + getDescription() + "\t" + df.format(getBalance());
        
        return String.format("%-4d%-29s%-7s", getId(),getDescription(),df.format(getBalance()));
        
    }

    // sets the account ID
    private void setId(int id) {
        this.id = id;
    }

    // returns the account ID
    int getId() {
        return this.id;
    }

    // setting the account description
    void setDescription(String description) {
        this.description = description;
    }

    // returns the description
    String getDescription() {
        return this.description;
    }

    // setting the initial balance
    void setInitialBalance(double balance) {
        this.balance = balance;
    }

    // returns the balance
    double getBalance() {
        return this.balance;
    }

    // sets the balance
    private void setBalance(double balance) {
        this.balance = balance;
    }

    // check if withdrawing the amount is possible from the account
    // if possible withdraw the amount and add it to the array list
    // for past transactions
    // if impossible then println a message saying so
    void withdraw(double withdrawAmount) {

        if (this.balance - withdrawAmount >= 0) {
            this.balance -= withdrawAmount;

        } else {

        }

    }

    // check if transferring is possible as a utility for the transferBalance()
    // method
    boolean checkTransfer(double transferAmount) {

        if (this.balance - transferAmount >= 0) {
            return true;
        } else {
            return false;
        }

    }

    // deposit the desired amount to the account and add the transaction to the
    // array list
    void deposit(double depositAmount) {

        if (depositAmount > 0) {
            this.balance += depositAmount;
        }

    }

}