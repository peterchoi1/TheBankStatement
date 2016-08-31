package ssa;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankStatementTest {

    @Test
    public void testingLastCheckNumber() {

        Checking checking1 = new Checking();
        Checking checking2 = new Checking();

        checking1.setLastCheckNbr(100);
        checking2.setLastCheckNbr(200);

        assertEquals(100, checking1.getLastCheckNbr());
        assertEquals(200, checking2.getLastCheckNbr());

    }

    @Test
    public void testingAccountType() {
        Checking checking1 = new Checking();
        Savings savings1 = new Savings();

        assertEquals("C", checking1.getType());
        assertEquals("S", savings1.getType());

    }

    @Test
    public void testingGetBalance() {
        // all accounts should test for $0.00 balance
        Checking checking1 = new Checking();
        Checking checking2 = new Checking();
        Savings savings1 = new Savings();
        Savings savings2 = new Savings();
        assertEquals(0.00, checking1.getBalance(), 0);
        assertEquals(0.00, checking2.getBalance(), 0);
        assertEquals(0.00, savings1.getBalance(), 0);
        assertEquals(0.00, savings2.getBalance(), 0);
    }

    @Test
    public void testingDepositWithdrawTransfer() {
        // account1 should have a balance of $100.00 after depositing $100.00
        Checking checking1 = new Checking();
        Checking checking2 = new Checking();
        Savings savings1 = new Savings();
        Savings savings2 = new Savings();

        checking1.deposit(100.00);
        assertEquals(100.00, checking1.getBalance(), 0);

        // account 1 should have a balance of $50.00 after depositing $50.00
        checking1.withdraw(50.00);
        assertEquals(50.00, checking1.getBalance(), 0);

        // account 1 is transferring $10.00 to account 2
        checking1.transferFrom(checking2, 10.00);
        // new Account().transferFrom(account2, 10.0);
        assertEquals(40.00, checking1.getBalance(), 0);
        assertEquals(10.00, checking2.getBalance(), 0);

        // account 1 and account 2 balances should not be
        // any different from before
        // the amount being transferred is not possible
        checking1.transferFrom(checking2, 10000000.00);
        assertEquals(40.00, checking1.getBalance(), 0);
        assertEquals(10.00, checking2.getBalance(), 0);
        
        savings1.deposit(10000.00);
        assertEquals(10000.00, savings1.getBalance(), 0);
        savings1.transferFrom(savings2, 500.00);
        assertEquals(9500.00, savings1.getBalance(), 0);
        assertEquals(500.00, savings2.getBalance(), 0);
    }

    @Test
    public void testingGetDescription() {
        // testing the description
        Checking checking1 = new Checking();
        Savings savings1 = new Savings();

        checking1.setDescription("This is account number 1.");
        assertEquals("This is account number 1.", checking1.getDescription());

        savings1.setDescription("This is a savings account");
        assertEquals("This is a savings account", savings1.getDescription());
    }

    @Test
    public void testingSavingsInterest() {

        Savings savings1 = new Savings();
        Savings savings2 = new Savings();

        // testing if the minimum balance, interest rate, and total interest
        // earned
        savings1.deposit(10000.00);
        assertEquals(0, savings1.getMinimumBalance(), 0);
        savings1.setMinimumBalance(100.00);
        assertEquals(100, savings1.getMinimumBalance(), 0);
        savings1.setIntRate(0.01);
        savings1.calcDepositInterest(12);
        assertEquals(0.01, savings1.getInterestRate(), 0);
        assertEquals(100, savings1.getTotalInterestEarned(), 0);

        // testing that no interest is earned due to being under minimum balance
        savings2.deposit(100.00);
        savings2.setMinimumBalance(500.00);
        savings2.setIntRate(0.5);
        savings2.calcDepositInterest(12);
        assertEquals(100, savings2.getBalance(), 0);
        assertEquals(0, savings2.getTotalInterestEarned(), 0);
    }

}
