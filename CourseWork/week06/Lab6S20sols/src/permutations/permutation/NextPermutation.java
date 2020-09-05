/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.permutation;

import java.util.Arrays;

/**
 *
 * @author echrk
 */
public class NextPermutation {

    private static void reverseSubArray(int[] data, int a, int b) {
        if (a > b || a >= data.length || b >= data.length) {
            return;
        }
        int i = a;
        int j = b;
        while (i < j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] nextPermutation(int[] perm) {
        int k = perm.length - 2;
        while (k >= 0 && perm[k] >= perm[k + 1]) {
            --k;
        }
        if (k == -1) {
            return new int[0]; // perm is the last permutation.
        }
// Swap the smallest entry after index k that is greater than perm[k] . We
// exploit the fact that perm .subList (k + 1, perm.sizeO) is decreasing so
// if we search in reverse order, the first entry that is greater than
// perm[k ] is the smallest such entry.
        for (int i = perm.length - 1; i > k; --i) {
            if (perm[i] > perm[k]) {
                int temp = perm[k];
                perm[k] = perm[i];
                perm[i] = temp;
                break;
            }
        }
// Since perm . subList[k + 1, perm.size()) is in decreasing order, we can
// build the smallest dictionary ordering of this subarray by reversing it.
        reverseSubArray(perm, k + 1, perm.length);
        return perm;
    }

    
    public static void main(String[] args) {
        int[] data = {6,2,1, 5, 4,3,0};
        System.out.println(Arrays.toString(nextPermutation(data)));
        
    }
}
