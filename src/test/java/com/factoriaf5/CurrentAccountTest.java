package com.factoriaf5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

  private CurrentAccount account;

  @BeforeEach
  void setUp() {
    account = new CurrentAccount(1000, 12.0f);
  }

  @Test
  public void testWithdrawWithinBalance() {
    account.withdraw(500);
    assertEquals(500, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testWithdrawExceedingBalance() {
    account.withdraw(1500);
    assertEquals(0, account.getBalance());
    assertEquals(500, account.getOverdraft());
  }

  @Test
  public void testDepositToCoverOverdraft() {
    account.withdraw(1500);
    account.deposit(600);
    assertEquals(100, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testDepositWithoutOverdraft() {
    account.deposit(500);
    assertEquals(1500, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testInvalidWithdrawal() {
    account.withdraw(-500);
    assertEquals(1000, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testInvalidDeposit() {
    account.deposit(-500);
    assertEquals(1000, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testToString() {
    String expected = "CurrentAccount{balance=1000.0, totalTransactions=0, monthlyCommission=0.0, overdraft=0.0}";
    assertEquals(expected, account.toString());
  }


  @Test
  public void testDepositCoveringPartialOverdraft() {
    account.withdraw(1500);
    account.deposit(300);
    assertEquals(0, account.getBalance());
    assertEquals(200, account.getOverdraft());
  }

  @Test
  public void testDepositCoveringFullOverdraft() {
    account.withdraw(1500);
    account.deposit(600);
    assertEquals(100, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

  @Test
  public void testDepositWith0Overdraft() {
    account.withdraw(1000);
    account.deposit(1600);
    assertEquals(1600, account.getBalance());
    assertEquals(0, account.getOverdraft());
  }

}