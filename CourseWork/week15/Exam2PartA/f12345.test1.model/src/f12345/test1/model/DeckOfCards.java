package f12345.test1.model;

import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
    private Card[] cards; // масив от всички карти в тестето от карти
    private int currentCard; // индекс на карта, която може да се тегли
    private Card[] hand; // масив от всички карти в една „ръка“ от карти

    public DeckOfCards() {
        currentCard = 0;
        hand = new Card[7];
        cards = new Card[52];

        int index = 0;
        for (Suits suit : Suits.values()) {
            for (Faces face : Faces.values()) {
                cards[index++] = new Card(face, suit);
            }
        }
        shuffleCards();
    }

    public void shuffleCards() {
        Random random = new Random();
        int randomIndex;
        for (int i = 0; i < cards.length; i++) {
            randomIndex = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }

    public void dealSeven() {
        for (int i = currentCard % 7; i < 7; i++) {
            if (currentCard >= cards.length) {
                hand[i] = null;
            } else {
                hand[i] = cards[currentCard++];
            }
        }
    }

    public String printHand(Printable choice) {
        return choice != null ? choice.printChoice(hand) : "";
    }
}
