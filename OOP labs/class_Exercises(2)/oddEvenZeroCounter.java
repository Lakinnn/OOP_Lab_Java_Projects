import java.util.Scanner;

public class oddEvenZeroCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int odd = 0;
        int even = 0;
        int zero = 0;

        System.out.println("Enter 5 integers:");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter integer " + i + ": ");
            int number = input.nextInt();

            if (number == 0) {
                zero++;
            } else if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Odd numbers: " + odd);
        System.out.println("Even numbers: " + even);
        System.out.println("Zeros: " + zero);

        input.close();
    }
}