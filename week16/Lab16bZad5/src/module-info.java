module Lab16bZad5 {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens sample to javafx.fxml, javafx.base;
    exports sample to javafx.graphics;
}