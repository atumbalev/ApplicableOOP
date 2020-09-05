package parta;

public class Circle {
    private double radius;
    private final String ID;
    private static int lastID = 1;

    public Circle(double radius) {
        this.radius = radius;
        this.ID = String.format("Circle No. %d", lastID++);
    }

    public Circle(Circle other) {
        this(other.radius);
    }

    public Circle() {
        this(0);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getID() {
        return ID;
    }

    public double computeMeasure() {
        return Math.PI * radius * radius;
    }

    public boolean isInsertable(Circle circle) {
        return circle.getRadius() < radius;
    }

    @Override
    public String toString() {
        return String.format("Circle with radius: %f and ID %s", radius, ID);
    }
}
