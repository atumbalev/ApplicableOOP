package conversion;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperatureConverterSceneController {

    @FXML
    private Label lblCelsiusOutput;

    @FXML
    private Label lblCelsiusInput;

    @FXML
    private Label lblFahrenheitOutput;

    @FXML
    private Label lblFahrenheitInput;

    @FXML
    private TextField txtCelsiusInput;

    @FXML
    private TextField txtFahrenheitOutput;

    @FXML
    private TextField txtFahrenheitInput;

    @FXML
    private TextField txtCelsiusOutput;

    @FXML
    void initialize() {
        //lambda
        txtCelsiusInput.textProperty().addListener((observableValue, oldValue, newValue) -> {
            double value = Double.parseDouble(newValue);
            value = 9.0 / 5.0 * value + 32;
            txtFahrenheitOutput.setText(String.format("%.2f", value));
        });

        txtFahrenheitInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                double value = Double.parseDouble(newValue);
                value = 5.0 / 9.0 * (value - 32);
                txtCelsiusOutput.setText(String.format("%.2f", value));
            }
        });
    }

}

