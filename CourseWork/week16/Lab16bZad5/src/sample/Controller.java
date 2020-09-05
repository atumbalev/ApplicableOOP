package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar mnuMainBar;

    @FXML
    private Menu mnuApplication;

    @FXML
    private MenuItem mniLoadEmployees;

    @FXML
    private MenuItem mniClose;

    @FXML
    private Menu mnuView;

    @FXML
    private MenuItem mniSortBySalaryAndBirthday;

    @FXML
    private MenuItem mniSortByFirstAndLast;

    @FXML
    private Menu mnuHelp;

    @FXML
    private MenuItem mniAbout;

    @FXML
    private Label lblEmployeeDetails;

    @FXML
    private TableView<Employee> tblEmployeeDetails;

    @FXML
    private TableColumn<Employee, Integer> colId;

    @FXML
    private TableColumn<Employee, String> colFirstName;

    @FXML
    private TableColumn<Employee, String> colLastName;

    @FXML
    private TableColumn<Employee, String> colEmail;

    @FXML
    private TableColumn<Employee, String> colPhone;

    @FXML
    private TableColumn<Employee, Double> colSalary;

    @FXML
    private TableColumn<Employee, LocalDate> colBirthday;

    private Alert alertBox;

    private ObservableList<Employee> data;

    private DbConnection dbConnection;

    @FXML
    void onMniAboutAction(ActionEvent event) {
        alertBox.showAndWait();
    }

    @FXML
    void onMniCloseAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onMniLoadEmployeesAction(ActionEvent event) {
        loadEmployeesData();
    }

    @FXML
    void onMniSortByFirstAndLastAction(ActionEvent event) {
//        FXCollections.sort(data, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                int compareResult = o1.getFirstName().compareTo(o2.getFirstName());
//
//                if (compareResult != 0) {
//                    return compareResult;
//                }
//
//                return o2.getLastName().compareTo(o1.getLastName());
//            }
//        });
        FXCollections.sort(data, Comparator.comparing(Employee::getFirstName).reversed()
            .thenComparing(Employee::getLastName).reversed());
    }

    @FXML
    void onMniSortBySalaryAndBirthdayAction(ActionEvent event) {
        FXCollections.sort(data, Comparator.comparing(Employee::getSalary)
            .thenComparing(Employee::getBirthday).reversed());
    }

    @FXML
    void initialize() {
        assert mnuMainBar != null : "fx:id=\"mnuMainBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert mnuApplication != null : "fx:id=\"mnuApplication\" was not injected: check your FXML file 'sample.fxml'.";
        assert mniLoadEmployees != null : "fx:id=\"mniLoadEmployees\" was not injected: check your FXML file 'sample.fxml'.";
        assert mniClose != null : "fx:id=\"mniClose\" was not injected: check your FXML file 'sample.fxml'.";
        assert mnuView != null : "fx:id=\"mnuView\" was not injected: check your FXML file 'sample.fxml'.";
        assert mniSortBySalaryAndBirthday != null : "fx:id=\"mniSortBySalaryAndBirthday\" was not injected: check your FXML file 'sample.fxml'.";
        assert mniSortByFirstAndLast != null : "fx:id=\"mniSortByFirstAndLast\" was not injected: check your FXML file 'sample.fxml'.";
        assert mnuHelp != null : "fx:id=\"mnuHelp\" was not injected: check your FXML file 'sample.fxml'.";
        assert mniAbout != null : "fx:id=\"mniAbout\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblEmployeeDetails != null : "fx:id=\"lblEmployeeDetails\" was not injected: check your FXML file 'sample.fxml'.";
        assert tblEmployeeDetails != null : "fx:id=\"tblEmployeeDetails\" was not injected: check your FXML file 'sample.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'sample.fxml'.";
        assert colFirstName != null : "fx:id=\"colFirstName\" was not injected: check your FXML file 'sample.fxml'.";
        assert colLastName != null : "fx:id=\"colLastName\" was not injected: check your FXML file 'sample.fxml'.";
        assert colEmail != null : "fx:id=\"colEmail\" was not injected: check your FXML file 'sample.fxml'.";
        assert colPhone != null : "fx:id=\"colPhone\" was not injected: check your FXML file 'sample.fxml'.";
        assert colSalary != null : "fx:id=\"colSalary\" was not injected: check your FXML file 'sample.fxml'.";
        assert colBirthday != null : "fx:id=\"colBirthday\" was not injected: check your FXML file 'sample.fxml'.";

        alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setHeaderText("Employee database client");
        alertBox.setContentText("Employee database management system");
        dbConnection = new DbConnection();

        data = FXCollections.observableArrayList();

        tblEmployeeDetails.setItems(data);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        colSalary.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colSalary.setOnEditCommit((e) -> {
            Employee employee = e.getRowValue();
            Double newSalary = e.getNewValue();
            updateSalaryById(employee.getId(), newSalary);
        });
    }

    private void loadEmployeesData() {
        String loadEmployeesSqlQuery = "SELECT * FROM employees";
        data.clear();

        try (Connection connection = dbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(loadEmployeesSqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()) {
                data.add(new Employee(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDouble(6),
                        LocalDate.parse(resultSet.getString(7))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSalaryById(Integer id, Double newSalary) {
        String updateSalaryByIdQuery = String.format("UPDATE employees SET salary = %.2f WHERE id = %d", newSalary, id);

        try (Connection connection = dbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSalaryByIdQuery)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
