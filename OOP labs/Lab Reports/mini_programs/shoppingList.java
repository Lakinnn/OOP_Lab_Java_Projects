import java.util.ArrayList;
import java.util.Scanner;

public class shoppingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== SHOPPING LIST =====");
            System.out.println("1. Add item");
            System.out.println("2. Remove item by name");
            System.out.println("3. Display shopping list");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String newItem = input.nextLine();

                    items.add(newItem);
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the item to remove: ");
                    String itemToRemove = input.nextLine();

                    if (items.remove(itemToRemove)) {
                        System.out.println("Item removed successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.println("Shopping List:");

                    if (items.isEmpty()) {
                        System.out.println("Your shopping list is empty.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + ". " + items.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting shopping list.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        input.close();
    }
}