package stringtoolong;

import java.util.Scanner;

public class StringTooLongExceptionTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        final int MAX_LENGTH_CHARS = 20;

        while (!userInput.equalsIgnoreCase("DONE")) {
            if (userInput.length() >= MAX_LENGTH_CHARS) {
                try {
                    throw new StringTooLongException();
                } catch (StringTooLongException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.printf("You entered: %s\n", userInput);
            userInput = input.nextLine();
        }
    }
}
