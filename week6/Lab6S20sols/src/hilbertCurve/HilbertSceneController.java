package hilbertCurve;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class HilbertSceneController {
    private int order = 1; // Order of the Hilbert curve
    private HilbertCurvePane hc;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEnterOrder;
    @FXML
    private Button btnEnter;

    @FXML
    private Pane drwPane;

    @FXML
    void btnEnterOnAction(ActionEvent event) {
        order = Integer.parseInt(txtEnterOrder.getText());
        hc.setOrder(order);
        hc.paint();
    }

    @FXML
    void initialize() {
        hc =  HilbertCurvePane.makePane(drwPane);
        // redraw Hilbert on scene resize
        drwPane.widthProperty().addListener(ov -> hc.paint());
        drwPane.heightProperty().addListener(ov -> hc.paint());
        assert btnEnter != null : "fx:id=\"btnEnter\" was not injected: check your FXML file 'HilbertScene.fxml'.";
        assert drwPane != null : "fx:id=\"drwPane\" was not injected: check your FXML file 'HilbertScene.fxml'.";

    }
}
