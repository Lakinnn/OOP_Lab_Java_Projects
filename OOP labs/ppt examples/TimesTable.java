public class TimesTable {
    public static void main(String[] args) {
        int n = 7;
 
        for (int i = 1; i <= 4; i++) {
            System.out.println(n + " x " + i
                    + " = " + n * i);
        }
 
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum 1..10 = " + sum);
    }
}