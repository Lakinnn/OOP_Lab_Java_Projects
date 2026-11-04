import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class CampusGradebookManager {

    private static final int NUMBER_OF_MARKS = 3;
    private static final int MIN_MARK = 0;
    private static final int MAX_MARK = 100;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static final ArrayList<String> names = new ArrayList<>();
    private static final ArrayList<int[]> marks = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInt("Choice: ", 1, 7);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    updateMark();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    generateDemoData();
                    break;
                case 7:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n===== GRADEBOOK =====");
        System.out.println("1) Add student");
        System.out.println("2) Show report");
        System.out.println("3) Search by name");
        System.out.println("4) Update a mark");
        System.out.println("5) Remove student");
        System.out.println("6) Demo data");
        System.out.println("7) Exit");
    }

    public static void addStudent() {
        System.out.println("\n--- Add Student ---");

        String name;

        while (true) {
            name = readText("Student name: ");

            if (findStudentByExactName(name) != -1) {
                System.out.println("A student with that name already exists.");
            } else {
                break;
            }
        }

        int[] studentMarks = new int[NUMBER_OF_MARKS];

        for (int i = 0; i < NUMBER_OF_MARKS; i++) {
            studentMarks[i] = readInt(
                    "Mark " + (i + 1) + " (0-100): ",
                    MIN_MARK,
                    MAX_MARK
            );
        }

        names.add(name);
        marks.add(studentMarks);

        System.out.println("Student added successfully.");
    }

    public static void showReport() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added.");
            return;
        }

        System.out.println("\n================ GRADEBOOK REPORT ================");

        System.out.printf(
                "%-4s %-20s %8s %8s %8s %10s%n",
                "No.",
                "Name",
                "Mark 1",
                "Mark 2",
                "Mark 3",
                "Average"
        );

        System.out.println(
                "--------------------------------------------------------------"
        );

        ArrayList<Integer> ranking = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            ranking.add(i);

            int[] studentMarks = marks.get(i);
            double average = calculateAverage(studentMarks);

            System.out.printf(
                    "%-4d %-20s %8d %8d %8d %10.2f%n",
                    i + 1,
                    names.get(i),
                    studentMarks[0],
                    studentMarks[1],
                    studentMarks[2],
                    average
            );
        }

        System.out.println("\nClass average per assessment:");

        for (int assessment = 0; assessment < NUMBER_OF_MARKS; assessment++) {
            double average = calculateAssessmentAverage(assessment);
            System.out.printf(
                    "Assessment %d: %.2f%n",
                    assessment + 1,
                    average
            );
        }

        ranking.sort((first, second) -> {
            double firstAverage = calculateAverage(marks.get(first));
            double secondAverage = calculateAverage(marks.get(second));

            return Double.compare(secondAverage, firstAverage);
        });

        System.out.println("\nRanking from best to worst:");

        for (int position = 0; position < ranking.size(); position++) {
            int studentIndex = ranking.get(position);

            System.out.printf(
                    "%d. %s - %.2f%n",
                    position + 1,
                    names.get(studentIndex),
                    calculateAverage(marks.get(studentIndex))
            );
        }
    }

    public static void searchByName() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added.");
            return;
        }

        String searchText = readText("Enter part of the name: ")
                .toLowerCase();

        boolean found = false;

        System.out.println("\nSearch results:");

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).toLowerCase().contains(searchText)) {
                found = true;

                System.out.printf(
                        "%d. %s - Average: %.2f%n",
                        i + 1,
                        names.get(i),
                        calculateAverage(marks.get(i))
                );
            }
        }

        if (!found) {
            System.out.println("No matching students found.");
        }
    }

    public static void updateMark() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added.");
            return;
        }

        int studentIndex = chooseStudent("update");

        if (studentIndex == -1) {
            return;
        }

        System.out.println(
                "Updating marks for " + names.get(studentIndex)
        );

        int assessment = readInt(
                "Assessment number (1-3): ",
                1,
                NUMBER_OF_MARKS
        );

        int newMark = readInt(
                "New mark (0-100): ",
                MIN_MARK,
                MAX_MARK
        );

        marks.get(studentIndex)[assessment - 1] = newMark;

        System.out.println("Mark updated successfully.");
    }

    public static void removeStudent() {
        if (names.isEmpty()) {
            System.out.println("\nNo students have been added.");
            return;
        }

        int studentIndex = chooseStudent("remove");

        if (studentIndex == -1) {
            return;
        }

        String removedName = names.remove(studentIndex);
        marks.remove(studentIndex);

        System.out.println(
                removedName + " was removed successfully."
        );
    }

    public static int chooseStudent(String action) {
        String searchText = readText(
                "Enter part of the student's name to " + action + ": "
        ).toLowerCase();

        ArrayList<Integer> matches = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).toLowerCase().contains(searchText)) {
                matches.add(i);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No matching students found.");
            return -1;
        }

        System.out.println("\nMatching students:");

        for (int i = 0; i < matches.size(); i++) {
            int studentIndex = matches.get(i);

            System.out.println(
                    (i + 1) + ". " + names.get(studentIndex)
            );
        }

        int selectedMatch = readInt(
                "Select a student: ",
                1,
                matches.size()
        );

        return matches.get(selectedMatch - 1);
    }

    public static void generateDemoData() {
        String[] demoNames = {
                "Abel",
                "Betty",
                "Chala",
                "Dawit",
                "Eden",
                "Fikru",
                "Hana",
                "Liya",
                "Mekdes",
                "Samuel"
        };

        names.clear();
        marks.clear();

        for (String demoName : demoNames) {
            int[] studentMarks = new int[NUMBER_OF_MARKS];

            for (int i = 0; i < NUMBER_OF_MARKS; i++) {
                studentMarks[i] = random.nextInt(101);
            }

            names.add(demoName);
            marks.add(studentMarks);
        }

        System.out.println("Ten demo students generated.");
    }

    public static double calculateAverage(int[] studentMarks) {
        int total = 0;

        for (int mark : studentMarks) {
            total += mark;
        }

        return (double) total / studentMarks.length;
    }

    public static double calculateAssessmentAverage(int assessmentIndex) {
        int total = 0;

        for (int[] studentMarks : marks) {
            total += studentMarks[assessmentIndex];
        }

        return (double) total / marks.size();
    }

    public static int findStudentByExactName(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name.trim())) {
                return i;
            }
        }

        return -1;
    }

    public static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static int readInt(String message, int minimum, int maximum) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= minimum && value <= maximum) {
                    return value;
                }

                System.out.println(
                        "Enter a number from "
                                + minimum + " to " + maximum + "."
                );

            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}