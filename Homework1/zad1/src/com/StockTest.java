package com;

import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String symbol, name;
        double currentPrice, previousPrice;
        Stock stock;

        System.out.print("Enter stock symbol: ");
        symbol = scanner.nextLine();
        System.out.print("Enter stock name: ");
        name = scanner.nextLine();

        stock = new Stock(symbol, name);

        System.out.print("Enter previous price: ");
        previousPrice = scanner.nextDouble();
        System.out.print("Enter current price: ");
        currentPrice = scanner.nextDouble();

        stock.setPreviousClosingPrice(previousPrice);
        stock.setCurrentPrice(currentPrice);

        System.out.printf("Stock name is %s%n", stock.getName());
        System.out.printf("Stock symbol is %s%n", stock.getSymbol());
        System.out.printf("Current price is %.2f%n", stock.getCurrentPrice());
        System.out.printf("Previous price is %.2f%n", stock.getPreviousClosingPrice());
        System.out.printf("Change rate is: %.2f%%%n", stock.changePercent());
    }
}
