package extendedgenericmatrix;

public class ComplexMatrixTest {
    public static void main(String[] args) {
        Complex[][] matrix1 = new Complex[3][3];
        Complex[][] matrix2 = new Complex[3][3];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = new Complex(i + 1, j + 5);
                matrix2[i][j] = new Complex(i + 1, j + 6);
            }
        }

        ComplexMatrix complexMatrix = new ComplexMatrix();

        System.out.println("matrix1 + matrix2 is:");
        Object[][] addResult = complexMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, addResult, '+');

        System.out.println("matrix1 * matrix2 is:");
        Object[][] multiResult = complexMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, multiResult, '*');
    }
}
