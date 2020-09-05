module Lab15bZad6b {
    requires javafx.fxml;
    requires javafx.controls;

    exports sample to javafx.graphics;
    opens sample to javafx.fxml;
}