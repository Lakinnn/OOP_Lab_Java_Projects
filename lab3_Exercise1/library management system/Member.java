
public class Member {
    private int id;
    private String name;
    private int borrowedCount;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public boolean borrow() {
        if (borrowedCount >= 3) {
            return false;
        }

        borrowedCount++;
        return true;
    }

    public boolean returnBook() {
        if (borrowedCount <= 0) {
            return false;
        }

        borrowedCount--;
        return true;
    }
}
