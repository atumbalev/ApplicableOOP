package zad5;

public class CharToInt {
    public static void printNumericEquivalent(char character) {
        System.out.printf("The numeric equivalent of %c is %d%n", character, (int) character);
    }

    public static void main(String[] args) {
        printNumericEquivalent('A');
        printNumericEquivalent('B');
        printNumericEquivalent('C');
        printNumericEquivalent('a');
        printNumericEquivalent('b');
        printNumericEquivalent('c');
        printNumericEquivalent('0');
        printNumericEquivalent('1');
        printNumericEquivalent('2');
        printNumericEquivalent('$');
        printNumericEquivalent('*');
        printNumericEquivalent('+');
        printNumericEquivalent('/');
        printNumericEquivalent(' ');
    }
}
