class VariableExample {
    static int staticNumber;
    int instanceNumber;

    void method() {
        int localNumber = 10;

        System.out.println(localNumber);
        System.out.println(instanceNumber);
        System.out.println(staticNumber);
    }
}
