package parta;

public class Cylinder extends Circle {
    private double height;
    private final String CODE;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
        CODE = String.format("Cyl-%s", super.getID());
    }

    public Cylinder() {
        this(0, 0);
    }

    public Cylinder(Cylinder other) {
        this(other.getRadius(), other.height);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public String getCODE() {
        return CODE;
    }

    public double computeMeasure() {
        return 2 * Math.PI * getRadius() * (getRadius() + height);
    }

    public boolean isInsertable(Circle circle) {
        return super.isInsertable(circle);
    }

    @Override
    public String toString() {
        return String.format("Cylinder with height: %f, Id: %s and base: %s", height, CODE, super.toString());
    }
}
