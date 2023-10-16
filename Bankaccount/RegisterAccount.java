package Bankaccount;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterAccount {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> listOfUsers;
    boolean createUser;

    public RegisterAccount() {

        addUser();

    }

    public void addUser() {

        System.out.print("Ange kontonummer>");
        int inputNumber = sc.nextInt();

        listOfUsers = new ArrayList<>();
        listOfUsers.add("String", inputNumber, "string", "string");

        do {

        } while (createUser);

    }
}
