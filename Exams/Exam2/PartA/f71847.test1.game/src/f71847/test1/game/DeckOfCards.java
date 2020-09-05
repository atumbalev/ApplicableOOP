package f71847.test1.game;


import java.util.Random;

public class DeckOfCards {
    private Card[] cards;
    private int currentHand;
    private Card[] hand;

    public DeckOfCards() {
        initializeDeck();
        shuffleCards();
        currentHand = 0;
    }

    private void initializeDeck() {

        cards = new Card[52];

        int cardIndex = 0;
        for (SuitOfCard suit : SuitOfCard.values()) {
            for (FaceOfCard face : FaceOfCard.values()) {
                cards[cardIndex++] = new Card(face, suit);
            }
        }
    }

    void shuffleCards() {
        Random random = new Random();

        int index;
        Card card;
        Card tmp;
        for (int i = cards.length; i > 1; i--) {
            card = cards[i - 1];
            index = random.nextInt(i);
            tmp = cards[index];
            cards[index] =  card;
            cards[i - 1] =  tmp;

        }

        currentHand = 0;
    }

    public void dealFive() {
        Card[] result = new Card[5];

        for (int i = 0; i < 5; i++) {
            if (currentHand < cards.length) {
                result[i] = cards[currentHand];
            } else {
                result[i] = null;
            }
            ++currentHand;
        }

        hand = result;
    }

    public String countHand(Countable choice) {
        return choice.count(hand);
    }

    public Card[] getCards() {
        return cards.clone();
    }

    public int getCurrentHand() {
        return currentHand;
    }

    public Card[] getHand() {
        return hand.clone();
    }

    public void setCards(Card[] cards) {
        this.cards = cards.clone();
    }

    public void setCurrentHand(int currentHand) {
        this.currentHand = currentHand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand.clone();
    }
}
