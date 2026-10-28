import java.util.Random;

public class largestTwoRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        System.out.println("Five random numbers between 1 and 50:");

        for (int i = 1; i <= 5; i++) {
            int number = random.nextInt(50) + 1;

            System.out.println(number);

            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second largest: " + secondLargest);
    }
}