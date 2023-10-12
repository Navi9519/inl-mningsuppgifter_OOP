import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    // Instansvariabler
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    protected int correctNumber;
    protected int guessNumber;
    protected int counter;
    protected boolean runGame;

    // Constructor som kör programmet när objekt skapas i main
    public GuessNumber() {
        playGame();
    }

    // Play game metod som använder nödvändiga variabler samt startar spelet genom
    // att kalla på metoder som kör logigen i spelet.
    public void playGame() {
        correctNumber = ran.nextInt(100) + 1;
        runGame = true;
        System.out.println(correctNumber);
        System.out.println("Gissa ett tal mellan 1 och 100 ");

        numberGuess();

    }

    // Metod för att gissa nummber

    public void numberGuess() {

        do {

            counter++;
            // Gissning startar på counter + 1, counter + 2 osv osv för ......
            System.out.print("Gissning " + counter + ": ");
            // Try/catch metod för att specificera att input måste vara int
            try {
                guessNumber = sc.nextInt();

                // If/else statements som ger olika utslag beroende på om man gissat rätt/för
                // högt/för lågt/fel input
                if (guessNumber == correctNumber) {

                    System.out.println(
                            "Rätt! Talet är " + correctNumber + " och du gissade rätt på " + counter + " försök");
                    // Om man gissat rätt kallas metoden för att ge spelaren möjlighet att starta om
                    // spelet.
                    restartGame();

                } else if (correctNumber > guessNumber) {
                    System.out.println("Talet är större än det gissade talet");
                } else if (correctNumber < guessNumber) {

                    System.out.println("Talet är mindre än det gissade talet");
                }

            } catch (InputMismatchException e) {
                System.out.println("Du kan bara svara med siffror. Försök igen: ");
                sc.next();
            }

        } while (runGame == true);

    }

    // Metod för att starta om spelet om spelaren väljer ja som input, avslutar
    // speler om nej ges som input, samt startar om frågan om spelaren varken svarat
    // ja eller nej
    public void restartGame() {
        System.out.println("Vill du spela igen? (JA/NEJ)");

        String choice = sc.next();

        if (choice.equalsIgnoreCase("ja")) {
            counter = 0;
            playGame();
        } else if (choice.equalsIgnoreCase("nej")) {
            System.out.println("Tack för den här gången!");

            runGame = false;
        } else if (!choice.equalsIgnoreCase("ja") || choice.equalsIgnoreCase("nej")) {
            System.out.println("Du måste svara Ja eller nej");
            restartGame();
        }

    }

}