package zad4;

import java.util.Scanner;

public class GeneReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.print("Enter four digit number a number");
        number = scanner.nextInt();

        for (int i = 0; i < 4; ++i) {
            switch (number % 10) {
                case 0:
                    System.out.print("A");
                    break;
                case 1:
                    System.out.print("C");
                    break;
                case 2:
                    System.out.print("G");
                    break;
                case 3:
                    System.out.print("T");
                    break;
                default:
                    System.out.println("The input number's digits must be int he range [0, 3]!");
                    return;
            }
            number /= 10;
        }
    }
}
