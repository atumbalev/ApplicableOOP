package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private PasswordField psdPassword;

    @FXML
    private TextField txtUsername;

    private Alert messageBox;

    private BooleanProperty accessGranted;

    private User user;

    @FXML
    void onPsdPasswordAction(ActionEvent event) {
        if (accessGranted.get()) {
            messageBox.setTitle("Message");
            messageBox.setHeaderText("Login Information");
            messageBox.setContentText(String.format("Grated access:%s\npassword:%s", txtUsername.getText(), psdPassword.getText()));
            messageBox.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'sample.fxml'.";
        assert psdPassword != null : "fx:id=\"psdPassword\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'sample.fxml'.";

        user = new User();
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        accessGranted = new SimpleBooleanProperty(this, "accessGranted", false);
        txtUsername.textProperty().bind(user.lastnameProperty());

        psdPassword.textProperty().addListener((observableValue, oldValue, newValue) -> {
            accessGranted.set(user.getPassword().equals(newValue));
        });
        accessGranted.addListener((observableValue, oldValue, newValue) -> {
            Stage primaryStage = (Stage) lblUsername.getScene().getWindow();
            if (newValue) {
                primaryStage.setTitle("Access granted");
            } else {
                primaryStage.setTitle("No access");
            }
        });
    }
}
