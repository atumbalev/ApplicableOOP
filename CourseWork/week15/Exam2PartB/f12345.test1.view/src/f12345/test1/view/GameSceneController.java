package f12345.test1.view;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import f12345.test1.model.Card;
import f12345.test1.model.DeckOfCards;
import f12345.test1.model.Faces;
import f12345.test1.model.Printable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDealCards;

    @FXML
    private TextArea txaDealCards;

    @FXML
    private Button btnHasSameFace;

    @FXML
    private TextArea txaHasSameFace;

    private DeckOfCards deck; // реферира обект от DeckOfCards
    private int[] countFaces; // масив от броячи на сили на карти в една ръка

    @FXML
    void OnBtnDealCardsAction(ActionEvent event) {
        deck.dealSeven();
        String result = deck.printHand(new Printable() {
            @Override
            public String printChoice(Card[] hand) {
                if (hand == null) {
                    return "";
                }

                StringBuilder sb = new StringBuilder();
                for (Card handCard : hand) {
                    if (handCard != null) {
                        sb.append(handCard).append("\n");
                    }
                }
                return sb.toString();
            }
        });
        txaDealCards.setText(result);
    }

    @FXML
    void onBtnHasSameFaceAction(ActionEvent event) {
        String result = deck.printHand(new Printable() {
            @Override
            public String printChoice(Card[] hand) {
                countHand(hand);
                StringBuilder sb = new StringBuilder();
                Faces[] allFaces = Faces.values();
                for (int i = 0; i < countFaces.length; i++) {
                    if (countFaces[i] == 2) {
                        sb.append(allFaces[i]).append("\n");
                    }
                }

                if (sb.toString().isEmpty()) {
                    sb.append("No such cards");
                }
                return sb.toString();
            }
        });
        txaHasSameFace.setText(result);
    }

    @FXML
    void initialize() {
        assert btnDealCards != null : "fx:id=\"btnDealCards\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert txaDealCards != null : "fx:id=\"txaDealCards\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert btnHasSameFace != null : "fx:id=\"btnHasSameFace\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert txaHasSameFace != null : "fx:id=\"txaHasSameFace\" was not injected: check your FXML file 'GameScene.fxml'.";

        deck = new DeckOfCards();
        countFaces = new int[13];
    }

    private void countHand(Card[] hand) {
        if (hand == null || hand.length == 0) {
            return;
        }

        countFaces = new int[13];
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                countFaces[findFaceIndex(hand[i].getFace())]++;
            }
        }
    }

    private int findFaceIndex(Faces face) {
        Faces[] allFaces = Faces.values();

        for (int i = 0; i < allFaces.length; i++) {
            if (allFaces[i].equals(face)) {
                return i;
            }
        }
        return -1;
    }
}
