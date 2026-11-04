class Ticket {
    private static int nextNumber = 1;
    private String ticketNumber;

    Ticket() {
        ticketNumber = String.format("T-%03d", nextNumber);
        nextNumber++;
    }

    void display() {
        System.out.println(ticketNumber);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Ticket ticket = new Ticket();
            ticket.display();
        }
    }
}
