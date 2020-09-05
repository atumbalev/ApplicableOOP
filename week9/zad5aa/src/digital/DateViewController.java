package digital;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DateViewController extends AnchorPane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblDate;

    @FXML
    private Button btnText;

    @FXML
    void btnTextOnAction(ActionEvent event) {
        lblDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
    }
    @FXML
    void initialize() {
        //https://stackoverflow.com/questions/2758224/what-does-the-java-assert-keyword-do-and-when-should-it-be-used
        assert lblDate != null : "fx:id=\"lblDate\" was not injected: check your FXML file 'DateView.fxml'.";

    }

    //Конструктор
    public DateViewController() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/digital/DateView.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
