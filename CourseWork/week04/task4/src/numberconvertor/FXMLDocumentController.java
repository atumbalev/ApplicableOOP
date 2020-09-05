package numberconvertor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnHex;

    @FXML
    private Button btnBinary;

    @FXML
    private Button btnDegrees;

    @FXML
    private Button btnRadians;

    @FXML
    private TextField txtHex;

    @FXML
    private TextField txtDeciimal;

    @FXML
    private TextField txtBinary;

    @FXML
    private TextField txtDegrees;

    @FXML
    private TextField txtRadians;

    @FXML
    private MenuItem mniDecimal;

    @FXML
    private MenuItem mniHex;

    @FXML
    private MenuItem mniBinary;

    @FXML
    private MenuItem mniDegrees;

    @FXML
    private MenuItem mniRadians;

    @FXML
    private MenuItem mniQuit;

    @FXML
    void btnBinaryOnAction(ActionEvent event) {
        String input = txtBinary.getText();
        int value = Integer.parseInt(input, 2);
        txtDeciimal.setText("" + value);
        txtHex.setText("" + Integer.toHexString(value));
        txtDegrees.setText("0");
        txtRadians.setText("0");
    }

    @FXML
    void btnDecimalOnAction(ActionEvent event) {
        String input = txtDeciimal.getText();
        int value = Integer.parseInt(input, 10);
        txtBinary.setText("" + Integer.toBinaryString(value));
        txtHex.setText("" + Integer.toHexString(value));
        txtDegrees.setText("0");
        txtRadians.setText("0");
    }

    @FXML
    void btnHexOnAction(ActionEvent event) {
        String input = txtHex.getText();
        int value = Integer.parseInt(input, 16);
        txtBinary.setText("" + Integer.toBinaryString(value));
        txtDeciimal.setText("" + value);
        txtDegrees.setText("0");
        txtRadians.setText("0");
    }

    @FXML
    void btnDegreesOnAction(ActionEvent actionEvent) {
        String input = txtDegrees.getText();
        double value = Double.parseDouble(input);
        txtRadians.setText("" + value * ( Math.PI / 180));
        txtDeciimal.setText("0");
        txtBinary.setText("0");
        txtHex.setText("0");
    }

    @FXML
    void btnRadiansOnAction(ActionEvent actionEvent) {
        String input = txtRadians.getText();
        double value = Double.parseDouble(input);
        txtDegrees.setText("" + value * ( 180 / Math.PI ));
        txtDeciimal.setText("0");
        txtBinary.setText("0");
        txtHex.setText("0");
    }

    @FXML
    void mniBinaryOnAction(ActionEvent event) {
        btnDecimalOnAction(event);
    }

    @FXML
    void mniDecimalOnAction(ActionEvent event) {
        btnDecimalOnAction(event);
    }

    @FXML
    void mniHexOnAction(ActionEvent event) {
        btnHexOnAction(event);
    }

    @FXML
    void mniDegreesOnAction(ActionEvent actionEvent) {
        btnDegreesOnAction(actionEvent);
    }

    @FXML
    void mniRadiansOnAction(ActionEvent actionEvent) {
        btnRadiansOnAction(actionEvent);
    }

    @FXML
    void mniQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnDecimal != null : "fx:id=\"btnDecimal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnHex != null : "fx:id=\"btnHex\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnBinary != null : "fx:id=\"btnBinary\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtHex != null : "fx:id=\"txtHex\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtDeciimal != null : "fx:id=\"txtDeciimal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }
}
