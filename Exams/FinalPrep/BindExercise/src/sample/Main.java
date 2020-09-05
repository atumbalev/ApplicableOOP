package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        /*
        IntegerProperty int1 = new SimpleIntegerProperty(5);
        IntegerProperty int2 = new SimpleIntegerProperty(16);

        int2.bind(int1);

        System.out.println(int1);
        System.out.println(int2.get());
        */

        /*
        IntegerProperty int1 = new SimpleIntegerProperty(5);
        IntegerProperty int2 = new SimpleIntegerProperty(16);

        int2.bindBidirectional(int1);
        int2.set(15);

        System.out.println(int1.get());
        System.out.println(int2.get());
        */
    }
}
