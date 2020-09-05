/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.allperm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author echrk
 */
public class AllPermutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        directedPermutations(0, A, result);
        return result;
    }

    private static void directedPermutations(int i, List<Integer> A,
                                                   List<List<Integer>> result) {
        if (i == A.size() - 1) {
            result.add(new ArrayList<>(A));
            return;
        }
// Try every possibility for A[i].
        for (int j = i; j < A.size(); ++j) {
            Collections.swap(A, i, j);
// Generate all permutations for A.subList(i + 1, A.sizeO).
            directedPermutations(i + 1, A, result);
            Collections.swap(A, i, j);
        }
    }
    
    public static void main(String[] args) {
        
            List<List<Integer>> list = permutations(Arrays.asList(2,3,5,7));
            System.out.println(list);
    }

}
