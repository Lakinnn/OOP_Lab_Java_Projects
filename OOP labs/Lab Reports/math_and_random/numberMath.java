import java.util.Scanner;

public class numberMath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double number = input.nextDouble();

        System.out.println("Square root: " + Math.sqrt(number));
        System.out.println("Cube: " + Math.pow(number, 3));
        System.out.println("Rounded value: " + Math.round(number));

        input.close();
    }
}