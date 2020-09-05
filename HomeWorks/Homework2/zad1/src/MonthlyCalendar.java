import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class MonthlyCalendar extends Application {
    private int month;
    private int year;

    private static void showError(String msg) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Monthly Calendar");
        error.setHeaderText(msg);
        error.setContentText(null);
        error.showAndWait();
        Platform.exit();
    }

    private int getDaysOfMonth() {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    }

    private int getDayOfWeek() {
        LocalDate data = LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        return dayOfWeek.getValue();
    }

    private String getMonthName(int monthNumber) {
        String[] months = new DateFormatSymbols().getMonths();
        int n = monthNumber-1;
        return (n >= 0 && n <= 11) ? months[n] : "wrong number";
    }

    public void prompt() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Monthly Calendar");
        inputDialog.setContentText("Enter a date in the format MM/YYYY");
        String response = inputDialog.showAndWait().get();

        String tokens[] = response.split("/");

        if (tokens.length != 2) {
            showError("Invalid date format");
        }

        month = Integer.parseInt(tokens[0]);
        year = Integer.parseInt(tokens[1]);

        if(month > 12 || month < 1) {
            showError("Invalid month");
        }


    }

    private Label createLabel(String text){
        Label l = new Label(text);
        l.setAlignment(Pos.CENTER);
        l.setMaxHeight(100);
        l.setMaxWidth(100);
        return l;
    }

    public void drawCalendar(Group group) {
        GridPane gridPane = new GridPane();

        final int numCols = 7;
        final double squares = getDayOfWeek() + getDaysOfMonth() - 1;
        final int numRows = (int) Math.ceil(squares / numCols);
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            gridPane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i <= numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            gridPane.getRowConstraints().add(rowConst);
        }

        gridPane.add(createLabel("MON"), 0, 0);
        gridPane.add(createLabel("TUE"), 1, 0);
        gridPane.add(createLabel("WED"), 2, 0);
        gridPane.add(createLabel("THR"), 3, 0);
        gridPane.add(createLabel("FRI"), 4, 0);
        gridPane.add(createLabel("SAT"), 5, 0);
        gridPane.add(createLabel("SUN"), 6, 0);

        LocalDate data = LocalDate.now();
        int nowYear = data.getYear();
        int nowMonth = data.getMonthValue();

        int nowDay = -1;
        if(nowMonth == month && nowYear == year){
            nowDay = data.getDayOfMonth();
        }

        int column = getDayOfWeek() - 1;
        int row = 1;
        for(int i = 1; i <= getDaysOfMonth(); i++){
            Label l = createLabel(String.valueOf(i));
            if(nowDay == i) l.setTextFill(Color.RED);
            gridPane.add(l, column, row);
            column++;
            if(column > 6){
                row++;
                column = 0;
            }
        }

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        group.getChildren().add(gridPane);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        prompt();
        drawCalendar(group);

        primaryStage.setScene(new Scene(group, 300, 200));
        primaryStage.setTitle(String.format("Calendar for %s %d", getMonthName(month), year));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}