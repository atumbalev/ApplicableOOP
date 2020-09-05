module indexCalculator {

    requires javafx.controls;
    requires javafx.fxml;

    opens bmi to javafx.fxml;
    exports bmi to javafx.graphics;

}