package point;

public class Point {
    private double[] coordinates;

    public Point(double[] coordinates) {
        setCoordinates(coordinates);
    }

    public Point() {
        setCoordinates(new double[2]);
    }

    public Point(Point p) {
        this(p.coordinates);
    }

    public double[] getCoordinates() {
        double[] copy = new double[2];
        System.arraycopy(copy, 0, coordinates,0, 2);
        return copy;
    }

    public void setCoordinates(double[] coordinates) {
        if (coordinates != null && coordinates.length == 2) {
            coordinates = new double[2];
            System.arraycopy(coordinates, 0, this.coordinates, 0, 2);
        }
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", coordinates[0], coordinates[1]);
    }
}
