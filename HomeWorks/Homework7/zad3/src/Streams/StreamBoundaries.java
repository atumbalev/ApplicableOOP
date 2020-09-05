package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBoundaries {
    public static String generateNumbersFrom1to100() {
        return Stream.iterate(1, i -> i + 1).limit(100).map(Object::toString).reduce((i, j) -> i + " # " + j).orElse("Error");

    }

    public static List<Integer> generate20RandomInts() {
        Random random = new Random();
        return random.ints(20, 0, 30).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(generateNumbersFrom1to100());

        List<Integer> randomInts = generate20RandomInts();
        System.out.println(randomInts);
        boolean anyDivisibleBy5 = randomInts.stream().anyMatch(i -> i % 5 == 0);
        boolean allLessThan15 = randomInts.stream().allMatch( i -> i < 15);

        double average = randomInts.stream().mapToInt(Integer::intValue).average().orElseThrow();
        boolean areThereMoreThan5NumbersLargerThanTheMean = randomInts.stream().filter(i -> i > average).count() > 5;
    }
}
