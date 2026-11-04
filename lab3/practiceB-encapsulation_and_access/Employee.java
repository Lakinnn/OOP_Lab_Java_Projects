class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);
    }

    double getSalary() {
        return salary;
    }

    void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative.");
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Mekdes", 5000);

        System.out.println(employee.getSalary());

        employee.setSalary(6000);
        employee.setSalary(-100);

        System.out.println(employee.getSalary());
    }
}
