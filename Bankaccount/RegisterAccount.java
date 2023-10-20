package Bankaccount;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String StringInputNumber;

    public RegisterAccount() {

    }

    public void addUser() {
        createUser = true;

        do {
            System.out.print("Ange kontonummer>");
            StringInputNumber = sc.next();

            // Metod för att specificera att kontonummer måste vara 4 siffror
            Matcher m = Pattern.compile("\\d{4}").matcher(StringInputNumber);
            if (m.matches()) {

                checkRegisterUser();

            } else {
                System.out.println("Kontonummer måste innehålla exakt 4-siffror");
            }

            accountExists = false; // Kollar om accountnummer existerar

        } while (createUser);

    }

    // Metod för att checka om kontonummer existerar + lägga till konto
    public void checkRegisterUser() {
        inputNumber = Integer.parseInt(StringInputNumber);
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

        for (BankAccount u : listOfUsers) {
            System.out.println(u.toString());
        }
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
