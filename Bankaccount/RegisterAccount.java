package Bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterAccount {
    Scanner sc = new Scanner(System.in);
    ArrayList<BankAccount> listOfUsers = new ArrayList<>();
    private boolean createUser;
    private boolean accountExists;
    private boolean run2Menu;
    private int choice;
    private int checkAccount;
    private int inputNumber;
    private double amount;

    public RegisterAccount() {

    }

    public void addUser() {
        createUser = true;

        do {
            System.out.print("Ange kontonummer>");
            inputNumber = sc.nextInt();

            accountExists = false; // Kollar om accountnummer existerar

            for (BankAccount u : listOfUsers) {
                if (u.getAccountNumber() == inputNumber) {
                    accountExists = true;
                    break; // Kontonumret finns redan, behöver inte fortsätta kolla
                }
            }

            if (accountExists) {
                System.out.println("Kontot existerar redan");
                createUser = false;
            } else {
                listOfUsers.add(new BankAccount(inputNumber, 0));
                System.out.println("Du har skapat kontot!");
                createUser = false;
            }

            // System.out.print("Vill du lägga till ett annat konto? (ja/nej): ");
            // String answer = sc.next();

            // if (!answer.equalsIgnoreCase("ja")) {
            // createUser = false;
            // }

            // Printar alla användare för att se att de skapas
            for (BankAccount u : listOfUsers) {
                System.out.println(u.toString());
            }

        } while (createUser);

    }

    // Meny för administera konto

    public void menuAccount() {
        run2Menu = true;
        System.out.print("Ange kontonummer> ");
        checkAccount = sc.nextInt();
        accountExists = false;

        for (BankAccount user : listOfUsers) {

            if (checkAccount == user.getAccountNumber()) {

                System.out.println("Kontonummer: " + user.getAccountNumber() + " -> inloggad");
                accountExists = true;

                do {
                    System.out.println("****KONTOMENY**** - Konto: " + user.getAccountNumber());
                    System.out.println("1. Ta ut pengar ");
                    System.out.println("2. Sätt in pengar ");
                    System.out.println("3. Visa Saldo ");
                    System.out.println("4. Avsluta ");
                    System.out.print("Ange menyval>");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.print("Hur mycket vill du ta ut> ");
                        amount = sc.nextDouble();
                        user.withDrawMoney(amount);

                    } else if (choice == 2) {
                        System.out.print("Hur mycket vill du sätta in> ");
                        amount = sc.nextDouble();
                        user.depositMoney(amount);
                    } else if (choice == 3) {
                        System.out.println(user.balanceToString());
                    } else if (choice == 4) {
                        run2Menu = false;

                    }

                } while (run2Menu);
            }
        }

        if (!accountExists) {
            System.out.println("Kontot existerar inte");
        }

    }

}
