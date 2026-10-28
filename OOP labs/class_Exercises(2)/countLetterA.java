import java.util.Scanner;

public class countLetterA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'A') {
                count++;
            }
        }

        System.out.println("Number of 'a' letters: " + count);

        input.close();
    }
}