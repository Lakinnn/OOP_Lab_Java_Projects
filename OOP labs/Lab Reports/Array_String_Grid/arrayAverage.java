import java.util.Scanner;

public class arrayAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[8];
        int sum = 0;

        System.out.println("Enter 8 integers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;
        int aboveAverage = 0;

        for (int number : numbers) {
            if (number > average) {
                aboveAverage++;
            }
        }

        System.out.println("Average: " + average);
        System.out.println("Elements above average: " + aboveAverage);

        input.close();
    }
}