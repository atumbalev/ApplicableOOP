package partb;

import javafx.application.Platform;
import parta.Circle;
import parta.Cylinder;

import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class GeometricMeasurementsController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnEnd;

    @FXML
    private TextArea txaGen;

    @FXML
    private TextArea txaSort;

    private Random rand;
    private Circle[] measurables;
    private int index;


    public void sort() {
        for (int i = 1; i < index; ++i) {
            Circle key = measurables[i];
            int j = i - 1;

            while (j >= 0 && measurables[j].computeMeasure() < key.computeMeasure()) {
                measurables[j + 1] = measurables[j];
                j = j - 1;
            }
            measurables[j + 1] = key;
        }
    }

    @FXML
    void btnEndOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {
        if (rand.nextBoolean()) {
            measurables[index] = new Circle(rand.nextInt(10));
        } else {
            measurables[index] = new Cylinder(rand.nextInt(10), rand.nextInt(10));
        }

        if (index < measurables.length) {
            ++index;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < index; i++) {
            result.append(measurables[i].toString()).append(String.format("Compute measure: %f", measurables[i].computeMeasure())).append('\n');
        }

        txaGen.setText(result.toString());

    }

    @FXML
    void btnSortOnAction(ActionEvent event) {
        sort();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < index; i++) {
            result.append(measurables[i].toString()).append(String.format("Compute measure: %f", measurables[i].computeMeasure())).append('\n');
        }

        txaSort.setText(result.toString());
    }


    @FXML
    void initialize() {
        rand = new Random();

        int size = 5 + rand.nextInt(15);

        measurables = new Circle[size];
    }
}
