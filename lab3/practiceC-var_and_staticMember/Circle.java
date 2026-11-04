class Circle {
    static final double PI = Math.PI;
    private static int count = 0;

    private double radius;

    Circle(double radius) {
        this.radius = radius;
        count++;
    }

    static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(3);
        Circle c3 = new Circle(4);
        Circle c4 = new Circle(5);

        System.out.println("PI: " + Circle.PI);
        System.out.println("Number of circles: " + Circle.getCount());
    }
}
