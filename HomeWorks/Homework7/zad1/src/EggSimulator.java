import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EggSimulator {
    private Random randomGenerator;
    private Set<Integer> obtainedImages;

    private static final int NUMBER_OF_IMAGES = 10;
    private static final  double PRICE_PER_TRY = 0.5;

    public EggSimulator() {
        randomGenerator = new Random();
        obtainedImages = new TreeSet<>();
    }

    private int generateNexImage() {
        return randomGenerator.nextInt(10);
    }

    public double simulatePriceToGetAllImages() {
        int tries = 0;
        obtainedImages.clear();
        while (obtainedImages.size() != NUMBER_OF_IMAGES) {
            obtainedImages.add(generateNexImage());
            ++tries;
        }
        return tries * PRICE_PER_TRY;
    }

    public double simulateAveragePrice(int times) {
        double totalMoneySpend = 0;
        for (int i = 0; i < times; i++) {
            totalMoneySpend += simulatePriceToGetAllImages();
        }

        return totalMoneySpend / times;
    }

    public static void main(String[] args) {
        EggSimulator simulator = new EggSimulator();
        Scanner scanner = new Scanner(System.in);
        int times;

        System.out.print("Input how many times the simulation should be run: ");
        times = scanner.nextInt();

        double averagePrice = simulator.simulateAveragePrice(times);
        System.out.printf("The average price to obtain all images in %d tries is: %f%n", times, averagePrice);
    }
}
