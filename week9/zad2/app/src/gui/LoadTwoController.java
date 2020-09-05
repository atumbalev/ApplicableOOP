package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoadTwoController {

    @FXML
    private Label lblLoadedTwo;

    @FXML
    private Button btnClickTwo;

    @FXML
    void btnClickTwoActionPerformed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Loaded TWO");
        alert.setHeaderText("This is a sample JAVAFX Modular Application!");
        alert.setContentText(
                "Demonstrates the creation of multiple modules and switching GUI content from multiple scenes.");

        alert.showAndWait();
    }

}
