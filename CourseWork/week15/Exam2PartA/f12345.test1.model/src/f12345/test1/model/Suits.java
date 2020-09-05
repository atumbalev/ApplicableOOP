package f12345.test1.model;

public enum Suits {
    CLUBS("Clubs"),DIAMONDS("Diamonds"),HEARTS("Hearts"),SPADES("Spades");

    private final String suit;

    Suits(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}
