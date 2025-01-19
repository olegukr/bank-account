package com.factoriaf5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AccountTest {

  @Test
  public void testAccountConstructor() {
    float initialBalance = 1000.0f;
    float annualRate = 5.0f;
    Account account = new Account(initialBalance, annualRate);

    assertEquals(initialBalance, account.getBalance());
    assertEquals(annualRate, account.getAnnualRate());
    assertEquals(0, account.getNumberOfEntries());
    assertEquals(0, account.getNumberOfWithdrawals());
    assertEquals(0.0f, account.getMonthlyCommission());
  }

  @Test
  public void testDeposit() {
    Account account = new Account(1000.0f, 5.0f);
    account.deposit(500.0f);

    assertEquals(1500.0f, account.getBalance());
    assertEquals(1, account.getNumberOfEntries());
  }

  @Test
  public void testWithdraw() {
    Account account = new Account(1000.0f, 5.0f);
    account.withdraw(500.0f);

    assertEquals(500.0f, account.getBalance());
    assertEquals(1, account.getNumberOfWithdrawals());
  }

  @Test
  public void testCalculateMonthlyInterest() {
    Account account = new Account(1200.0f, 12.0f);
    account.calculateMonthlyInterest();

    assertEquals(1212.0f, account.getBalance(), 0.01f);
  }

  @Test
  public void testGenerateMonthlyStatement() {
    Account account = new Account(1200.0f, 12.00f);
    account.setMonthlyCommission(10.00f);
    account.generateMonthlyStatement();

    assertEquals(1201.9f, account.getBalance(), 0.01f);
  }

  @Test
  public void testSetNumberOfEntries() {
    Account account = new Account(1000.0f, 5.0f);
    account.setNumberOfEntries(5);

    assertEquals(5, account.getNumberOfEntries());
  }

  @Test
  public void testSetAnnualRate() {
    Account account = new Account(1000.0f, 5.0f);
    account.setAnnualRate(10.0f);

    assertEquals(10.0f, account.getAnnualRate());
  }

  @Test
  public void testWithdrawValidAmount() {
    Account account = new Account(1000.0f, 5.0f);
    account.withdraw(500.0f);

    assertEquals(500.0f, account.getBalance());
    assertEquals(1, account.getNumberOfWithdrawals());
  }

  @Test
  public void testWithdrawInvalidAmount() {
    Account account = new Account(1000.0f, 5.0f);
    account.withdraw(1500.0f);

    assertEquals(1000.0f, account.getBalance());
    assertEquals(0, account.getNumberOfWithdrawals());
  }

  @Test
  public void testWithdrawNegativeAmount() {
    Account account = new Account(1000.0f, 5.0f);
    account.withdraw(-500.0f);

    assertEquals(1000.0f, account.getBalance());
    assertEquals(0, account.getNumberOfWithdrawals());
  }
}