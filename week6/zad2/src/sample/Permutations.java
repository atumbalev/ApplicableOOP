package sample;

import java.util.Arrays;

public class Permutations {

    private static int count;

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int[][] permutations(int[] arr) {
        int[][] result = new int[factorial(arr.length)][arr.length]; // Memory n! * n
        computePermutations(0, arr, result);
        return result;
    }

    private static void computePermutations(int currentIndex, int[] arr, int[][] result) {
        if (currentIndex == arr.length - 1) {
            int[] perm = Arrays.copyOf(arr, arr.length);
            result[count] = perm;
            count++;
            return;
        }

        int temp;
        for (int i = currentIndex; i < arr.length; i++) { //Time n! * n
            temp = arr[currentIndex];
            arr[currentIndex] = arr[i];
            arr[i] = temp;

            computePermutations(currentIndex + 1, arr, result);

            temp = arr[currentIndex];
            arr[currentIndex] = arr[i];
            arr[i] = temp;
        }

    }


}
