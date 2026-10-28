import java.util.Scanner;

public class countAboveFifty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many integers will you enter? ");
        int n = input.nextInt();

        int count = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter integer " + i + ": ");
            int number = input.nextInt();

            if (number > 50) {
                count++;
            }
        }

        System.out.println("Numbers greater than 50: " + count);

        input.close();
    }
}