import java.util.Arrays;

public class SquareMatrix {
    private int[][] dataArray;

    public SquareMatrix(int[][] dataArray) {
        if (dataArray == null) {
            throw new IllegalArgumentException("Constructor parameter cannot be null");
        }
        setDataArray(dataArray);
    }

    public SquareMatrix() {
        this(new int[0][0]);
    }

    public SquareMatrix(SquareMatrix other) {
        this(other.dataArray);
    }

    public int findMaxSum() {
        int maxSum = 0;
        int currentSum;
        for (int i = 0; i < dataArray.length - 2; i++) {
            for (int j = 0; j < dataArray.length - 2; j++) {
                currentSum = dataArray[i][j] + dataArray[i + 1][j] + dataArray[i][j + 1] + dataArray[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    private void printAllWithSum(int sum) {
        int currentSum;
        for (int i = 0; i < dataArray.length - 2; i++) {
            for (int j = 0; j < dataArray.length - 2; j++) {
                currentSum = dataArray[i][j] + dataArray[i + 1][j] + dataArray[i][j + 1] + dataArray[i + 1][j + 1];
                if (currentSum == sum) {
                    System.out.printf("[%d, %d],%n", i, j);
                }
            }
        }
    }

    public void printAll() {
        printAllWithSum(findMaxSum());
    }

    public void setDataArray(int[][] dataArray) {
        this.dataArray = dataArray.clone();
    }

    public int[][] getDataArray() {
        return dataArray.clone();
    }

    @Override
    public String toString() {
        StringBuilder arrayContents = new StringBuilder();

        for (int[] arr : dataArray) {
            if (arr == null) {
                break;
            }
            arrayContents.append(Arrays.toString(arr)).append('\n');
        }

        return String.format("The content of the array is: %n%s", arrayContents.toString());
    }
}