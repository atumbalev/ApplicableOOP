package cards;

public class Card {
    private FaceOfCard face;
    private SuitOfCard suit;

    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    public void setFace(FaceOfCard face) {
        this.face = face == null ? FaceOfCard.ACE : face;
    }

    public void setSuit(SuitOfCard suit) {
        this.suit = suit == null ? SuitOfCard.SPADES : suit;
    }

    public FaceOfCard getFace() {
        return face;
    }

    public SuitOfCard getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", face.getFace(), suit.getSuit());
    }
}
