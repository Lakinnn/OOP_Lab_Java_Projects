import java.util.Scanner;

public class Smallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 5 integers:");

        int smallest = input.nextInt();

        for (int i = 2; i <= 5; i++) {
            int number = input.nextInt();

            if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Smallest = " + smallest);

        input.close();
    }
}