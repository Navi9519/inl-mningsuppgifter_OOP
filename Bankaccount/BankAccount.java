package Bankaccount;

import java.util.Scanner;

public class BankAccount {
    Scanner sc = new Scanner(System.in);
    private double balance;
    private int accountNumber;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void depositMoney(double amount) {
        setBalance(getBalance() + amount);
        System.out.println(" Överförningen lyckades, du överförde " + amount + " kr");

    }

    public void withDrawMoney(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Uttag av " + amount + " kr lyckades! Nuvarande saldo är: " + getBalance());
        } else {
            System.out.println("Otillräckliga medel. Uttag misslyckades ");
        }

    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

    public String balanceToString() {

        return "Ditt saldo är " + getBalance() + " kr";

    }

    public String toString() {
        return "Kontonummer: " + this.accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

}
