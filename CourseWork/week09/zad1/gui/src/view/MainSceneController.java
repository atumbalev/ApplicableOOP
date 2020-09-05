package view;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawLine;

    @FXML
    private Button btnDrawrRectangle;

    @FXML
    private Pane pnlDrawingBoard;

    private Random random = new Random();

    @FXML
    void btnDrawLineOnAction(ActionEvent event) {
        Point p = new Point();
        Line l = new Line();

//        l.draw();
    }

    @FXML
    void btnDrawrRectangleOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDrawLine != null : "fx:id=\"btnDrawLine\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnDrawrRectangle != null : "fx:id=\"btnDrawrRectangle\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert pnlDrawingBoard != null : "fx:id=\"pnlDrawingBoard\" was not injected: check your FXML file 'MainScene.fxml'.";

    }
}
