public class Cypher {
    private int shiftLength;

    public Cypher() {
        this.shiftLength = 3;
    }

    public Cypher(int shiftLength) {
        setShiftLength(shiftLength);
    }

    public void setShiftLength(int shiftLength) {
        this.shiftLength = this.shiftLength != 0 ? (shiftLength + 26) % 26 : 3;
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public String encrypt(String text) {
        char[] textCharArr = text.toCharArray();
        char[] cypheredTextCharArr = new char[textCharArr.length];

        for (int i = 0; i < textCharArr.length; i++) {
            cypheredTextCharArr[i] = (char) ('a' + (textCharArr[i] - 'a' + shiftLength + 26) % 26);
        }

        return new String(cypheredTextCharArr);
    }

    public String decrypt(String cyphered) {
        char[] cypheredTextCharArr = cyphered.toCharArray();
        char[] decipheredTextCharArr = new char[cypheredTextCharArr.length];

        for (int i = 0; i < cypheredTextCharArr.length; i++) {
            decipheredTextCharArr[i] = (char) ('a' + (cypheredTextCharArr[i] - 'a' - shiftLength + 26) % 26);
        }

        return new String(decipheredTextCharArr);
    }

    @Override
    public String toString() {
        return String.format("CeaserCypher code = %d", shiftLength);
    }

    public static void main(String[] args) {
        String test = "testing";
        String deciphered;

        Cypher cypher = new Cypher(7);
        deciphered = cypher.encrypt(test);

        System.out.println(deciphered);
        System.out.println(cypher.decrypt(deciphered));
    }
}
