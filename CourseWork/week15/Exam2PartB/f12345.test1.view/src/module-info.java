module f12345.test1.view {
    requires f12345.test1.model;
    requires javafx.fxml;
    requires javafx.controls;

    exports f12345.test1.view to javafx.graphics;
    opens f12345.test1.view to javafx.fxml;
}