/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depositcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * @author echrk
 */
public class FXMLDocumentController implements Initializable {
    // formatters for CURRENCY and percentages
    private static final NumberFormat CURRENCY
            = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent
            = NumberFormat.getPercentInstance();
    private BigDecimal interestRate = new BigDecimal(0.02); // 2% default
    private DoubleProperty rateProperty = new SimpleDoubleProperty(0.02);

    @FXML
    private Label lblInterestRate;
    @FXML
    private TextField txtPrincipalAmount;
    @FXML
    private Slider sldInterestRate;
    @FXML
    private TextField txtTotalDeposit;

    @FXML
    private TextField txtNumberYears;

    @FXML
    void btnQquitClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnCalculateClicked(ActionEvent event) {
        try {
            BigDecimal principalAmount = new BigDecimal(txtPrincipalAmount.getText());
            int years = Integer.parseInt(txtNumberYears.getText());
            BigDecimal term = BigDecimal.ONE;
            BigDecimal total = BigDecimal.ONE;
            term = interestRate.add(BigDecimal.ONE);
            for (int i = 0; i < years; i++) {
                total = total.multiply(term);
            }
            total = principalAmount.multiply(total);
            txtTotalDeposit.setText(CURRENCY.format(total));
        } catch (NumberFormatException ex) {
            txtPrincipalAmount.setText("Enter amount");
            txtPrincipalAmount.selectAll();
            txtPrincipalAmount.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CURRENCY.setRoundingMode(RoundingMode.HALF_UP);
        // 0-4 rounds down, 5-9 rounds up 
        // Add a listener for changes to tipPercentageSlider's value
        // Option 1 use Lambda statements
        sldInterestRate
                .valueProperty()
                .addListener(
                        (ov, oldValue, newValue) ->
                        {
                            rateProperty.set(newValue.intValue() / 1000.);
                            interestRate = BigDecimal.valueOf(newValue.intValue() / 1000.);
                            lblInterestRate.setText(String.format("Interest rate %.2f%%",
                                    interestRate.multiply(BigDecimal.valueOf(100.))));
                        }
                );
        // Option 2 use annonymous class
//      sldInterestRate.valueProperty().addListener(
//         new ChangeListener<Number>() 
//         {
//            @Override
//            public void changed(ObservableValue<? extends Number> ov, 
//               Number oldValue, Number newValue) 
//            {
//               interestRate =  BigDecimal.valueOf(newValue.intValue() / 100.0);
//               lblAmount.setText("Interest rate" + percent.format(interestRate));
//            }
//         }
//      );

        DoubleBinding totalBinding = new DoubleBinding() {
            {
                super.bind(txtPrincipalAmount.textProperty(), txtNumberYears.textProperty(),
                        rateProperty);
            }

            @Override
            protected double computeValue() {
                String principalAmountString = txtPrincipalAmount.getText().trim();
                // " aaaaa ".trim() -> "aaaaa"
                String numberOfYearsString = txtNumberYears.getText().trim();

                if (!principalAmountString.isEmpty() && !numberOfYearsString.isEmpty()) {
                    double principalAmount = Double.parseDouble(principalAmountString);
                    int years = Integer.parseInt(numberOfYearsString);
                    double term = rateProperty.get() + 1.;
                    double total = 1.;
                    for (int i = 0; i < years; i++) {
                        total = total * term;
                    }
                    return principalAmount * total;
                }

                return 0;
            }
        };

//        txtTotalDeposit.textProperty().bind(Bindings.format("%.2f", totalBinding));
//        totalBinding.addListener((observableValue, oldValue, newValue) -> {
//            txtTotalDeposit.setText(CURRENCY.format(newValue));
//        });

        StringBinding currencyBinding = new StringBinding() {
            {
                super.bind(totalBinding);
            }
            @Override
            protected String computeValue() {
                return CURRENCY.format(totalBinding.get());
            }
        };

        txtTotalDeposit.textProperty().bind(currencyBinding);
    }

}
