class Account {
    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account(100);

        // account.balance = 500; // Error: balance is private

        account.deposit(400);
        System.out.println(account.getBalance());
    }
}
