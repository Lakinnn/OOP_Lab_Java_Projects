import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class removeEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("How many integers will you enter? ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers.add(input.nextInt());
        }

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            int number = iterator.next();

            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("List after removing even numbers: " + numbers);

        input.close();
    }
}