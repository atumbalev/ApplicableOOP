/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author echrk
 */
public class Combiner {
  static int c = 0;
    public static ArrayList<ArrayList<Integer>> combinations(int numberOfElements, int subsetSize) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combine(numberOfElements, subsetSize, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combine(int numberOfElements, int subsetSize,
            int offset,
            ArrayList<Integer> partialCombination,
            ArrayList<ArrayList<Integer>> result) 
    {
        System.out.println("C:   " + (++c));
        if (partialCombination.size() == subsetSize) {
            System.out.println("R: " +partialCombination);
            result.add(new ArrayList<>(partialCombination));
            return;
        }
// Generate remaining combinations over {offset , ..., numberOfElements - 1} of size
// numRemaining.
        final int numRemaining = subsetSize - partialCombination.size();
        for (int i = offset; i <= numberOfElements && numRemaining <= numberOfElements - i + 1; ++i) {
            partialCombination.add(i);
            System.out.println("P: " +partialCombination);
            combine(numberOfElements, subsetSize, i + 1, partialCombination, result);
            partialCombination.remove(partialCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = combinations(4, 3);
        System.out.println(result);
    }
}
