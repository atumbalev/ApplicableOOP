package zad1;

public class Rectangle {
    private double width;
    private double height;
    private String color;

    public Rectangle() {
        width = 1f;
        height = 1f;
        color = "Yellow";
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
        setColor("Yellow");
    }

    public void setWidth(double width) {
        if (width <= 0) {
            this.width = 1;
            return;
        }

        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            this.height = 1;
            return;
        }

        this.height = height;
    }

    public void setColor(String color) {
        if (color == null) {
            this.color = "Yellow";
            return;
        }

        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return height * width;
    }
}
