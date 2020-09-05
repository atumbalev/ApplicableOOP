package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoadOneController {

    @FXML
    private Label lblLoadedOne;

    @FXML
    private Button btnClickOne;

    @FXML
    void btnClickOneOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Loaded ONE");
        alert.setHeaderText("This is a sample JAVAFX Modular Application!");
        alert.setContentText(
                "Demonstrates the creation of multiple modules and switching GUI content from multiple scenes.");

        alert.showAndWait();
    }

}
