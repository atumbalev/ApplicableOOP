import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Combination {

    private static void makeCombination(ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> currentCombination, int n, int left, int k) {
        if (k == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = left; i <= n; i++) {
            currentCombination.add(i);
            makeCombination(combinations, currentCombination, n, i + 1, k - 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> getAllCombinations(int k, int n) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        makeCombination(combinations, new ArrayList<Integer>(), n, 1, k);
        return combinations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k, n;

        System.out.print("Input k: ");
        k = scanner.nextInt();

        System.out.print("Input n: ");
        n = scanner.nextInt();


        var combinations = getAllCombinations(k, n);

        for (ArrayList<Integer> current : combinations) {
            System.out.println(Arrays.toString(current.toArray()));
        }
    }

}