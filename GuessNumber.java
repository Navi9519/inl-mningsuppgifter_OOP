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

    // Play game metod där spelaren gissar rätt nummer
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

                if (guessNumber == correctNumber) {

                    System.out.println(
                            "Rätt! Talet är " + correctNumber + " och du gissade rätt på " + counter + " försök");

                    restartGame();

                } else if (correctNumber > guessNumber) {
                    System.out.println("Talet är större än det gissade talet");
                } else if (correctNumber < guessNumber) {

                    System.out.println("Talet är mindre än det gissade talet");
                }

            } catch (InputMismatchException e) {
                // counter-- fel inmatning påverkar inte antalet gissningar
                counter--;
                System.out.println("Du kan bara svara med siffror. Försök igen: ");
                sc.next();
            }

        } while (runGame == true);

    }

    // Metod för att starta om spelet beroende på vad spelare väljer
    public void restartGame() {
        System.out.println("Vill du spela igen? (JA/NEJ)");

        String choice = sc.next();

        if (choice.equalsIgnoreCase("ja")) {
            // reseter counter(gissningar) om nytt spel väljs
            counter = 0;
            playGame();
        } else if (choice.equalsIgnoreCase("nej")) {
            System.out.println("Tack för den här gången!");

            runGame = false;
        } else {
            System.out.println("Du måste svara Ja eller Nej");
            restartGame();
        }

    }

}