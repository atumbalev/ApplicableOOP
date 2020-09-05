module loginGUI {
    requires javafx.controls;
    requires javafx.fxml;

    opens login to javafx.fxml;
    exports login to javafx.graphics;

    requires validator;
}