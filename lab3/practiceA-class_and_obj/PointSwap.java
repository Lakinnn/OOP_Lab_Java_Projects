class PointSwap {
    double x;
    double y;

    PointSwap(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static void swapCoords(PointSwap p, PointSwap q) {
        double tempX = p.x;
        double tempY = p.y;

        p.x = q.x;
        p.y = q.y;

        q.x = tempX;
        q.y = tempY;
    }

    public static void main(String[] args) {
        PointSwap p = new PointSwap(1, 2);
        PointSwap q = new PointSwap(10, 20);

        swapCoords(p, q);

        System.out.println("P: " + p.x + ", " + p.y);
        System.out.println("Q: " + q.x + ", " + q.y);
    }
}
