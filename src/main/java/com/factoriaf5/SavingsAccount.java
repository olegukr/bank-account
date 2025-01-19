package com.factoriaf5;

public class SavingsAccount extends Account{

  private boolean isActive;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        updateActivityStatus();
    }

    private void updateActivityStatus() {
        isActive = getBalance() >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
            updateActivityStatus();
        } else {
            System.out.println("Account is inactive. Cannot deposit.");
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive) {
            super.withdraw(amount);
            updateActivityStatus();
        } else {
            System.out.println("Account is inactive. Cannot withdraw.");
        }
    }

    @Override
    public void generateMonthlyStatement() {
        if (getNumberOfWithdrawals() > 4) {
            setMonthlyCommission(getMonthlyCommission() + 1000 * (getNumberOfWithdrawals() - 4));
        }
        super.generateMonthlyStatement();
        updateActivityStatus();
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + getBalance() +
                // ", numberOfEntries=" + getNumberOfEntries() +
                // ", numberOfWithdrawals=" + getNumberOfWithdrawals() +
                ", totalTransactions=" + (getNumberOfEntries() + getNumberOfWithdrawals()) +
                // ", annualRate=" + getAnnualRate() +
                ", monthlyCommission=" + getMonthlyCommission() +
                '}';
    }



}
