class Temperature {
    private double celsius;

    Temperature(double celsius) {
        setCelsius(celsius);
    }

    double getCelsius() {
        return celsius;
    }

    void setCelsius(double celsius) {
        if (celsius >= -273.15) {
            this.celsius = celsius;
        } else {
            System.out.println(
                    "Temperature cannot be below absolute zero."
            );
        }
    }

    double getFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Temperature temperature = new Temperature(25);

        System.out.println(temperature.getFahrenheit());

        temperature.setCelsius(-300);
        System.out.println(temperature.getCelsius());
    }
}
