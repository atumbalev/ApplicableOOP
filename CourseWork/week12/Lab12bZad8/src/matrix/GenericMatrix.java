package matrix;

public abstract class GenericMatrix<E extends Number> {
    protected abstract E add(E element1, E element2);

    protected abstract E multiply(E element1, E element2);

    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        // n x m + n x m = n x m

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new RuntimeException("The size of the matrices must be the same.");
        }

        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }

        return result;
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        // n x m * m x p = n x p

        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("The size of the matrices are not compatible.");
        }

        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        //  0 0 0 0    0 0 0 0 0 0
        //  0 0 0 0    0 0 0 0 0 0
        //  0 0 0 0    0 0 0 0 0 0
        //  0 0 0 0    0 0 0 0 0 0

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
    }

    public static <T> void printResult(T[][] matrix1, T[][] matrix2, T[][] matrix3,
                                   char op) {
        //  0 0 0 0     0 0 0 0 0 0
        //  0 0 0 0     0 0 0 0 0 0
        //  0 0 0 0  +  0 0 0 0 0 0 =
        //  0 0 0 0     0 0 0 0 0 0

        for (int i = 0; i < matrix1.length; i++) {
            printRow(matrix1, i);

            printOperator(matrix1, i, op);

            printRow(matrix2, i);

            printOperator(matrix1, i, '=');

            printRow(matrix3, i);

            System.out.println();
        }
    }

    private static <T> void printRow(T[][] matrix, int rowIndex) {
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(" " + matrix[rowIndex][j]);
        }
    }

    private static <T> void printOperator(T[][] matrix, int rowIndex, char op) {
        if (rowIndex == matrix.length / 2) {
            System.out.print(" " + op + " ");
        } else {
            System.out.print("   ");
        }
    }
}
