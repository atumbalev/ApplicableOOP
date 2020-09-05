/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.allpermarray;

import java.util.Arrays;

/**
 *
 * @author echrk
 */
public class AllPermutationsArray {

    static int count = 0;

    private static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    public static int[][] permutations(int[] A) {
        int[][] result = new int[factorial(A.length)][A.length];
        directedPermutations(0, A, result);
        return result;
    }

    private static void directedPermutations(int i, int[] A,
                                            int[][] result) {
        if (i == A.length - 1) {
            int[] perm = Arrays.copyOf(A, A.length);
            result[count++] = perm;
            return;
        }
// Try every possibility for A[i].
        int temp;
        for (int j = i; j < A.length; ++j) {
            // Collections.swap(A, i, j);
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;

// Generate all permutations for A.subList(i + 1, A.sizeO).
            directedPermutations(i + 1, A, result);
            // Collections.swap(A, i, j);
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

//    public static void main(String[] args) {
//
//       int[][] list = permutations(new int[]{2, 3, 5, 7});
//        for (int[] is : list) {
//            System.out.println(Arrays.toString(is));
//        }
//        
}
