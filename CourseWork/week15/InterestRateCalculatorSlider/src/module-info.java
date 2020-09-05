module InterestRateCalculatorSlider {
    requires javafx.controls;
    requires javafx.fxml;
    opens depositcalculator to javafx.fxml;
    exports depositcalculator to javafx.graphics;
}