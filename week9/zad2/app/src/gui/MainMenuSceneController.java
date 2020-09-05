package gui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainMenuSceneController {

    @FXML
    private BorderPane bpContent;

    @FXML
    private Menu mnuFile;

    @FXML
    private MenuItem mniClose;

    @FXML
    private Menu mnuOperations;

    @FXML
    private MenuItem mniSceneOne;

    @FXML
    private MenuItem mniSceneTwo;

    @FXML
    private Menu mnuHelp;

    @FXML
    private MenuItem mniAbout;

    @FXML
    void mniAboutOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("This is a sample JAVAFX Modular Application");
        alert.setContentText(
                "Demonstrates the creation of multiple modules, switching Stage and Scene content from multiple scenes, as well as using Stylesheets.");

        alert.showAndWait();
    }

    @FXML
    void mniCloseOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void mniSceneOneOnAction(ActionEvent event) {
        loadContent("LoadOne.fxml");
    }

    @FXML
    void mniSceneTwoOnAction(ActionEvent event) {
        loadContent("LoadTwo.fxml");
    }

    private void loadContent(String fxmlFileName) {
        FXMLLoader loader = new FXMLLoader();
        VBox root = null;
        try {
            loader.setLocation(getClass().getResource(fxmlFileName));
            root = (VBox) loader.load(getClass()
                    .getResource(fxmlFileName)
                    .openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        bpContent.setCenter(root);
    }

}
