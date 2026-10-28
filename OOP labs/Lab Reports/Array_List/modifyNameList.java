import java.util.ArrayList;
import java.util.Scanner;

public class modifyNameList {
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

        System.out.println("Original list: " + names);

        System.out.print("Enter a name to add at the front: ");
        String firstName = input.nextLine();
        names.add(0, firstName);

        System.out.print("Enter a name to add at the end: ");
        String lastName = input.nextLine();
        names.add(lastName);

        if (names.size() >= 3) {
            int middleIndex = names.size() / 2;
            String removedName = names.remove(middleIndex);
            System.out.println("Removed middle name: " + removedName);
        } else {
            System.out.println("Not enough names to remove a middle element.");
        }

        System.out.println("Final list: " + names);

        input.close();
    }
}