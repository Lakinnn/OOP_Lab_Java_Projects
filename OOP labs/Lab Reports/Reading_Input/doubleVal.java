import java.util.Scanner;

public class doubleVal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter A: ");
        double a = input.nextDouble();

        System.out.println("Enter B: ");
        double b = input.nextDouble();

        System.out.println("Product: " + (a * b));
        System.out.println("Quotient: " + (a / b));

        input.close();
    }
}