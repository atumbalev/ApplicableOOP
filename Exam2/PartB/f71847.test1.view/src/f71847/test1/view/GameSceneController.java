package f71847.test1.view;

import java.net.URL;
import java.util.ResourceBundle;

import f71847.test1.game.Card;
import f71847.test1.game.Countable;
import f71847.test1.game.DeckOfCards;
import f71847.test1.game.SuitOfCard;
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
    private Button btnHas3Cards;

    @FXML
    private TextArea txfTxfDeal;

    @FXML
    private TextArea txfHas3;

    private DeckOfCards deck;
    int[] countSuits;

    private void countSuits(Card[] hand) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                ++countSuits[hand[i].getSuit().getSuit()];
            }
        }
    }


    @FXML
    void btnDealCardsOnAction(ActionEvent event) {
        deck.dealFive();

        String result = deck.countHand(new Countable() {
            @Override
            public String count(Card[] cards) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < cards.length; i++) {
                    if (cards[i] != null) {
                        result.append(cards[i].toString()).append('\n');
                    } else {
                        result.append("No card delt").append('\n');
                    }
                }

                return result.toString();
            }
        });

        txfTxfDeal.setText(result);
    }


    @FXML
    void btnHas3CardsOnAction(ActionEvent event) {
        String result = deck.countHand(new Countable() {
            @Override
            public String count(Card[] cards) {
                countSuits(deck.getHand());

                for (int i = 1; i < countSuits.length; i++) {
                    if (countSuits[i] > 2) {
                        switch (i){
                            case 1: return String.format("Suit of Card: %s","Clubs");
                            case 2: return String.format("Suit of Card: %s","Diamonds");
                            case 3: return String.format("Suit of Card: %s","Hearts");
                            case 4: return String.format("Suit of Card: %s","Spades");
                            default: return "No such cards";
                        }
                    }

                }
                return "No such cards";
            }
        });

        txfHas3.setText(result);
    }

    @FXML
    void initialize() {
        deck = new DeckOfCards();
        countSuits = new int[5];
    }
}
