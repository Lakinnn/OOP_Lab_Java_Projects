import java.util.Scanner;

public class gradeBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("The number of students must be positive.");
            input.close();
            return;
        }

        double[] scores = new double[n];
        double sum = 0;
        double highest = Double.NEGATIVE_INFINITY;
        double lowest = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            scores[i] = input.nextDouble();

            sum += scores[i];

            if (scores[i] > highest) {
                highest = scores[i];
            }

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        double average = sum / n;

        System.out.println("\nAverage score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);

        System.out.println("\nIndividual grades:");

        for (int i = 0; i < n; i++) {
            char grade;

            if (scores[i] >= 90) {
                grade = 'A';
            } else if (scores[i] >= 80) {
                grade = 'B';
            } else if (scores[i] >= 70) {
                grade = 'C';
            } else if (scores[i] >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println(
                "Student " + (i + 1)
                + ": Score = " + scores[i]
                + ", Grade = " + grade
            );
        }

        input.close();
    }
}