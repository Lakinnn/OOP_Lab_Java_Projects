import java.util.Random;
import java.util.Scanner;

public class guessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(10) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 10.");

        do {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;

            if (guess < secret) {
                System.out.println("Too low!");
            } else if (guess > secret) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct!");
                System.out.println("Attempts: " + attempts);
            }
        } while (guess != secret);

        input.close();
    }
}