package sample;

public class Inventory {
    private static int currentInstance = 0;
    private String id;
    private String name;
    private int qoh;
    private int rop;
    private double sellPrice;

    public Inventory(String name, int qoh, int rop, double sellPrice) {
        this.id = String.format("ABC-%06d", currentInstance++);
        this.name = name;
        this.qoh = qoh;
        this.rop = rop;
        this.sellPrice = sellPrice;
    }

    public String getId() {
        return id;
    }
}
