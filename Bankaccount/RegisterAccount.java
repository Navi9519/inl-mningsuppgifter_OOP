package Bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterAccount {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> listOfUsers = new ArrayList<>();
    boolean createUser;
    boolean accountExists;
    int number;
    int inputNumber;

    public RegisterAccount() {

    }

    public void addUser() {
        createUser = true;

        do {
            System.out.print("Ange kontonummer>");
            inputNumber = sc.nextInt();

            accountExists = false; // Kollar om accountnummer existerar

            for (User u : listOfUsers) {
                if (u.accountNumber == inputNumber) {
                    accountExists = true;
                    break; // Kontonumret finns redan, behöver inte fortsätta kolla
                }
            }

            if (accountExists) {
                System.out.println("Account already exists");
                createUser = false;
            } else {
                listOfUsers.add(new User(inputNumber));
                System.out.println("Account added successfully.");
                createUser = false;
            }

            // System.out.print("Vill du lägga till ett annat konto? (ja/nej): ");
            // String answer = sc.next();

            // if (!answer.equalsIgnoreCase("ja")) {
            // createUser = false;
            // }

            // Printar alla användare för att se att de skapas
            for (User u : listOfUsers) {
                System.out.println(u.toString());
            }

        } while (createUser);

    }

}
