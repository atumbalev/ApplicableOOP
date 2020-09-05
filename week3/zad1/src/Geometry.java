import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Geometry extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group, 300, 275);
        double centreX =  scene.getWidth() / 2;
        double centreY = scene.getHeight() / 2;

        double radius = Math.min(scene.getHeight(), scene.getWidth()) / 3;

        Circle circle = new Circle(centreX,centreY,radius);
        circle.setStroke(Color.BLUE);
        circle.setFill(null);
        group.getChildren().add(circle);

        double lineX = promptUser();
        double discriminant = radius * radius  - (centreX - lineX) * (centreX - lineX);

        if(discriminant >= 0) {
            Line line = new Line(lineX,0,lineX,scene.getHeight());
            line.setStroke(Color.RED);
            group.getChildren().add(line);

            double height = Math.sqrt(discriminant);
            double firstCircleY = centreY - height;
            drawCircle(lineX, firstCircleY, group);
            if(discriminant> 0){
                double secondCircleY = centreY + height;
                drawCircle(lineX,secondCircleY, group);
            }
        }else{
            showAlert();
        }

        primaryStage.setTitle("Geometry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double promptUser()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Geometry");
        dialog.setContentText("Enter value for x : ");
        String inputString =  dialog.showAndWait().orElse(" 0");
        return Double.parseDouble(inputString);
    }
    private void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error!");
        alert.setContentText("there is not an intersection between the circle and the line");
        alert.showAndWait();
    }
    private void drawCircle(double x, double y, Group root)
    {
        Circle circle = new Circle(x, y,5);
        Text text = new Text(x + 10 , y , String.format("[%.2f,%.2f]", x, y));
        root.getChildren().addAll(circle, text);
    }
    public static void main(String[] args) {
        launch(args);
    }
}