import java.util.ArrayList;
import java.util.Scanner;

public class arrayListSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter 5 integers:");

        for (int i = 0; i < 5; i++) {
            numbers.add(input.nextInt());
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);

        input.close();
    }
}