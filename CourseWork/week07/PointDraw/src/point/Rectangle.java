package point;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint;
    private double height;
    private double width;

    public Rectangle(Point uPoint, double height, double width) {
        setuPoint(uPoint);
        setHeight(height);
        setWidth(width);
    }

    public Rectangle() {
        this(new Point(), 10, 10);
    }

    public Rectangle(Rectangle r) {
        this (r.uPoint, r.height, r.width);
    }

    public Point getuPoint() {
        return new Point(uPoint);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setuPoint(Point uPoint) {
        this.uPoint = uPoint != null ? new Point(uPoint) : new Point();
    }

    public void setHeight(double height) {
        this.height = height >= 0 ? height : 0;
    }

    public void setWidth(double width) {
        this.width = width >= 0 ? width : 0;
    }

    @Override
    public String toString() {
        return String.format("Upper left point: %s, width: %.2f, height: %.2f", uPoint.toString(), width, height);
    }

    public void draw(Group pane) {
        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(uPoint.getCoordinates()[0], uPoint.getCoordinates()[1], width, height);

        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().add(rectangle);
    }
}
