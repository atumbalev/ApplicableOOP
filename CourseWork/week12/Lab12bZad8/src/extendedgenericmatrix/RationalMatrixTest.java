package extendedgenericmatrix;

public class RationalMatrixTest {
    public static void main(String[] args) {
        Rational[][] matrix1 = new Rational[3][3];
        Rational[][] matrix2 = new Rational[3][3];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = new Rational(i + 1, j + 5);
                matrix2[i][j] = new Rational(i + 1, j + 6);
            }
        }

        RationalMatrix rationalMatrix = new RationalMatrix();

        System.out.println("matrix1 + matrix2 is:");
        Object[][] addResult = rationalMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, addResult, '+');

        System.out.println("matrix1 * matrix2 is:");
        Object[][] multiResult = rationalMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, multiResult, '*');
    }
}
