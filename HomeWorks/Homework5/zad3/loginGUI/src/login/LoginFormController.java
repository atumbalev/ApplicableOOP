package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import validator.Validator;

public class LoginFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblUsernameError;

    @FXML
    private Label lblEmailError;

    @FXML
    private Label lblTelephoneError;

    @FXML
    private Label lblPasswordError;

    @FXML
    private Label lblConfirmPasswordError;

    @FXML
    private TextField txbUserName;

    @FXML
    private TextField txbEmail;

    @FXML
    private TextField txbTelephone;

    @FXML
    private TextField txbPassword;

    @FXML
    private TextField txbConfirmPassword;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnCancel;

    private boolean validateUsername() {
        String username = txbUserName.getText();
        System.out.println(Validator.validateUsername(username));

        if (Validator.validateUsername(username)) {
            lblUsernameError.setText("");
            return true;
        }

        lblUsernameError.setText("Invalid username");
        return false;
    }

    private boolean validateEmail() {
        String email = txbEmail.getText();
        System.out.println("email");

        if (Validator.validateEmail(email)) {
            lblEmailError.setText("");
            return true;
        }

        lblEmailError.setText("Invalid Email");
        return false;
    }

    private boolean validateTelephone() {
        String telephone = txbTelephone.getText();
        System.out.println("tel");

        if (Validator.validatePhoneNumber(telephone)) {
            lblTelephoneError.setText("");
            return true;
        }

        lblTelephoneError.setText("Invalid telephone number");
        return false;
    }

    private boolean validatePassword() {
        String password = txbPassword.getText();
        String confirmPassword = txbConfirmPassword.getText();

        System.out.println("pass");

        if (password.equals(confirmPassword)) {
            lblPasswordError.setText("");
            return true;
        }

        lblPasswordError.setText("Passwords must match");
        return false;
    }

    @FXML
    void BtnCancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        if (validateUsername() && validateEmail() && validateTelephone() && validatePassword()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("Registration successful");
            alert.show();
            alert.setOnHiding(e -> Platform.exit());
        }
    }
}
