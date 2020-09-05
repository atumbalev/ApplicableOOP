package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Rectangle shape;

    @FXML
    private Slider sldrRed;

    @FXML
    private Slider sldrGreen;

    @FXML
    private Slider sldrBlue;

    @FXML
    private Slider sldrOpacity;

    @FXML
    public void initialize() {
        ChangeListener<Number> changeListener = (observableValue, oldValue, newValue) -> {
            shape.setFill(Color.rgb((int) sldrRed.getValue(), (int) sldrGreen.getValue(), (int) sldrBlue.getValue(), sldrOpacity.getValue()));
        };

        sldrRed.valueProperty().addListener(changeListener);
        sldrGreen.valueProperty().addListener(changeListener);
        sldrBlue.valueProperty().addListener(changeListener);
        sldrOpacity.valueProperty().addListener(changeListener);

//        sldrRed.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            int red = newValue.intValue();
//            shape.setFill(Color.rgb(red, (int) sldrGreen.getValue(), (int) sldrBlue.getValue(), sldrOpacity.getValue()));
//        });
//
//        sldrGreen.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            int green = newValue.intValue();
//            shape.setFill(Color.rgb((int) sldrRed.getValue(), green, (int) sldrBlue.getValue(), sldrOpacity.getValue()));
//        });
//
//        sldrBlue.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            int blue = newValue.intValue();
//            shape.setFill(Color.rgb((int) sldrRed.getValue(), (int) sldrGreen.getValue(), blue, sldrOpacity.getValue()));
//        });
//
//        sldrOpacity.valueProperty().addListener((observableValue, oldValue, newValue) -> {
//            shape.setFill(Color.rgb((int) sldrRed.getValue(), (int) sldrGreen.getValue(), (int) sldrBlue.getValue(), newValue.doubleValue()));
//        });
    }

}
