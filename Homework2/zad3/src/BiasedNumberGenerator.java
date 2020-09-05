import java.util.Random;

public class BiasedNumberGenerator {

    private static int[] sampleSpace;
    private static Random gen;

    public BiasedNumberGenerator() {
        gen = new Random();
        sampleSpace = new int[100];

        // P(1) = 0.2 => 20 of the 100 spaces in the sample space must be 1s
        for (int i = 0; i < 20; ++i) {
            sampleSpace[i] = 1;
        }

        // P(2) = 0.3 => 30 of the 100 spaces in the sample space must be 2s
        for (int i = 20; i < 50; ++i) {
            sampleSpace[i] = 2;
        }

        // P(3) = 0.5 => 50 of the 100 spaces in the sample space must be 3s
        for (int i = 50; i < 100; ++i) {
            sampleSpace[i] = 3;
        }
    }

    public int generate() {
        return sampleSpace[gen.nextInt(100)];
    }

    public static void main(String[] args) {
        int onesFrequency = 0;
        int twosFrequency = 0;
        int treesFrequency = 0;

        BiasedNumberGenerator generator = new BiasedNumberGenerator();

        for (int i = 0; i < 6_000; ++i) {
            switch (generator.generate()) {
                case 3 :
                    ++treesFrequency;
                    break;
                case 2 :
                    ++twosFrequency;
                    break;
                case 1 :
                    ++onesFrequency;
                    break;
                default:
                    System.out.println("Impossible");
            }
        }

        System.out.printf("Ones generated: %f times%n", onesFrequency / 6_000f);
        System.out.printf("Twos generated: %f times%n", twosFrequency / 6_000f);
        System.out.printf("Trees generated: %f times%n", treesFrequency / 6_000f);
    }
}
