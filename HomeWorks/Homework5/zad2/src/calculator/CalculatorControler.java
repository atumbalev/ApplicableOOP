package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CalculatorControler extends AnchorPane {

    public CalculatorControler() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/calculator/Calculator.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private enum Operation {
        PLUS, MINUS, DIVIDE, MULT, MEMORIZE, MEMORIZE_PLUS, MEMORIZE_MINUS, MEMORIZE_CLEAR, NO_OP
    };
    private Operation operation;
    private double input;
    private double result;
    private double memory;

    private Alert mb;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSubstract;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnM;

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMC;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnQuit;
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    void btn00OnAction(ActionEvent event) {
        showDigit("00");
    }

    @FXML
    void btn0OnAction(ActionEvent event) {
        showDigit("0");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        showDigit("1");
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        showDigit("2");
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        showDigit("3");
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        showDigit("4");
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        showDigit("5");
    }

    @FXML
    void btn6OnAction(ActionEvent event) {
        showDigit("6");
    }

    @FXML
    void btn7OnAction(ActionEvent event) {
        showDigit("7");
    }

    @FXML
    void btn8OnAction(ActionEvent event) {
        showDigit("8");
    }

    @FXML
    void btn9OnAction(ActionEvent event) {
        showDigit("9");
    }

    private void showDigit(String digit) {
        String text = txtInput.getText();
        if (text.equals("0")) {
            txtInput.setText(digit);
        } else {
            txtInput.setText(text + digit);
        }
    }

    private void doOperation(Operation op) {
        input = Double.parseDouble(txtInput.getText());
        operation = op;
        txtInput.setText("0");
    }

    private void doMemoryOperation(Operation op) {
        input = Double.parseDouble(txtInput.getText());
        operation = Operation.NO_OP;

        switch (op) {
            case MEMORIZE:
                memory = input;
                result = 0;
                break;
            case MEMORIZE_PLUS:
                memory += input;
                result = memory;
                break;
            case MEMORIZE_MINUS:
                memory = input - memory;
                result = memory;
                break;
            case MEMORIZE_CLEAR:
                memory = 0;
                result = 0;
                break;
            default:
                result = 0;
        }

        txtInput.setText("" + result);
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtInput.setText("0");
        operation = Operation.NO_OP;
        memory = 0;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtInput.setText("0");
    }

    @FXML
    void btnComputeOnAction(ActionEvent event) {
        result = Double.parseDouble(txtInput.getText());
        switch (operation) {
            case MULT:
                result *= input;
                break;
            case DIVIDE:
                result = input / result;
                break;
            case PLUS:
                result = result + input;
                break;
            case MINUS:
                result = input - result;
                break;
            default:
                return;
        }
        txtInput.setText("" + result);
        operation = Operation.NO_OP;
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        doOperation(Operation.DIVIDE);
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        showDigit(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        doOperation(Operation.MULT);
    }

    @FXML
    void btnMOnAction(ActionEvent actionEvent) {
        doMemoryOperation(Operation.MEMORIZE);
    }

    @FXML
    void btnMPlusOnAction(ActionEvent actionEvent) {
        doMemoryOperation(Operation.MEMORIZE_PLUS);
    }

    @FXML
    void btnMMinusOnAction(ActionEvent actionEvent) {
        doMemoryOperation(Operation.MEMORIZE_MINUS);
    }

    @FXML
    void btnMCOnAction(ActionEvent actionEvent) {
        doMemoryOperation(Operation.MEMORIZE_CLEAR);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) { // ask to quit
        if ( ButtonType.OK == mb.showAndWait().get()) {
            Platform.exit();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        doOperation(Operation.PLUS);
    }

    @FXML
    void btnSubstractOnAction(ActionEvent event) {
        doOperation(Operation.MINUS);
    }

    @FXML
    void initialize() {
        operation = Operation.NO_OP;
        mb = new Alert(Alert.AlertType.CONFIRMATION);
        mb.setTitle("Quit");
        mb.setHeaderText(null);
        mb.setContentText("Do you really want to quit?");
        
    }
}
