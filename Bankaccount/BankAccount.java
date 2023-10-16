package Bankaccount;

public abstract class BankAccount {
    String accountHolder;
    int accountNumber;

    public BankAccount(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;

    }

}
