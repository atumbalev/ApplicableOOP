module f71847.test1.view {
    requires javafx.fxml;
    requires javafx.controls;

    opens f71847.test1.view to javafx.fxml;

    requires f71847.test1.game;


    exports f71847.test1.view;
}