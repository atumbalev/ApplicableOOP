package geometry;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Line extends Point{
   // private Point sPoint; line becomes starting point
    private Point ePoint; //ending point

    public Line(int[] coords, Point ePoint) {
        super(coords);
        setePoint(ePoint);
    }

    /*
    public Line(Point sPoint, Point ePoint) {
        setePoint(ePoint);
        setsPoint(sPoint);
    }
    */


    public Line() {
        this(new int[]{0, 0}, new Point(new int[]{10, 10}));
    }

    public Line(Line l) {
        this(l.getCoords(), l.ePoint);
    }

    /*
    public Point getsPoint() {
        return new Point(sPoint);
    }

    public void setsPoint(Point sPoint) {
        this.sPoint = new Point(sPoint);
    }

     */

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        this.ePoint = new Point(ePoint);
    }

    /*
    public String measure(){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        nf.setMaximumFractionDigits(2);
        double length = Math.sqrt((super.getCoords()[0] - ePoint.getCoords()[0]) *
                (super.getCoords()[0] - ePoint.getCoords()[0]) +
                (super.getCoords()[1] - ePoint.getCoords()[1]) *
                        (super.getCoords()[1] - ePoint.getCoords()[1]));
        return nf.format(length);
    }
     */
    public double measure() {
        return Math.sqrt((super.getCoords()[0] - ePoint.getCoords()[0]) *
                        (super.getCoords()[0] - ePoint.getCoords()[0]) +
                        (super.getCoords()[1] - ePoint.getCoords()[1]) *
                        (super.getCoords()[1] - ePoint.getCoords()[1]));
    }

    @Override
    public String toString() {
        return String.format("Starting point: %s, Ending point: %s",
                super.toString(), ePoint.toString());
    }

    public void draw(Pane pane){
        javafx.scene.shape.Line line =
                new javafx.scene.shape.Line(
                        super.getCoords()[0], super.getCoords()[1],
                        ePoint.getCoords()[0], ePoint.getCoords()[1]
                );

        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        pane.getChildren().add(line);
    }
}
