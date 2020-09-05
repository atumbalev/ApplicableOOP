package bmi;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMISceneController {

    @FXML
    private Label lblWeight;

    @FXML
    private Label lblHeight;

    @FXML
    private Label lblBmi;

    @FXML
    private TextField txtWeight;

    @FXML
    private TextField txtHeight;

    @FXML
    private TextField txtBmi;

    @FXML
    void initialize() {
        DoubleBinding doubleBinding = new DoubleBinding() {
            {
                super.bind(txtWeight.textProperty(), txtHeight.textProperty());
            }

            @Override
            protected double computeValue() {
                String weightString = txtWeight.getText().trim();
                String heightString = txtHeight.getText().trim();
                if (weightString.isEmpty() || heightString.isEmpty()) {
                    return 0;
                }
                double weight = Double.parseDouble(weightString);
                double height = Double.parseDouble(heightString);

                return weight / (height * height);
            }
        };

        txtBmi.textProperty().bind(Bindings.format("%.2f", doubleBinding));
    }

}

