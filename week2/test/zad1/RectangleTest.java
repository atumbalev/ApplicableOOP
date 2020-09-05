package zad1;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2);
        rectangle.setColor("Black");

        System.out.printf("Rectangle height is %f%n", rectangle.getHeight());
        System.out.printf("Rectangle width is: %f%n", rectangle.getWidth());
        System.out.printf("Rectangle color is %s%n", rectangle.getColor());
        System.out.printf("Rectangle area is %f%n", rectangle.getArea());
    }
}
