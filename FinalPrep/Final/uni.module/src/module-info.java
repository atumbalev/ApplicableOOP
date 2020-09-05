module uni.module {
    requires javafx.controls;
    requires javafx.fxml;

    opens model to javafx.fxml;
    exports model to javafx.graphics;
}