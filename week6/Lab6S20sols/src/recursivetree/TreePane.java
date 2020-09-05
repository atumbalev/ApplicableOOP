package recursivetree;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public  class TreePane extends Pane {
    private int depth = 0;
    private double angleFactor = Math.PI / 5;
    private double sizeFactor = 0.58;

    public void setDepth(int depth) {
        this.depth = depth;
        paint();
    }

    public void paint() {
        getChildren().clear();

        paintBranch(depth, getWidth() / 2, getHeight() - 10,
                getHeight() / 3, Math.PI / 2);
    }

    public void paintBranch(int depth, double x1, double y1,
                            double length, double angle) {
        if (depth >= 0) {
            double x2 = x1 + Math.cos(angle) * length;
            double y2 = y1 - Math.sin(angle) * length;

            // Draw the line
            getChildren().add(new Line(x1, y1, x2, y2));

            // Draw the left branch
            paintBranch(depth - 1, x2, y2, length * sizeFactor, angle
                    + angleFactor);
            // Draw the right branch
            paintBranch(depth - 1, x2, y2, length * sizeFactor, angle
                    - angleFactor);
        }
    }
}
