import java.util.Random;

public class randomNumbersSmallest {
    public static void main(String[] args) {
        Random random = new Random();

        int smallest = Integer.MAX_VALUE;

        System.out.println("Five random numbers between 30 and 80:");

        for (int i = 1; i <= 5; i++) {
            int number = random.nextInt(51) + 30;

            System.out.println(number);

            if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Smallest number: " + smallest);
    }
}