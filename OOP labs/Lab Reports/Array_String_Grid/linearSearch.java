import java.util.Scanner;

public class linearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[6];

        System.out.println("Enter 6 integers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.print("Enter the target value: ");
        int target = input.nextInt();

        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println("Index: " + index);

        input.close();
    }
}