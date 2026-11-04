import java.util.Scanner;

public class CinemaSeatBooking {
    static final int ROWS = 5;
    static final int SEATS_PER_ROW = 8;

    static char[][] hall = new char[ROWS][SEATS_PER_ROW];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeHall();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    printHall();
                    break;
                case 2:
                    bookSingleSeat();
                    break;
                case 3:
                    bookGroup();
                    break;
                case 4:
                    printOccupancy();
                    break;
                case 5:
                    running = false;
                    printHall();
                    printOccupancy();
                    System.out.println("Thank you. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    static void initializeHall() {
        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                hall[row][seat] = 'O';
            }
        }
    }

    static void printMenu() {
        System.out.println("\n===== CINEMA SEAT BOOKING =====");
        System.out.println("1. Show seat map");
        System.out.println("2. Book one seat");
        System.out.println("3. Book a group");
        System.out.println("4. Show occupancy");
        System.out.println("5. Exit");
    }

    static void printHall() {
        System.out.println("\n    1 2 3 4 5 6 7 8");

        for (int row = 0; row < ROWS; row++) {
            System.out.print((char) ('A' + row) + "   ");

            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                System.out.print(hall[row][seat] + " ");
            }

            System.out.println();
        }

        System.out.println("O = Available, X = Taken");
    }

    static void bookSingleSeat() {
        String rowInput = readText("Enter row letter (A-E): ");
        int row = getRowIndex(rowInput);

        if (row == -1) {
            System.out.println("Invalid row.");
            return;
        }

        int seat = readInt("Enter seat number (1-8): ") - 1;

        if (seat < 0 || seat >= SEATS_PER_ROW) {
            System.out.println("Invalid seat number.");
            return;
        }

        if (hall[row][seat] == 'X') {
            System.out.println("That seat is already taken.");
            return;
        }

        hall[row][seat] = 'X';

        double price = getSeatPrice(row);
        System.out.printf(
                "Seat %c%d booked. Total: %.2f Birr%n",
                'A' + row,
                seat + 1,
                price
        );
    }

    static void bookGroup() {
        int groupSize = readInt("Enter group size: ");

        if (groupSize <= 0 || groupSize > SEATS_PER_ROW) {
            System.out.println(
                    "Group size must be between 1 and " + SEATS_PER_ROW + "."
            );
            return;
        }

        for (int row = 0; row < ROWS; row++) {
            int startingSeat = findAvailableBlock(row, groupSize);

            if (startingSeat != -1) {
                double total = 0;

                for (int seat = startingSeat;
                     seat < startingSeat + groupSize;
                     seat++) {

                    hall[row][seat] = 'X';
                    total += getSeatPrice(row);
                }

                System.out.printf(
                        "Group booked in row %c, seats %d-%d.%n",
                        'A' + row,
                        startingSeat + 1,
                        startingSeat + groupSize
                );

                System.out.printf(
                        "Total booking cost: %.2f Birr%n",
                        total
                );

                return;
            }
        }

        System.out.println(
                "No row contains enough free seats together."
        );
    }

    static int findAvailableBlock(int row, int groupSize) {
        for (int startingSeat = 0;
             startingSeat <= SEATS_PER_ROW - groupSize;
             startingSeat++) {

            boolean blockIsAvailable = true;

            for (int seat = startingSeat;
                 seat < startingSeat + groupSize;
                 seat++) {

                if (hall[row][seat] == 'X') {
                    blockIsAvailable = false;
                    break;
                }
            }

            if (blockIsAvailable) {
                return startingSeat;
            }
        }

        return -1;
    }

    static double getSeatPrice(int row) {
        // Front row A costs more than the rows behind it.
        return 20.00 - (row * 2.00);
    }

    static void printOccupancy() {
        int takenSeats = 0;
        int totalSeats = ROWS * SEATS_PER_ROW;

        for (int row = 0; row < ROWS; row++) {
            for (int seat = 0; seat < SEATS_PER_ROW; seat++) {
                if (hall[row][seat] == 'X') {
                    takenSeats++;
                }
            }
        }

        double occupancy = (double) takenSeats / totalSeats * 100;

        System.out.printf(
                "Occupancy: %.1f%%%n",
                occupancy
        );
    }

    static int getRowIndex(String rowInput) {
        if (rowInput.length() != 1) {
            return -1;
        }

        char row = Character.toUpperCase(rowInput.charAt(0));

        if (row < 'A' || row > 'E') {
            return -1;
        }

        return row - 'A';
    }

    static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}