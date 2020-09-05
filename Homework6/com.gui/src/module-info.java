module com.gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.providers;

    opens com.gui to javafx.fxml;

    exports com.gui;
}