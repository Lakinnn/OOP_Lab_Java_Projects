
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Library library = new Library();

        library.addBook(
            new Book(1, "Java Programming", "James")
        );

        library.addBook(
            new Book(2, "Clean Code", "Robert")
        );

        library.addMember(
            new Member(1, "Hana")
        );

        library.addMember(
            new Member(2, "Sara")
        );

        int choice;

        do {
            System.out.println("\n=== LIBRARY ===");
            System.out.println("1) Add book");
            System.out.println("2) Add member");
            System.out.println("3) Borrow");
            System.out.println("4) Return");
            System.out.println("5) Search");
            System.out.println("6) Show books");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    int bookId = input.nextInt();
                    input.nextLine();

                    System.out.print("Title: ");
                    String title = input.nextLine();

                    System.out.print("Author: ");
                    String author = input.nextLine();

                    boolean added = library.addBook(
                        new Book(bookId, title, author)
                    );

                    System.out.println(
                        added ? "Book added." : "Cannot add book."
                    );
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    int memberId = input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    boolean memberAdded = library.addMember(
                        new Member(memberId, name)
                    );

                    System.out.println(
                        memberAdded ? "Member added." : "Cannot add member."
                    );
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    int borrowMember = input.nextInt();

                    System.out.print("Book ID: ");
                    int borrowBook = input.nextInt();

                    System.out.println(
                        library.borrow(borrowMember, borrowBook)
                        ? "Book borrowed successfully."
                        : "Borrow denied."
                    );
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    int returnMember = input.nextInt();

                    System.out.print("Book ID: ");
                    int returnBook = input.nextInt();

                    System.out.println(
                        library.giveBack(returnMember, returnBook)
                        ? "Book returned."
                        : "Return denied."
                    );
                    break;

                case 5:
                    System.out.print("Enter title: ");
                    String searchTitle = input.nextLine();

                    library.search(searchTitle);
                    break;

                case 6:
                    library.showBooks();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        input.close();
    }
}
