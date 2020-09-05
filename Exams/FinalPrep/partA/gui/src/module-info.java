module gui {

    requires javafx.controls;
    requires javafx.fxml;

    requires model;

    opens gui to javafx.fxml;
    exports gui to javafx.graphics;

}