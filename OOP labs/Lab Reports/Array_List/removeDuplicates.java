import java.util.ArrayList;
import java.util.Scanner;

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("How many names will you enter? ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(input.nextLine());
        }

        ArrayList<String> uniqueNames = new ArrayList<>();

        for (String name : names) {
            if (!uniqueNames.contains(name)) {
                uniqueNames.add(name);
            }
        }

        System.out.println("Original list: " + names);
        System.out.println("List without duplicates: " + uniqueNames);

        input.close();
    }
}