package reversebits;

import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        String reverseBits;
        String straihgtBits;
        short inputNumber;
        Scanner reader = new Scanner(System.in);

        reverseBits = ""; // init ...
        straihgtBits = "";
        System.out.print("Enter an integer number: " );
        inputNumber= reader.nextShort();
        // compute the bits in data type Short for exercise only
        int bitsInNumber = (int)(Math.log(Short.MAX_VALUE) / Math.log(2) + 2);
        // Expected  bitsInNumber = 16 for short data type
        System.out.println( bitsInNumber);
        System.out.println( Short.MAX_VALUE);
        // reverse the bits
        int mask = 1 << (bitsInNumber-1); // create the mask 1000...000
        // get the bits

        for (int i = 0; i < bitsInNumber; i++) {
            String s = (inputNumber & mask) == 0 ? "0" : "1";
            straihgtBits = s + straihgtBits; // reverse bits
            reverseBits += s;// straight bits
            inputNumber <<= 1; // shift the bits
        }
        // Test output
        System.out.println("Reverse bits: " + reverseBits);
        System.out.println("Straight bits: " + straihgtBits);
    }
}
