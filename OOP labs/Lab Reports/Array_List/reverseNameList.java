import java.util.ArrayList;
import java.util.Scanner;

public class reverseNameList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter names one by one.");
        System.out.println("Type 'end' to finish.");

        while (true) {
            System.out.print("Enter a name: ");
            String name = input.nextLine();

            if (name.equalsIgnoreCase("end")) {
                break;
            }

            names.add(name);
        }

        System.out.println("Number of names entered: " + names.size());
        System.out.println("Names in reverse order:");

        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }

        input.close();
    }
}