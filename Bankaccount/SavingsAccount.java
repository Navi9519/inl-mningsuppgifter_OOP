package Bankaccount;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class SavingsAccount {
    Scanner sc = new Scanner(System.in);
    String accountHolder;
    int accountNumber;
    int choice;
    double balance;
    double amount;
    boolean runMenu;

    public SavingsAccount() {

    }

    // Meny för administera konto
    public void MenuAccount() {
        runMenu = true;

        do {
            System.out.println("****KONTOMENY****");
            System.out.println("1. Ta ut pengar ");
            System.out.println("2. Sätt in pengar ");
            System.out.println("3. Visa Saldo ");
            System.out.println("4. Avsluta ");
            System.out.print("Ange menyval>");
            choice = sc.nextInt();

            if (choice == 1) {
                // withDrawMoney();
            } else if (choice == 2) {
                depositMoney();
            } else if (choice == 3) {
                displayBalance();
            } else if (choice == 4) {
                runMenu = false;

            }

        } while (runMenu);

    }

    public void displayBalance() {

        getBalance();

    }

    public void withDrawMoney(double amount) {

    }

    public void depositMoney() {
        System.out.print("Hur mycket vill du sätta in?");
        amount = sc.nextDouble();

        balance += amount;

    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;

    }

}
