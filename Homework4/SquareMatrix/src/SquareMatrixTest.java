import java.util.Random;

public class SquareMatrixTest {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int size = randomGenerator.nextInt(10) + 2;

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = randomGenerator.nextInt(8);
            }
        }

        SquareMatrix squareMatrixTest = new SquareMatrix(matrix);

        System.out.println(squareMatrixTest.toString());
        System.out.printf("Max sum is: %d%n", squareMatrixTest.findMaxSum());
        squareMatrixTest.printAll();
    }
}
