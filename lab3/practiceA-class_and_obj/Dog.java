class Dog {
    String name;

    public static void main(String[] args) {
        Dog a = new Dog();
        Dog b = a;
        Dog c = new Dog();

        b.name = "X";

        System.out.println(a.name);
        System.out.println(c.name);
    }
}
