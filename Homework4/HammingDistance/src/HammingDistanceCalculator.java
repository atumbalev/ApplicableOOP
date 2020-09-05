public class HammingDistanceCalculator {

    // We calculate the hamming distance without doing unnecessary I/O operations
    // Thus making the actual finding of the hamming distance faster for users that dont care about the explanation
    public static int findHammingDistance(int firstNumber, int secondNumber) {
        int difference = firstNumber ^ secondNumber;

        int hammingDistance = 0;
        while (difference != 0) {
            if ((difference & 1) != 0) {
                ++hammingDistance;
            }
            difference = difference >> 1;
        }

        return hammingDistance;
    }

    private static String printInBinary(int number) {
        return Integer.toBinaryString(number);
    }

    // Its not vital for the explanation code to be as fast so it's ok to do  another XoR operation, which is fast anyway
    public static void explainHammingDistance(int firstNumber, int secondNumber) {
        int hammingDistance = findHammingDistance(firstNumber, secondNumber);
        System.out.println("We can find the differently set bits by XoR-ing the 2 number:");
        System.out.printf("%s ^ %s = %s%n", printInBinary(firstNumber), printInBinary(secondNumber), printInBinary(firstNumber ^ secondNumber));
        System.out.println("Then we iterate over the difference and count all the bits set to 1");
        System.out.printf("And so the hamming distance between %s and %s is: %d", printInBinary(firstNumber), printInBinary(secondNumber), hammingDistance);
    }

    public static void main(String[] args) {
        explainHammingDistance(10, 15);
    }
}
