package hilbertCurve;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class HilbertCurvePane {

    private static int count;
    private double x, y; // U shape center
    private double length; // length of a U side. Dynamically determined based on order
    private int order = 1; // Order of the Hilbert curve
    private static  HilbertCurvePane hc;
    private Pane pane;

    private HilbertCurvePane(Pane pane) {
        this.pane = pane;
        count++;
    }

    public static HilbertCurvePane makePane(Pane pane) {
        if (count < 1) {
            hc = new HilbertCurvePane(pane);
        }
        return hc;
    }

    /**
     * Set a new order
     */
    public void setOrder(int order) {
        this.order = order;
        paint();
    }

    protected void paint() {
        // Get the length of a U side
        length = Math.min(pane.getWidth(), pane.getHeight());
        for (int i = 0; i < order; i++) {
            length /= 2;
        }

        // Reset start cursor position
        x = length / 2;
        y = length / 2;

        this.pane.getChildren().clear(); // Clear the pane before redisplay

        upperU(order); // Start recursion
    }

    /**
     * Display upper U
     */
    private void upperU(int order) {
        if (order > 0) {
            leftU(order - 1);
            lineNewPosition(0, length);
            upperU(order - 1);
            lineNewPosition(length, 0);
            upperU(order - 1);
            lineNewPosition(0, -length);
            rightU(order - 1);
        }
    }

    /**
     * Display left U
     */
    private void leftU(int order) {
        if (order > 0) {
            upperU(order - 1);
            lineNewPosition(length, 0);
            leftU(order - 1);
            lineNewPosition(0, length);
            leftU(order - 1);
            lineNewPosition(-length, 0);
            downU(order - 1);
        }
    }

    /**
     * Display right U
     */
    private void rightU(int order) {
        if (order > 0) {
            downU(order - 1);
            lineNewPosition(-length, 0);
            rightU(order - 1);
            lineNewPosition(0, -length);
            rightU(order - 1);
            lineNewPosition(length, 0);
            upperU(order - 1);
        }
    }

    /**
     * Display down U
     */
    private void downU(int order) {
        if (order > 0) {
            rightU(order - 1);
            lineNewPosition(0, -length);
            downU(order - 1);
            lineNewPosition(-length, 0);
            downU(order - 1);
            lineNewPosition(0, length);
            leftU(order - 1);
        }
    }

    /**
     * Draw a line from the current position to the new relative position
     */
    public void lineNewPosition(double deltaX, double deltaY) {
        pane.getChildren().add(new Line(x, y, x + deltaX, y + deltaY));
        x += deltaX;
        y += deltaY;
    }
}
