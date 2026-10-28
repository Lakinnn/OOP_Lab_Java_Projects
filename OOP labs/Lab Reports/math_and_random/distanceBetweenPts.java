import java.util.Scanner;

public class distanceBetweenPts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Distance Between Points");
        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        double distance = Math.sqrt(
            Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );

        System.out.println("Distance between points: " + distance);

        input.close();
    }
}