/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.allpermarray;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class PermutetJavaFX extends Application {

    private TextArea txaInputArray;
    private Label lblInputArray;
    private TextArea txaResult;
    private Label lblResult;
    private Button btnSort;
    private Button btnQuit;
    private int[] sample;

    private void computePermutations(ActionEvent event) {
        AllPermutationsArray.count = 0;
        String output = "";
        int[][] result = AllPermutationsArray.permutations(sample);
        for (int[] is : result) {
            output += String.format("%s%n", Arrays.toString(is));
        }

        txaResult.setText(output);
    }

    @Override
    public void start(Stage primaryStage) {
        sample = new int[4 ];
        Random r = new Random();
        for (int i = 0; i < sample.length; i++) {
            boolean unique;
            int ch;
            unique = true;
            do {
                ch = r.nextInt(9) + 1;
                for (int j = 0; j < i; j++) {
                    if (sample[j] == ch) {
                        unique = false;
                        break;
                    }
                }
            } while (!unique);
            sample[i] = ch;
        }
        GridPane pane = new GridPane();
        AnchorPane root = new AnchorPane();
        root.getChildren().add(pane);

        txaInputArray = new TextArea();
        txaInputArray.setPrefColumnCount(10);
        txaInputArray.setPrefRowCount(1);
        txaInputArray.setWrapText(true);

        txaInputArray.setText(Arrays.toString(sample));

        txaResult = new TextArea();
        txaResult.setPrefColumnCount(10);
        txaResult.setPrefRowCount(30);
        txaResult.setWrapText(true);
        txaResult.setEditable(false);

        lblInputArray = new Label("Array:");
        lblResult = new Label("The permutations:");
        btnQuit = new Button("Quit");
        btnQuit.setOnAction((event) -> Platform.exit());
        btnSort = new Button("Compute permutations");
        btnSort.setOnAction(this::computePermutations);

        pane.setHgap(8);
        pane.setVgap(8);

        AnchorPane.setTopAnchor(pane, 8.0);
        AnchorPane.setLeftAnchor(pane, 8.0);
        AnchorPane.setBottomAnchor(pane, 8.0);
        AnchorPane.setRightAnchor(pane, 8.0);
        pane.add(lblInputArray, 0, 0); // column=0 row=0
        pane.add(txaInputArray, 1, 0); // column=1 row=0

        pane.add(lblResult, 0, 2);
        pane.add(txaResult, 1, 2);
        pane.add(btnSort, 0, 3);
        pane.add(btnQuit, 1, 3);

        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Permutations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
