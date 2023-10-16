package Bankaccount;

public class SavingsAccount extends BankAccount {
    double balance;

    public SavingsAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber);
        this.balance = balance;

    }

    // Meny för administera konto
    public void MenuAccount() {

    }

    public void displayBalance() {

    }

    public void withDrawMoney() {

    }

    public void depositMoney() {

    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

}
