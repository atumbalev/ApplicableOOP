package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lblInput;

    @FXML
    private TextField lblOutput;

    @FXML
    void lblInputOnAction(ActionEvent event) {

    }

    @FXML
    void lblOutputOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert lblInput != null : "fx:id=\"lblInput\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblOutput != null : "fx:id=\"lblOutput\" was not injected: check your FXML file 'sample.fxml'.";

        lblInput.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if(!lblInput.getText().equals("")) {
                lblOutput.setText("" + (Integer.parseInt(newValue) + 10));
            }
        });
    }

    StringProperty sp = new SimpleStringProperty();

}
