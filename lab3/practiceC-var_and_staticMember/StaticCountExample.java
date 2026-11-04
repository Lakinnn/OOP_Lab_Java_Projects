class StaticCountExample {
    static int count = 0;

    StaticCountExample() {
        count++;
    }

    public static void main(String[] args) {
        StaticCountExample first = new StaticCountExample();
        StaticCountExample second = new StaticCountExample();

        System.out.println(first.count);
        System.out.println(second.count);
        System.out.println(StaticCountExample.count);
    }
}
