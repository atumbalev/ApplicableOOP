package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class  Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Statistics> cboSelectCountry;

    @FXML
    private Label lblData;

    @FXML
    void cboSelectCountryOnAction(ActionEvent event) {
        lblData.setText("Data    " + cboSelectCountry.getValue().getData());
    }

    @FXML
    void initialize() {
        assert cboSelectCountry != null : "fx:id=\"cboSelectCountry\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblData != null : "fx:id=\"lblData\" was not injected: check your FXML file 'sample.fxml'.";

        ObservableList<Statistics> data = FXCollections.observableArrayList(
                new Statistics("Belgium", 3),
                new Statistics("France", 26),
                new Statistics("Germany", 35),
                new Statistics("Netherlands", 7),
                new Statistics("Sweden", 4),
                new Statistics("United Kingdom", 25)
        );

        cboSelectCountry.setItems(data);
    }
}
