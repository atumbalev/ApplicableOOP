package Coin;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        MonetaryCoin monetaryCoin = new MonetaryCoin(Face.HEAD, 25);
        monetaryCoin.flip();
        System.out.println(monetaryCoin.toString());
        System.out.println("We flip the coin");
        monetaryCoin.flip();
        System.out.println(monetaryCoin.toString());
    }
}
