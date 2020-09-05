package converter;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controller {

    @FXML
    private TextField txtInput;

    @FXML
    private Slider sldrRange;

    @FXML
    private Label lblSliderValue;

    @FXML
    void initialize() {
//        txtInput.textProperty().bindBidirectional(sldrRange.valueProperty(), new NumberStringConverter());
//        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        txtInput.textProperty().bindBidirectional(sldrRange.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return String.format("%.2f", number);
            }

            @Override
            public Number fromString(String s) {
                return Double.parseDouble(s);
            }
        });

        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

//        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));


        //OTHER OPTIONS

        // B. Unidirectional binding slider to Textfield and Label
        // Option 1.
        //          txtInput.textProperty().bind ( sldrRange.valueProperty().asString("%.2f"));
        //          lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        // Option 2.
        // Use ChangeListener
        //        sldrRange.valueProperty().addListener(new ChangeListener<Number>() {
        //            @Override
        //            public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue)
        //            {
        //                txtInput.setText(String.format("%.2f",newValue));
        //
        //            }
        //        });
        //        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        // C. High level binding using static methods of class Bindings
        // Use NumberStringConverter to adapt String to Number conversion
        //Other useful concrete implementations of abstract class StringConverter
        // converters IntegerStringConverter, DoubleStringConverter NumberStringConverter

        //Option 1 binding with Bindings class different property types, needs conversion
        //           Bindings.bindBidirectional(txtInput.textProperty(), sldrRange.valueProperty(), new NumberStringConverter());
        //           lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        //Option 2 binding with Bindings class equal property types, needs no conversion
        // Bindings.createDoubleBinding(<Lambda expr for method computeValue()>, list of dependencies);
//        StringBinding sb = Bindings.createStringBinding(()->lblSliderValue.textProperty().getValue(), lblSliderValue.textProperty());
        //          txtInput.textProperty().bind(sb);
        //          Bindings.bindBidirectional(lblSliderValue.textProperty(),sldrRange.valueProperty(), NumberFormat.getNumberInstance());


        //        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        // D. Low- level binding
        // Update Slider with Textfield numericinput
        //        StringBinding sp = new StringBinding(){ // scale by 100% the Slider value
        //            {
        //                super.bind(sldrRange.valueProperty());
        //            }
        //
        //            @Override
        //            protected String computeValue() {
        //                return   String.format("%.2f%%",   sldrRange.valueProperty().getValue()/100);
        //            }
        //        };
        //        txtInput.textProperty().bind(sp); // show Percent value in Textfield
        //        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));

        // E. Using unidirectional binding with Change event
        //        txtInput.textProperty().addListener((ChangeListener<String>) (a, b, newValue) -> {
        //            if (newValue.matches("\\d+")) {
        //                sldrRange.setValue(Integer.parseInt(newValue));
        //            }
        //        });
        //        lblSliderValue.textProperty().bind(sldrRange.valueProperty().asString("%.2f"));
        //        txtInput.textProperty().bind(lblSliderValue.textProperty());
    }
}
