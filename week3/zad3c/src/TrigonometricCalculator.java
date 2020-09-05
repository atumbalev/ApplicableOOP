import java.util.Scanner;

public class TrigonometricCalculator {
    private static int sinTerm = 0;
    private static int cosTerm = 0;

    private static int fact(int number) {
        if (number < 2) {
            return 1;
        }

        return number * fact(number - 1);
    }

    private static double generateNextSinTerm(double x) {
        return (Math.pow(-1, sinTerm++) / fact(2*sinTerm + 1)) * Math.pow(x, 2*sinTerm + 1);
    }

    private static double generateNextCosTerm(double x) {
        return (Math.pow(-1, cosTerm++) / fact(2*cosTerm)) * Math.pow(x, 2*cosTerm);
    }

    public static double approximateSin(double x) {
        double prev = -1;
        double cur = generateNextSinTerm(x);
        double value = 0;
        while (Math.abs(prev) - Math.abs(cur) > 0.001) {
            value += cur;
            prev = cur;
            cur = generateNextSinTerm(x);
        }

        return value;
    }

    public static double approximateCos(double x) {
        double prev = 67;
        double cur = generateNextCosTerm(x);
        double value = 0;
        while (Math.abs(prev) - Math.abs(cur) > 0.001) {
            value += cur;
            prev = cur;
            cur = generateNextCosTerm(x);
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x;
        System.out.print("Enter x for which to be calculated sin(x) and cos(x): ");
        x = scanner.nextDouble();
        System.out.printf("sin(%.2f) is: %f%n", x, approximateSin(x));
        System.out.printf("cos(%.2f) is: %f%n", x, approximateCos(x));

    }
}
