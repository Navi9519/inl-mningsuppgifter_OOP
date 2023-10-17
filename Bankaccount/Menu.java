package Bankaccount;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    RegisterAccount register = new RegisterAccount();
    SavingsAccount menu2 = new SavingsAccount();
    boolean runMenu;
    int choice;

    public Menu() {
        runMenu = true;

        do {
            System.out.println("****HUVUDMENY****");
            System.out.println("1. Skapa ett konto");
            System.out.println("2. Administrera konto");
            System.out.println("3. Avsluta");
            System.out.print("Ange menyval>");
            choice = sc.nextInt();

            if (choice == 1) {

                register.addUser();
            }

            else if (choice == 2) {
                menu2.MenuAccount();
            } else if (choice == 3) {
                System.out.println("Du avslutade menyn");
                runMenu = false;
            }
        } while (runMenu);
    }

}
