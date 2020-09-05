package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import model.Department;
import model.Manager;
import model.Staff;

public class StaffSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider sldrRange;

    @FXML
    private ComboBox<Staff> cboSelectStaff;

    @FXML
    private Label lblName;

    @FXML
    private Label lblWorksAt;

    @FXML
    private Label lblHiredAt;

    @FXML
    private Label lblIncrease;

    @FXML
    private Label lblSalary;

    @FXML
    void cboSelectStaffOnAction(ActionEvent event) {
        lblName.setText(cboSelectStaff.getValue().getName());
        lblHiredAt.setText(cboSelectStaff.getValue().getHiredAt().toString());
        lblWorksAt.setText(cboSelectStaff.getValue().getWorkAt());
    }

    Staff[] candidates;
    Manager manager;
    Department department;

    @FXML
    void initialize() {
        candidates = new Staff[] {
                new Staff("Go6o", 1000, "home", LocalDate.now()),
                new Staff("Pe6o", 1000, "home", LocalDate.now()),
                new Staff("Sme6o", 1000, "home", LocalDate.now()),
                new Staff("Gri6o", 1000, "home", LocalDate.now()),
                new Staff("Gen4o", 1000, "home", LocalDate.now()),
                new Staff("Tumba", 1000, "home", LocalDate.now()),
                new Staff("Slavy", 1000, "home", LocalDate.now())
        };

        manager = new Manager("Atanas", 2000, null);
        department = new Department(manager, "IT dept");
        manager.setAppointRule(department.appointmentHandler);

        Random rand = new Random();

        for (int i = 0; i < candidates.length; i++) {
            manager.appointStaffAppointment(candidates[i], (double) rand.nextInt(1000) + 1000);
        }

        ObservableList<Staff> olStaff = FXCollections.observableArrayList(department.getStaff());

        cboSelectStaff.setItems(olStaff);

        cboSelectStaff.setConverter(new StringConverter<Staff>() {

            @Override
            public String toString(Staff staff) {
                return String.format("%s: %s", staff.ID, staff.getName());
            }

            @Override
            public Staff fromString(String s) {
                return null;
            }
        });

        lblIncrease.textProperty().bindBidirectional(sldrRange.valueProperty(), new StringConverter<Number>() {

            @Override
            public String toString(Number number) {
                return number.toString() + " %";
            }

            @Override
            public Number fromString(String s) {
                return Double.parseDouble(s);
            }
        });
    }
}
