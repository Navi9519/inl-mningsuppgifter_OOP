package Bankaccount;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

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
        System.out.println("The deposit was succesful, you transferred " + amount + " kr");

    }

    public void withDrawMoney(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Wihdrawal of " + amount + " succesful. Current balance is " + getBalance());
        } else {
            System.out.println("Insufficent funds. withdrawal failed");
        }

    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

    public String balanceToString() {

        return "Your balance is " + getBalance() + " kr";

    }

    public String toString() {
        return "Accountnumber: " + this.accountNumber;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

}
