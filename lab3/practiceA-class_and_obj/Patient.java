class Patient {
    String name;
    int age;
    double weight;

    Patient(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void show() {
        System.out.println(
                "Name: " + name
                + ", Age: " + age
                + ", Weight: " + weight
        );
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("Abel",  20, 65.5);
        Patient patient2 = new Patient("Hana", 25, 58.2);

        patient1.show();
        patient2.show();
    }
}
