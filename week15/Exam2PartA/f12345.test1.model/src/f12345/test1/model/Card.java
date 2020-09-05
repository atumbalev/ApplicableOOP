package f12345.test1.model;

public class Card {
    private Faces face;
    private Suits suit;

    public Card(Faces face, Suits suit) {
        setFace(face);
        setSuit(suit);
    }

    public Faces getFace() {
        return face;
    }

    public void setFace(Faces face) {
        this.face = face != null ? face : Faces.ACE;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit != null ? suit : Suits.CLUBS;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", face, suit);
    }
}
