package f71847.test1.game;

public enum SuitOfCard {
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    private final int suitIndex;

    SuitOfCard(int suitIndex) {
        this.suitIndex = suitIndex;
    }

    public int getSuit() {
        return suitIndex;
    }


    @Override
    public String toString() {
        switch (suitIndex){
            case 1: return String.format("Suit of Card: %s","Clubs");
            case 2: return String.format("Suit of Card: %s","Diamonds");
            case 3: return String.format("Suit of Card: %s","Hearts");
            case 4: return String.format("Suit of Card: %s","Spades");
            default: return "No Suit";
        }
    }
}
