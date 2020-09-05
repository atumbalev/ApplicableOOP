package sample;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

    private int[] array;

    public CountingSort(int arraySize) {
        array = new int[arraySize];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = 10 + random.nextInt(90);
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] sort(boolean sortOrder) {
        int max = findMax();
        int[] countingArr = new int[max + 1];
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            countingArr[array[i]]++;
        }

        if (sortOrder) {
            for (int i = 1; i < max + 1; i++) {
                countingArr[i] += countingArr[i - 1];
            }
        } else {
            for (int i = max - 1; i >= 0; i--) {
                countingArr[i] += countingArr[i + 1];
            }
        }

        for (int i = 0; i < array.length; i++) {
            result[countingArr[array[i]] - 1] = array[i];
            countingArr[array[i]] = countingArr[array[i]] - 1;
        }

        return result;
    }

    private int findMax() {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i != array.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
