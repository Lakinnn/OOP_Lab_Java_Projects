import java.util.Scanner;

public class fullSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an Integer: ");
        int n = input.nextInt();
        input.nextLine();

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println(sentence);
        }

        input.close();
    }
}