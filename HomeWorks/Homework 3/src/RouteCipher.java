import java.util.Arrays;

public class RouteCipher {
    private int key;
    private int rowSize;
    private int columnSize;

    public RouteCipher(int key) {
        setKey(key);
    }

    private static String readTopLeft(int xStart, int xEnd, int yStart, int yEnd, char[][] stringRoute) {
        StringBuilder result = new StringBuilder();

        for (int x = xStart; x <= xEnd ; x++) {
            result.append(stringRoute[x][yStart]);
        }

        for (int y = yStart + 1; y <= yEnd; y++) {
            result.append(stringRoute[xEnd][y]);
        }

        //are there any remaining layers
        if (yEnd - yStart > 0) {
           result.append(readBottomRight(xStart, xEnd - 1, yStart + 1, yEnd, stringRoute));
        }

        return result.toString();
    }

    public static String readBottomRight(int xStart, int xEnd, int yStart, int yEnd, char[][] stringRoute) {
        StringBuilder result = new StringBuilder();

        for (int x = xEnd; x >= xStart; x--) {
            result.append(stringRoute[x][yEnd]);
        }

        for (int y = yEnd - 1; y >= yStart; y--) {
            result.append(stringRoute[xStart][y]);
        }

        //are there any remaining layers
        if (yEnd - yStart > 0) {
            result.append(readTopLeft(xStart + 1, xEnd, yStart, yEnd - 1, stringRoute));
        }

        return result.toString();
    }

    private static void writeTopLeft(int xStart, int xEnd, int yStart, int yEnd, char[][] stringRoute, char[] string, int index) {
        for (int x = xStart; x <= xEnd ; x++) {
            stringRoute[x][yStart] = string[index++];
        }

        for (int y = yStart + 1; y <= yEnd; y++) {
            stringRoute[xEnd][y] = string[index++];
        }

        //are there any remaining layers
        if (yEnd - yStart > 0) {
            writeBottomRight(xStart, xEnd - 1, yStart + 1, yEnd, stringRoute, string, index);
        }
    }

    public static void writeBottomRight(int xStart, int xEnd, int yStart, int yEnd, char[][] stringRoute, char[] string, int index) {

        for (int x = xEnd; x >= xStart; x--) {
            stringRoute[x][yEnd] = string[index++];
        }

        for (int y = yEnd - 1; y >= yStart; y--) {
            stringRoute[xStart][y] = string[index++];
        }

        //are there any remaining layers
        if (yEnd - yStart > 0) {
            writeTopLeft(xStart + 1, xEnd, yStart, yEnd - 1, stringRoute, string, index);
        }
    }

    private char[][] createRoute(String plainText) {
        String text = stripPunctuation(plainText);

        columnSize =  Math.abs(key);
        rowSize = text.length() / columnSize;
        rowSize += text.length() % columnSize != 0 ? 1 : 0;



        return new char[rowSize][columnSize];
    }

    private char[][] writeRoute(String plaintText, char[][] stringRoute) {
        String text = stripPunctuation(plaintText);


        // if there string length isn't a multiple of the key fill the remaining spaces with 'X'
        if (text.length() % columnSize != 0) {
            int to = columnSize - (text.length() % columnSize);
            for (int i = 0; i < to; i++) {
                text += 'X';
            }
        }

        char[] textCharArray = text.toCharArray();

        for (int i = 0; i < rowSize; i++) {
            stringRoute[i] = Arrays.copyOfRange(textCharArray,i * columnSize, (i + 1) * columnSize);
        }

        return stringRoute;
    }

    private String stripPunctuation(String original) {
        char[] stripped = new char[original.length()];
        char[] originalCharArray = original.toCharArray();

        int read = 0;
        for (int i = 0; i < original.length(); i++) {
            if (originalCharArray[i] >= 'A' && originalCharArray[i] <= 'z') {
                stripped[read++] = originalCharArray[i];
            }
        }

        return new String(stripped, 0, read);
    }

    public String encrypt(String plainText) {
        char[][] route = writeRoute(plainText, createRoute(plainText));
        if (key < 0) {
            return readTopLeft(0, rowSize - 1, 0, columnSize - 1, route);
        }

        return readBottomRight(0, rowSize -1, 0, columnSize -1, route);
    }

    public String decrypt(String cypheredText) {
        char[][] route = createRoute(cypheredText);

        if (key < 0) {
            writeTopLeft(0, rowSize - 1, 0, columnSize - 1, route, cypheredText.toCharArray(), 0);
        } else {
            writeBottomRight(0, rowSize - 1, 0, columnSize - 1, route, cypheredText.toCharArray(), 0);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < rowSize; i++) {
            result.append(route[i]);
        }

        char[] res = result.toString().toCharArray();

        int index = res.length - 1;

        while(res[index -1] == 'X') {
            --index;
        }

        return new String(res, 0 ,index);
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
