package sample;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Person> cboSelectedPerson;

    @FXML
    private Label lblFIrstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblYearsAtWork;

    @FXML
    private Label lblFirstNameValue;

    @FXML
    private Label lblLastNameValue;

    @FXML
    private Label lblHiredAtValue;

    @FXML
    private Label lblYearsAtWorkValue;

    @FXML
    void initialize() {
        assert cboSelectedPerson != null : "fx:id=\"cboSelectedPerson\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblFIrstName != null : "fx:id=\"lblFIrstName\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblLastName != null : "fx:id=\"lblLastName\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblHiredAt != null : "fx:id=\"lblHiredAt\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblYearsAtWork != null : "fx:id=\"lblYearsAtWork\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblFirstNameValue != null : "fx:id=\"lblFirstNameValue\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblLastNameValue != null : "fx:id=\"lblLastNameValue\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblHiredAtValue != null : "fx:id=\"lblHiredAtValue\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblYearsAtWorkValue != null : "fx:id=\"lblYearsAtWorkValue\" was not injected: check your FXML file 'sample.fxml'.";

        ObservableList<Person> options = FXCollections.observableArrayList(
                new Person("George", "Georgiev", LocalDate.of(2014, 8, 4)),
                new Person("Pavel", "Ivanov", LocalDate.of(2012, 1, 14)),
                new Person("Ivan", "Petrov", LocalDate.of(2019, 5, 12)),
                new Person("Stoyan", "Pavlov", LocalDate.of(2018, 3, 24)),
                new Person("Kiril", "Simeonov", LocalDate.of(2020, 7, 4)),
                new Person("Jordan", "Angelov", LocalDate.of(2017, 2, 6))
        );

        cboSelectedPerson.setItems(options);
        cboSelectedPerson.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person person) {
                return String.format("%s, %s", person.getLastName(), person.getFirstName());
            }

            @Override
            public Person fromString(String s) {
                return null;
            }
        });

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd YYYY");

        cboSelectedPerson.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            if (cboSelectedPerson.getSelectionModel().getSelectedIndex() >= 0) {
                Person selectedPerson = newValue;
                lblFirstNameValue.setText(selectedPerson.getFirstName());
                lblLastNameValue.setText(selectedPerson.getLastName());
                lblHiredAtValue.setText(formatter.format(selectedPerson.getHireDate()));
                lblYearsAtWorkValue.setText(String.valueOf(LocalDate.now().getYear() - selectedPerson.getHireDate().getYear()));
            }
        });
    }
}
