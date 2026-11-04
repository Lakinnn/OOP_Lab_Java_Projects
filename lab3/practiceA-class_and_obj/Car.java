class Car {
    String brand;
    int speed;

    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void accelerate(int amount) {
        speed += amount;
    }

    void brake(int amount) {
        speed -= amount;

        if (speed < 0) {
            speed = 0;
        }
    }

    void display() {
        System.out.println(brand + " - Speed: " + speed);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 40);
        Car car2 = new Car("BMW", 60);

        car1.accelerate(20);
        car2.brake(80);

        car1.display();
        car2.display();
    }
}
