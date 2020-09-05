module Lab16bZad4 {
    requires javafx.fxml;
    requires javafx.controls;

    opens sample to javafx.fxml;
    exports sample to javafx.graphics;
}