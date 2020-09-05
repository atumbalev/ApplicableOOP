package geometry;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Rectangle extends Point {
    //private Point uPoint; is upper left corner of the rectangle
    private Point lPoint;

    public Rectangle(int[] coords, Point lPoint) {
        super(coords);
        setlPoint(lPoint);
    }

    /*
    public Rectangle(Point uPoint, double width, double height) {
        setHeight(height);
        setuPoint(uPoint);
        setWidth(width);
    }

     */

    public Rectangle() {
        this(new int[]{0, 0}, new Point(new int[]{10, 10}));
    }

    public Rectangle(Rectangle r) {
        this(r.getCoords(), r.lPoint);
    }

    public Point getlPoint() {
        return new Point(lPoint);
    }

    public void setlPoint(Point lPoint) {
        this.lPoint = new Point(lPoint);
    }

    public int measure(){
        int width = Math.abs(super.getCoords()[0] - lPoint.getCoords()[0]);
        int height = Math.abs(super.getCoords()[1] - lPoint.getCoords()[1]);
        //Math abs ненужно след направената проверка в Контролера
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Upper left point: %s, " +
                "Lower right point: %s, \n",
                super.toString(), lPoint.toString());

    }

    public void draw(Pane pane){
        double width = Math.abs(super.getCoords()[0] - lPoint.getCoords()[0]);
        double height = Math.abs(super.getCoords()[1] - lPoint.getCoords()[1]);
        //Math abs ненужно след направената проверка в Контролера

        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(
                        super.getCoords()[0], super.getCoords()[1],
                        width, height
                );

        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(null);
        pane.getChildren().add(rectangle);
    }
}
