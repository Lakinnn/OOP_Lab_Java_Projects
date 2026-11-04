import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DiceCasino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int balance = 100;
        int rounds = 0;
        int wins = 0;
        int streak = 0;
        int peakBalance = balance;

        ArrayList<Integer> history = new ArrayList<>();

        System.out.println("Welcome to Dice Casino!");

        while (balance > 0) {
            System.out.println("\nBalance: " + balance);
            System.out.print("Enter bet (0 to cash out): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                scanner.next();
                continue;
            }

            int bet = scanner.nextInt();

            if (bet == 0) {
                break;
            }

            if (bet < 0 || bet > balance) {
                System.out.println("Bet must be between 1 and your balance.");
                continue;
            }

            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;
            boolean isDouble = die1 == die2;
            boolean isWin = sum == 7 || sum == 11;

            rounds++;

            if (isWin) {
                streak++;
                wins++;

                // Every third consecutive win pays triple the bet.
                int payout = streak % 3 == 0 ? bet * 3 : bet;
                balance += payout;

                System.out.println(
                    "Dice " + die1 + "+" + die2 + "=" + sum
                    + (streak % 3 == 0 ? " STREAK BONUS" : " WIN")
                    + " -> " + balance
                );
            } else {
                streak = 0;

                // Doubles cost twice the bet; other losses cost the bet.
                int loss = isDouble ? bet * 2 : bet;
                balance = Math.max(0, balance - loss);

                System.out.println(
                    "Dice " + die1 + "+" + die2 + "=" + sum
                    + (isDouble ? " DOUBLE" : " LOSE")
                    + " -> " + balance
                );
            }

            history.add(balance);
            peakBalance = Math.max(peakBalance, balance);
        }

        System.out.println("\nRounds: " + rounds);
        System.out.println("Wins: " + wins);
        System.out.println("Peak balance: " + peakBalance);

        System.out.println("\nBalance history:");
        for (int i = 0; i < history.size(); i++) {
            int roundBalance = history.get(i);
            int numberOfHashes = roundBalance / 10;

            System.out.print("R" + (i + 1) + " ");

            for (int j = 0; j < numberOfHashes; j++) {
                System.out.print("#");
            }

            System.out.println(" " + roundBalance);
        }

        scanner.close();
    }
}
