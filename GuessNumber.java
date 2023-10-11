import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    protected int correctNumber;
    protected int guessNumber;
    // ArrayList<Integer> guessedNumbers = new ArrayList<>();
    protected int counter;
    protected boolean runGame;

    public GuessNumber() {
        playGame();
    }

    public void playGame() {
        correctNumber = ran.nextInt(100) + 1;
        runGame = true;
        System.out.println(correctNumber);
        System.out.println("Gissa ett tal mellan 1 och 100 ");

        numberGuess();

    }

    public void numberGuess() {

        do {

            counter++;

            System.out.print("Gissning " + counter + ": ");
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
                System.out.println("Du kan bara svara med siffror. Försök igen: ");
                sc.next();
            }

        } while (runGame == true);

    }

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