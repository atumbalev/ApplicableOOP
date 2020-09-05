package matrix;

public class IntegerMatrixTest {
    public static void main(String[] args) {
        Integer[][] matrix1 = new Integer[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        Integer[][] matrix2 = new Integer[][]{{1,1,1}, {2,2,2}, {0,0,0}};

        IntegerMatrix integerMatrix = new IntegerMatrix();

        System.out.println("matrix1 + matrix2 is:");
        Number[][] addResult = integerMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, addResult, '+');

        System.out.println("matrix1 * matrix2 is:");
        Number[][] multiResult = integerMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, multiResult, '*');
    }
}
