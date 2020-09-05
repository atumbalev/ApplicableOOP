package f71847.data;

public class Parking {
    private final int TOTAL_CARS = 50;
    private Car[] cars;
    String location;

    public void setCars(Car[] cars) {
        this.cars = cars.clone();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTOTAL_CARS() {
        return TOTAL_CARS;
    }

    public Car[] getCars() {
        return cars;
    }

    public String getLocation() {
        return location;
    }

    public Parking(Car[] cars, String location) {
        setCars(cars);
        setLocation(location);
    }

    public Parking(String location) {
        cars = new Car[TOTAL_CARS];
        setLocation(location);
    }

    public Parking() {
        cars = new Car[TOTAL_CARS];
        setLocation("unknown");
    }

    public int[] paymentByMonth() {
        int[] carsWithAbonament = new int[13];

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getAbonament() >= 1 && cars[i].getAbonament() <= 12) {
                ++carsWithAbonament[cars[i].getAbonament()];
            }
        }

        return carsWithAbonament;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Address: %s, Total cars: %d%n", location, TOTAL_CARS));

        for (int i = 0; i < cars.length; i++) {
            result.append(cars[i].toString()).append('\n');
        }

        return result.toString();
    }
}
