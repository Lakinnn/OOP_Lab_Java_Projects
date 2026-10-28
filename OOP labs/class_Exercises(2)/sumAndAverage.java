import java.util.Scanner;

public class sumAndAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many integers will you enter? ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            input.close();
            return;
        }

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter integer " + i + ": ");
            sum += input.nextInt();
        }

        double average = (double) sum / n;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        input.close();
    }
}