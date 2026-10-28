import java.util.ArrayList;
import java.util.Scanner;

public class primeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> primes = new ArrayList<>();

        System.out.print("Enter the upper limit N: ");
        int n = input.nextInt();

        for (int number = 2; number <= n; number++) {
            boolean isPrime = true;

            for (int divisor = 2; divisor <= number / divisor; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(number);
            }
        }

        System.out.println("Prime numbers up to " + n + ":");
        System.out.println(primes);
        System.out.println("Total primes: " + primes.size());

        input.close();
    }
}