package com.factoriaf5;

public class CurrentAccount extends Account {

  private float overdraft;

  public CurrentAccount(float balance, float annualRate) {
    super(balance, annualRate);
    this.overdraft = 0;
  }

  public float getOverdraft() {
    return overdraft;
  }

  @Override
  public void withdraw(float amount) {
    if (amount > 0) {
      if (amount <= getBalance()) {
        super.withdraw(amount);
      } else {
        overdraft += amount - getBalance();
        setBalance(0);
        setNumberOfWithdrawals(getNumberOfWithdrawals() + 1);
      }
    } else {
      System.out.println("Invalid withdrawal amount.");
    }
  }

  @Override
  public void deposit(float amount) {
    if (amount > 0) {
      if (overdraft > 0) {
        if (amount >= overdraft) {
          amount -= overdraft;
          overdraft = 0;
        } else {
          overdraft -= amount;
          amount = 0;
        }
      }
      super.deposit(amount);
    } else {
      System.out.println("Consignment amount must be positive.");
    }
  }

  @Override
  public String toString() {
    return "CurrentAccount{"
        + "balance=" + getBalance() +
        // ", numberOfEntries=" + getNumberOfEntries() +
        // ", numberOfWithdrawals=" + getNumberOfWithdrawals() +
        ", totalTransactions=" + (getNumberOfEntries() + getNumberOfWithdrawals())
        // + ", annualRate=" + getAnnualRate()
        + ", monthlyCommission=" + getMonthlyCommission()
        + ", overdraft=" + overdraft
        + '}';
  }
}
