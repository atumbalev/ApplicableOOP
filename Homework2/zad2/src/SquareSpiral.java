import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class SquareSpiral extends Application {

    private void drawSpiral(int height, Group group) {
        int spacing = height / 24;

        int lineX = height / 2;
        int lineY = height / 2;

        int lineLength = 0;

        Line line;

        for (int i = 0; i < 20; ++i) {
            line = new Line();
            line.setStartX(lineX);
            line.setStartY(lineY);
            lineLength += spacing;

            switch (i % 4) {
                case 0 :
                    line.setEndX(lineX);
                    line.setEndY(lineY += lineLength);
                    break;
                case 1 :
                    line.setEndX(lineX -= lineLength);
                    line.setEndY(lineY);
                    break;
                case 2 :
                    line.setEndX(lineX);
                    line.setEndY(lineY -= lineLength);
                    break;
                case 3 :
                    line.setEndX(lineX += lineLength);
                    line.setEndY(lineY);
            }

            line.setStroke(Color.RED);
            group.getChildren().add(line);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        int height = 500;
        drawSpiral(height, group);

        Scene scene = new Scene(group, height, height);

        primaryStage.setTitle("Geometry");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
