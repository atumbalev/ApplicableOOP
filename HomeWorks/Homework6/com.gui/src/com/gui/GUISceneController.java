package com.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.providers.CipherGenerator;
import com.providers.Result;
import com.providers.Wrapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GUISceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txbSeed;

    @FXML
    private TextField txbSize;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRndSubset;

    @FXML
    private Button btnRnd;

    private static final String SEED_DEFAULT_MESSAGE = "Enter the seed";
    private static final String SIZE_DEFAULT_MESSAGE = "Enter the size";


    private int seed;
    private int size;

    private void parseData() {

        try {
            seed = Integer.parseInt(txbSeed.getText());
            size = Integer.parseInt(txbSize.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Invalid input data");
            alert.setHeaderText("Invalid Number format");
            alert.show();

            txbSeed.setText(SEED_DEFAULT_MESSAGE);
            txbSize.setText(SIZE_DEFAULT_MESSAGE);

            parseData();
        }

    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRndOnAction(ActionEvent event) {
        parseData();

        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedSelection(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Generate random sequence");
        alert.setHeaderText(String.format("Count distinct characters out of %d", size));
        alert.setContentText(result.toString());

        alert.show();
    }

    @FXML
    void btnRndSubsetOnAction(ActionEvent event) {
        parseData();

        Wrapper wrapper = new Wrapper(size);
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedRandom(), seed);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Generate random subsequence");
        alert.setHeaderText(String.format("Count distinct characters out of %d", size));
        alert.setContentText(result.toString());

        alert.show();
    }

    @FXML
    public void initialize() {
        txbSeed.setText(SEED_DEFAULT_MESSAGE);
        txbSize.setText(SIZE_DEFAULT_MESSAGE);
    }
}
