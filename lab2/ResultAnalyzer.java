import java.util.Arrays;
import java.util.Scanner;

public class ResultsAnalyzer {

    public static int readIntegerInRange(
            Scanner scanner,
            String message,
            int minimum,
            int maximum
    ) {
        while (true) {
            System.out.print(message);

            if (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
                scanner.next();
                continue;
            }

            int value = scanner.nextInt();

            if (value < minimum || value > maximum) {
                System.out.println(
                        "Please enter a value from "
                                + minimum + " to " + maximum + "."
                );
            } else {
                return value;
            }
        }
    }

    public static void printGradeBands(int[] marks) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int fCount = 0;

        for (int mark : marks) {
            if (mark >= 85) {
                aCount++;
            } else if (mark >= 70) {
                bCount++;
            } else if (mark >= 50) {
                cCount++;
            } else {
                fCount++;
            }
        }

        System.out.println("\nGrade Bands");
        System.out.println("A | " + "*".repeat(aCount));
        System.out.println("B | " + "*".repeat(bCount));
        System.out.println("C | " + "*".repeat(cCount));
        System.out.println("F | " + "*".repeat(fCount));
    }

    public static void printTopThreePerformers(int[] marks) {
        Integer[] studentIndexes = new Integer[marks.length];

        for (int i = 0; i < marks.length; i++) {
            studentIndexes[i] = i;
        }

        Arrays.sort(studentIndexes, (first, second) -> {
            if (marks[second] != marks[first]) {
                return Integer.compare(marks[second], marks[first]);
            }

            return Integer.compare(first, second);
        });

        System.out.println("\nTop performers:");

        int numberOfPerformers = Math.min(3, marks.length);

        for (int i = 0; i < numberOfPerformers; i++) {
            int studentNumber = studentIndexes[i] + 1;
            int mark = marks[studentIndexes[i]];

            System.out.println(
                    "#" + studentNumber + " (" + mark + ")"
            );
        }
    }

    public static void analyzeResults(int[] marks) {
        int total = 0;
        int highest = marks[0];
        int lowest = marks[0];

        for (int mark : marks) {
            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        double mean = (double) total / marks.length;

        System.out.println("\n===== RESULTS ANALYZER =====");
        System.out.println("Students: " + marks.length);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.printf("Mean: %.2f%n", mean);
        System.out.println("Max: " + highest);
        System.out.println("Min: " + lowest);

        printGradeBands(marks);
        printTopThreePerformers(marks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = readIntegerInRange(
                scanner,
                "Enter the number of students: ",
                1,
                100
        );

        int[] marks = new int[numberOfStudents];

        for (int i = 0; i < marks.length; i++) {
            marks[i] = readIntegerInRange(
                    scanner,
                    "Enter mark for student " + (i + 1) + ": ",
                    0,
                    100
            );
        }

        analyzeResults(marks);

        scanner.close();
    }
}