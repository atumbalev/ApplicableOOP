package f71847.data;

public class Car {
    private final String REGISTRATION_NUMBER;
    private String model;
    private int abonament;

    public void setModel(String model) {
        this.model = model;
    }

    public void setAbonament(int abonament) {
        this.abonament = abonament;
    }

    public String getREGISTRATION_NUMBER() {
        return REGISTRATION_NUMBER;
    }

    public String getModel() {
        return model;
    }

    public int getAbonament() {
        return abonament;
    }

    public Car(String NOMER, String model, int abonament) {
        this.REGISTRATION_NUMBER = NOMER;
        setModel(model);
        setAbonament(abonament);
    }

    public Car() {
        this("", "unknown", 1);
    }

    public Car(Car other) {
        this(other.REGISTRATION_NUMBER, other.model, other.abonament);
    }

    @Override
    public String toString() {
        return String.format("Car: %s, Registration Number: %s%nNumber of payed months: %d", model, REGISTRATION_NUMBER, abonament);
    }
}
