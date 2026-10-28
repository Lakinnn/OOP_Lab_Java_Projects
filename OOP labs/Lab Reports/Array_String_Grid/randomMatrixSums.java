import java.util.Random;

public class randomMatrixSums {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] matrix = new int[3][3];

        System.out.println("3 x 3 Random Matrix:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = random.nextInt(10);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nSum of each row:");

        for (int i = 0; i < 3; i++) {
            int sum = 0;

            for (int j = 0; j < 3; j++) {
                sum += matrix[i][j];
            }

            System.out.println("Row " + (i + 1) + ": " + sum);
        }

        System.out.println("\nSum of each column:");

        for (int j = 0; j < 3; j++) {
            int sum = 0;

            for (int i = 0; i < 3; i++) {
                sum += matrix[i][j];
            }

            System.out.println("Column " + (j + 1) + ": " + sum);
        }
    }
}