class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    double getBalance() {
        return balance;
    }

    boolean transfer(BankAccount to, double amount) {
        if (withdraw(amount)) {
            to.deposit(amount);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(500);

        boolean successful = account1.transfer(account2, 300);

        System.out.println("Transfer successful: " + successful);
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
    }
}
