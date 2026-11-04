class CountExample {
    int instanceCount = 0;

    CountExample() {
        instanceCount++;
    }

    public static void main(String[] args) {
        CountExample first = new CountExample();
        CountExample second = new CountExample();

        System.out.println(first.instanceCount);
        System.out.println(second.instanceCount);
    }
}
