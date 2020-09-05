package startup;

import java.io.IOException;

import gui.MainMenuSceneController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WelcomeSceneController {

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    private Stage mainMenu;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (areInputsValid()) {
            // get current stage (window)
            mainMenu = (Stage) txtPassword.getScene().getWindow();
            mainMenu.hide(); // close current stage, avoid blink // read new scene
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                loader.setLocation(getClass()
                        .getResource("/gui/MainMenuScene.fxml"));
                root = (Parent) loader.load(getClass().getResource("MainMenuScene.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Get the Controller from the FXML scene
            // setup the newly read scene
            MainMenuSceneController menuController = (MainMenuSceneController) loader.getController();
            // switch scenes
            Scene scene = new Scene(root);
            mainMenu.setScene(scene);
            mainMenu.setTitle("Student dashboard");
            mainMenu.setResizable(false);
            mainMenu.show();
        }
    }

    private boolean areInputsValid() {
        boolean usernameValid = txtUsername.getText().matches("[A-z]+"); //ABCD....XYZabcd...xyz
        boolean passwordValid = txtPassword.getText().matches("([0-9]+[A-z]+|[A-z]+[0-9]+)+");
        return usernameValid && passwordValid;
    }

}
