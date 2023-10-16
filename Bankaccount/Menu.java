package Bankaccount;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    SavingsAccount menu;
    boolean runMenu;

    public Menu() {
        runMenu = true;

        do {
            System.out.println("****HUVUDMENY****");
            System.out.println("1. Skapa ett konto");
            System.out.println("2. Aministera konto");
            System.out.println("3. Avsluta");
            System.out.print("Ange menyval>");
            int choice = sc.nextInt();

            if (choice == 1) {
                RegisterAccount register = new RegisterAccount();
                register.addUser();
            }

            else if (choice == 2) {
                menu.MenuAccount();
            } else if (choice == 3) {
                System.out.println("Du avslutade menyn");
                runMenu = false;
            }
        } while (runMenu);
    }

}
