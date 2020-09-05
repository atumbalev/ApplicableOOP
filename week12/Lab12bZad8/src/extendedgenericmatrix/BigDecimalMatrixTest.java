package extendedgenericmatrix;

import java.math.BigDecimal;

public class BigDecimalMatrixTest {
    public static void main(String[] args) {
        BigDecimal[][] matrix1 = new BigDecimal[3][3];
        BigDecimal[][] matrix2 = new BigDecimal[3][3];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j  < matrix1[0].length; j++) {
                matrix1[i][j] = BigDecimal.valueOf((i + 1.0) / (j + 5) * 2);
                matrix2[i][j] = BigDecimal.valueOf((i + 2.0) / (j + 6) * 2);
            }
        }

        BigDecimalMatrix bigDecimalMatrix = new BigDecimalMatrix();

        System.out.println("matrix1 + matrix2 is:");
        Object[][] addResult = bigDecimalMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, addResult, '+');

        System.out.println("matrix1 * matrix2 is:");
        Object[][] multiResult = bigDecimalMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, multiResult, '*');
    }
}
