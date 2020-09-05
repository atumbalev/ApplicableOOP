package zad1;

import java.util.Scanner;

public class TemperatureConverter {

    Scanner scanner = new Scanner(System.in);
    double temperatureInCelsius;
    double temperatureInFahrenheit;

    private static double fahrenheitToCelsius(double temperateInFahrenheit) {
        return 5.0 / 9.0 * (temperateInFahrenheit - 32);
    }

    private static double celsiusToFahrenheit(double temperatureInCelsius) {
        return 9.0 / 5.0 * temperatureInCelsius + 32;
    }

    public void fahrenheitToCelsiusPrompt() {
        System.out.print("Input temperature in Fahrenheit: ");
        temperatureInFahrenheit = scanner.nextDouble();
        temperatureInCelsius = fahrenheitToCelsius(temperatureInFahrenheit);
        System.out.printf("The temperature in Celsius is: %f%n", temperatureInCelsius);
    }

    public void celsiusToFahrenheitPrompt() {
        System.out.print("Input temperature in Celsius: ");
        temperatureInCelsius = scanner.nextDouble();
        temperatureInFahrenheit = celsiusToFahrenheit(temperatureInCelsius);
        System.out.printf("The temperature in Fahrenheit is: %f%n", temperatureInFahrenheit);
    }

    public void prompt() {
        System.out.print("Enter f for fahrenheit or c for celsius ");
        String response = scanner.nextLine();
        switch (response) {
            case "f":
            case "F":
                fahrenheitToCelsiusPrompt();
                break;

            case "c":
            case "C":
                celsiusToFahrenheitPrompt();
                break;

            default:
                System.out.println("Invalid entry, try again!");
                prompt();
        }
    }

    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();
        converter.prompt();
    }
}
