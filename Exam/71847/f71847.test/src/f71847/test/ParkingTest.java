package f71847.test;

import f71847.data.Car;
import f71847.data.Parking;

import java.util.Random;

public class ParkingTest {
    public static String generateModel(Random random) {
        int rand = random.nextInt(2);

        if (rand == 0) {
            return "Volvo";
        }
        return "Opel";
    }



    public static void main(String[] args) {
        Car[] cars = new Car[50*6/10];

        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car( String.format("CA %04d", i), generateModel(random),random.nextInt(12) + 1);
        }

        Parking parking = new Parking(cars, "Plovidv");

        System.out.println(parking.toString());

        int[] answ = parking.paymentByMonth();


        System.out.println("Is the average number of cars with abonaments with 1 4 and 8 months is more than those with 5 and 9?");
        if(((answ[1] + answ[4] + answ[8]) / 3) > ((answ[5] + answ[9]) / 2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
