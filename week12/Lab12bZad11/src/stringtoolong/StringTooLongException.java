package stringtoolong;

public class StringTooLongException extends Exception {

    public StringTooLongException(String message) {
        super(message);
    }

    public StringTooLongException() {
        this("This string too long!");
    }
}
