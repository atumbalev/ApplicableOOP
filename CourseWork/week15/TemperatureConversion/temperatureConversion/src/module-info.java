module temperatureConversion {
    requires javafx.controls;
    requires javafx.fxml;

    opens conversion to javafx.fxml;
    exports conversion to javafx.graphics;
}