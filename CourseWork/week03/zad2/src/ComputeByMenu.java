import java.util.Scanner;

public class ComputeByMenu {
    private double x;

    public ComputeByMenu(double x) {
        this.x = x;
    }

    public void displayMenu(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
        System.out.println("Chose option:\n " +
                "1. Update the floating points number\n" +
                "2. Compute and display exp(x)\n" +
                "3. Compute and display sin(x)\n" +
                "4. Compute and display floor(x)\n" +
                "5. Exit\n");
    }

    public void doSelection(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Input new: ");
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextDouble();
                System.out.printf("New type is %f", x);
                break;
            case 2:
                System.out.printf("Exp is %f", Math.exp(x));
                break;
            case 3:
                System.out.printf("Sin is %f", Math.sin(x));
                break;
            case 4:
                System.out.printf("Floor is %f", Math.floor(x));
                break;
            case 5:
                System.out.println("Error!");
                break;

        }
    }

    public int compute() {
        while(true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            doSelection(choice);
            scanner.nextLine();
            return choice;
        }
    }

    public static void main(String[] args) {
        ComputeByMenu computeByMenu = new ComputeByMenu(0);
        computeByMenu.compute();

    }

}