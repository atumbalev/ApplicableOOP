module converter {

    requires javafx.fxml;
    requires javafx.controls;

    opens converter to javafx.fxml;
    exports converter to javafx.graphics;

}