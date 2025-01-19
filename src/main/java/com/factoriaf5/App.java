package com.factoriaf5;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        Account account = new Account(15000, 5);
        SavingsAccount savingsAccount = new SavingsAccount(20000, 4);
        CurrentAccount currentAccount = new CurrentAccount(10000, 3);

        // Perform operations
        account.deposit(5000);
        account.withdraw(3000);
        account.generateMonthlyStatement();
        System.out.println(account);

        savingsAccount.deposit(2000);
        savingsAccount.withdraw(15000);
        savingsAccount.generateMonthlyStatement();
        System.out.println(savingsAccount);

        currentAccount.deposit(5000);
        currentAccount.withdraw(18000);
        currentAccount.generateMonthlyStatement();
        System.out.println(currentAccount);
    }
    
}
