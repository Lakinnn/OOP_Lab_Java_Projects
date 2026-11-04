class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        double dx = other.x - x;
        double dy = other.y - y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);

        System.out.println(p1.distanceTo(p2));
        System.out.println(p1 == p2);
    }
}
