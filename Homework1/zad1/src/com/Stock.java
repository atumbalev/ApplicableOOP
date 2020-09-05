package com;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        setCurrentPrice(0);
        setPreviousClosingPrice(0);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        if (previousClosingPrice < 0) {
            System.err.println("Invalid price value, price set to 0");
            this.previousClosingPrice = 0;
            return;
        }

        this.previousClosingPrice = previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        if (currentPrice < 0) {
            System.err.println("Invalid price value, price set to 0");
            this.currentPrice = 0;
            return;
        }

        this.currentPrice = currentPrice;
    }

    public double changePercent() {
        return ((previousClosingPrice - currentPrice) / Math.abs(currentPrice)) * 100;
    }


}
