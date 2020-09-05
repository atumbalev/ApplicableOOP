package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    private List<Integer> numbers;
    private boolean sortOrder; // sortOrder = true - ascending

    public QuickSort(int size, boolean sortOrder) {
        this.numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            this.numbers.add(random.nextInt(90) + 10);
        }
        this.sortOrder = sortOrder;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean isSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<Integer> quickSort() {
        return quickSortHelper(this.numbers);
    }

    private List<Integer> quickSortHelper(List<Integer> numbers) {
        // 9 7 8 2 4 6 5 9 2 4 5
        // -
        if (numbers.size() < 2) {
            // 9
            return numbers;
        }

        Integer pivot = numbers.get(0);

        //        <   9 >=

        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));
            }
        }

        List<Integer> sorted = new ArrayList<>();

        if (sortOrder) {
            // ascending
            sorted.addAll(quickSortHelper(lower));
            sorted.add(pivot);
            sorted.addAll(quickSortHelper(higher));
        } else {
            // descending
            sorted.addAll(quickSortHelper(higher));
            sorted.add(pivot);
            sorted.addAll(quickSortHelper(lower));
        }

        return sorted;
    }

    @Override
    public String toString() {
        return numbers.toString(); // [ 1, 2, 3 ]
    }
}
