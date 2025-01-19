package com.factoriaf5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

  private SavingsAccount activeAccount;
  private SavingsAccount inactiveAccount;

  @BeforeEach
  void setUp() {
    activeAccount = new SavingsAccount(15000, 12.0f);
    inactiveAccount = new SavingsAccount(5000, 12.0f);
  }

  @Test
  void testDepositActiveAccount() {
    activeAccount.deposit(1000);
    assertEquals(16000, activeAccount.getBalance());
  }

  @Test
  void testDepositInactiveAccount() {
    inactiveAccount.deposit(1000);
    assertEquals(5000, inactiveAccount.getBalance());
  }

  @Test
  void testWithdrawActiveAccount() {
    activeAccount.withdraw(1000);
    assertEquals(14000, activeAccount.getBalance());
  }

  @Test
  void testWithdrawInactiveAccount() {
    inactiveAccount.withdraw(1000);
    assertEquals(5000, inactiveAccount.getBalance());
  }

  @Test
  void testGenerateMonthlyStatementWithFewWithdrawals() {
    activeAccount.withdraw(1000);
    activeAccount.withdraw(1000);
    activeAccount.generateMonthlyStatement();
    assertEquals(0, activeAccount.getMonthlyCommission());
  }

  @Test
  void testGenerateMonthlyStatementWithManyWithdrawals() {
    activeAccount.withdraw(1000);
    activeAccount.withdraw(1000);
    activeAccount.withdraw(1000);
    activeAccount.withdraw(1000);
    activeAccount.withdraw(1000);
    activeAccount.generateMonthlyStatement();
    assertEquals(1000, activeAccount.getMonthlyCommission());
  }

  @Test
  void testToString() {
    String expected = "SavingsAccount{balance=15000.0, totalTransactions=0, monthlyCommission=0.0}";
    assertEquals(expected, activeAccount.toString());
  }
}