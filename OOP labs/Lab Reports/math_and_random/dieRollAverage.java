import java.util.Random;

public class dieRollAverage {
    public static void main(String[] args) {
        Random random = new Random();

        int total = 0;

        for (int i = 1; i <= 1000; i++) {
            int roll = random.nextInt(6) + 1;
            total += roll;
        }

        double average = (double) total / 1000;

        System.out.println("Number of rolls: 1000");
        System.out.println("Total of all rolls: " + total);
        System.out.println("Average: " + average);
        System.out.println("Expected average: 3.5");
        System.out.println("Difference from 3.5: " + Math.abs(average - 3.5));
    }
}