public class RouteCipherTest {
    public static void main(String[] args) {

        RouteCipher routeCipher = new RouteCipher(5);
        String text = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        String result = routeCipher.encrypt(text);
        System.out.printf("Text to be encrypted: %s%n", text);
        System.out.printf("%-30s          %-20s                   %s%n", "The result of the encryption:", "The correct result:", "Do they match:");
        System.out.printf("%-30s     %-20s    %b%n", result, "XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI", result.equals("XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI"));

        System.out.println();
        RouteCipher decryptor = new RouteCipher(-4);
        String crypticText = "TIEIXTXXEAHSIHSPNTLT";
        String decryptedText = decryptor.decrypt(crypticText);
        System.out.printf("Decrypted text: %s%n", decryptedText);
    }
}
