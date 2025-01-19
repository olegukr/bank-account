package com.factoriaf5;

public class Account {

  // Attributes
  private float balance;
  private int numberOfEntries;
  private int numberOfWithdrawals;
  private float annualRate;
  private float monthlyCommission;

  // Constructor
  public Account(float balance, float annualRate) {
      this.balance = balance;
      this.annualRate = annualRate;
      this.numberOfEntries = 0;
      this.numberOfWithdrawals = 0;
      this.monthlyCommission = 0.0f;
  }

  // Getters and Setters
  public float getBalance() {
      return balance;
  }

  public void setBalance(float balance) {
      this.balance = balance;
  }

  public int getNumberOfEntries() {
      return numberOfEntries;
  }

  public void setNumberOfEntries(int numberOfEntries) {
      this.numberOfEntries = numberOfEntries;
  }

  public int getNumberOfWithdrawals() {
      return numberOfWithdrawals;
  }

  public void setNumberOfWithdrawals(int numberOfWithdrawals) {
      this.numberOfWithdrawals = numberOfWithdrawals;
  }

  public float getAnnualRate() {
      return annualRate;
  }

  public void setAnnualRate(float annualRate) {
      this.annualRate = annualRate;
  }

  public float getMonthlyCommission() {
      return monthlyCommission;
  }

  public void setMonthlyCommission(float monthlyCommission) {
      this.monthlyCommission = monthlyCommission;
  }

  public void deposit(float amount) {
    if (amount > 0) {
        balance += amount;
        numberOfEntries++;
    } else {
        System.out.println("Deposit amount must be positive.");
    }
  }

  public void withdraw(float amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        numberOfWithdrawals++;
    } else {
        System.out.println("Invalid withdrawal amount.");
    }
  }

  public void calculateMonthlyInterest() {
    float monthlyInterest = (annualRate / 12) / 100 * balance;
    balance += monthlyInterest;
  }

  public void generateMonthlyStatement() {
    balance -= monthlyCommission;
    calculateMonthlyInterest();
  }

  @Override
  public String toString() {
      return "Account{" +
              "balance=" + balance +
              ", numberOfEntries=" + numberOfEntries +
              ", numberOfWithdrawals=" + numberOfWithdrawals +
              ", annualRate=" + annualRate +
              ", monthlyCommission=" + monthlyCommission +
              '}';
  }
}
