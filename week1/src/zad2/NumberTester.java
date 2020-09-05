package zad2;

import java.util.Scanner;

public class NumberTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int originalNumber;
        String resultString;


        System.out.print("Input a five-digit number:");
        originalNumber = scanner.nextInt();
        if(originalNumber < 10_000 || originalNumber > 99_999)
        {
            System.out.println("Enter a valid number!");
            return;
        }

        if(originalNumber % 10 == originalNumber / 10_000 % 10 && originalNumber / 10 % 10 == originalNumber / 1000 % 10 )
        {
            resultString = "The number is palindrome!";
        }
        else {
            resultString = "The number is not a palindrome!";
        }

        System.out.println(resultString);
    }
}
