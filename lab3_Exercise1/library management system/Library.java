
public class Library {
    private Book[] books = new Book[20];
    private Member[] members = new Member[20];

    private int bookCount = 0;
    private int memberCount = 0;

    public boolean addBook(Book book) {
        if (book == null || bookCount >= books.length) {
            return false;
        }

        books[bookCount++] = book;
        return true;
    }

    public boolean addMember(Member member) {
        if (member == null || memberCount >= members.length) {
            return false;
        }

        members[memberCount++] = member;
        return true;
    }

    private Book findBook(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }

        return null;
    }

    private Member findMember(int id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId() == id) {
                return members[i];
            }
        }

        return null;
    }

    public boolean borrow(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null || book == null ||
            !book.isAvailable()) {
            return false;
        }

        if (!member.borrow()) {
            return false;
        }

        book.setAvailable(false);
        return true;
    }

    public boolean giveBack(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null || book == null ||
            book.isAvailable()) {
            return false;
        }

        if (!member.returnBook()) {
            return false;
        }

        book.setAvailable(true);
        return true;
    }

    public void search(String title) {
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().toLowerCase()
                .contains(title.toLowerCase())) {

                System.out.println(
                    books[i].getId() + " - " +
                    books[i].getTitle() + " - " +
                    (books[i].isAvailable()
                        ? "Available" : "Borrowed")
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void showBooks() {
        for (int i = 0; i < bookCount; i++) {
            System.out.println(
                books[i].getId() + " - " +
                books[i].getTitle() + " - " +
                books[i].getAuthor() + " - " +
                (books[i].isAvailable()
                    ? "Available" : "Borrowed")
            );
        }
    }
}
