package sample;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Person> cboSelectPerson;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblYearsAtWork;

    @FXML
    void cboSelectPersonOnAction(ActionEvent event) {
        Person selected = cboSelectPerson.getValue();
        LocalDate hiredate = selected.getHireDate();
        lblFirstName.setText(selected.getFirstName());
        lblLastName.setText(selected.getLastName());
        lblHiredAt.setText(String.format("%s %s %d", hiredate.getMonth(), hiredate.getDayOfMonth(), hiredate.getYear()));
        lblYearsAtWork.setText("" + (LocalDate.now().getYear() - hiredate.getYear()));
    }

    @FXML
    void initialize() {
        assert cboSelectPerson != null : "fx:id=\"cboSelectPerson\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblFirstName != null : "fx:id=\"lblFirstName\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblLastName != null : "fx:id=\"lblLastName\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblYearsAtWork != null : "fx:id=\"lblYearsAtWork\" was not injected: check your FXML file 'sample.fxml'.";

        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("George", "Georgiev", LocalDate.of(2014, 8, 4)),
                new Person("Pavel", "Ivanov", LocalDate.of(2012, 1, 14)),
                new Person("Ivan", "Petrov", LocalDate.of(2019, 5, 12)),
                new Person("Stoyan", "Pavlov", LocalDate.of(2018, 3, 24)),
                new Person("Kiril", "Simeonov", LocalDate.of(2020, 7, 4)),
                new Person("Jordan", "Angelov", LocalDate.of(2017, 2, 6))
        );

        cboSelectPerson.setItems(data);
    }
}
