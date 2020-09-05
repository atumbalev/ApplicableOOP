package point;


import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Line {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        setStartPoint(startPoint);
        setEndPoint(endPoint);
    }

    public Line() {
        this(null, null);
    }

    public Line(Line line) {
        this(line.startPoint, line.endPoint);
    }

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public Point getEndPoint() {
        return new Point(endPoint);
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint != null ? new Point(startPoint) : new Point();
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint != null ? new Point(endPoint) : new Point();
    }

    @Override
    public String toString() {
        return String.format("Start point: %s, end point: %s", startPoint.toString(), endPoint.toString());
    }

    public void draw(Group pane) {
        javafx.scene.shape.Line line =
                new javafx.scene.shape.Line(startPoint.getCoordinates()[0],
                        startPoint.getCoordinates()[1], endPoint.getCoordinates()[0], endPoint.getCoordinates()[1]);

        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        pane.getChildren().add(line);
    }
}
