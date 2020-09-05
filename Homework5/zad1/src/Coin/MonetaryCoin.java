package Coin;

public class MonetaryCoin  extends Coin {
    private int faceValue;

    public MonetaryCoin(Face face, int faceValue) {
        super(face);
        this.faceValue = faceValue;
    }

    public MonetaryCoin(int faceValue) {
        this(Face.HEAD, faceValue);
    }

    public MonetaryCoin() {
        this(Face.HEAD, 5);
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return String.format("The face value of the coin is %d ", faceValue) + super.toString();
    }
}
