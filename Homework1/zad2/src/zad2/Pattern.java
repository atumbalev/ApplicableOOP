package zad2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Pattern extends Application {

    private static void drawPattern(Group group, double width, double height) throws InterruptedException {
        Line line; // Line reference that will be used to construct a line and add it tho the group
        int increment = 20; // number of lines that connect 2 adjacent sides
        double widthStep = width / increment;
        double heightStep = height / increment;

        // Draws the lines that connect the left side to the bottom side
        for (int count = 0; count < increment; count++) {
            line = new Line(0, count * heightStep, (count) * widthStep, height);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        // Draws the lines that connect the right side to the top side
        for (int count = 0; count < increment; count++) {
            line = new Line(width, count * heightStep, (count) * widthStep, 0);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        // Draws the lines that connect the left side to the top side
        for (int count = 0; count < increment; count++) {
            line = new Line(count * widthStep, 0, 0, height - (count) * heightStep);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }

        // Draws the lines that connect the right side to the bottom side
        for (int count = 0; count < increment; count++) {
            line = new Line(count * widthStep, height, width, height - (count) * heightStep);
            line.setStroke(Color.ORANGE);
            group.getChildren().add(line);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        drawPattern(group, 600,500);
        Scene scene = new Scene(group, 600, 500);

        primaryStage.setTitle("Canvas demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}