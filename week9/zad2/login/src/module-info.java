module login {

    requires javafx.controls;
    requires javafx.fxml;
    requires app;

    opens startup to javafx.fxml;
    exports startup;

}