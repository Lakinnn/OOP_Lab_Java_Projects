public class SavingsGoal {
    public static void main(String[] args) {
        int savings = 100;
        int goal = 500;
        int months = 0;
 
        while (savings < goal) {
            savings += 120;
            months++;
            System.out.println("Month " + months
                    + ": $" + savings);
        }
        System.out.println("Goal reached in "
                + months + " months");
    }
}