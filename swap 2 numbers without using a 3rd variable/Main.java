import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Swapping two numbers without using third variable");
        System.out.println("---------------------------------------------------");
        System.out.print("Enter first number for variable x: ");
        int x = scanner.nextInt();

        System.out.print("Enter second number for variable y: ");
        int y = scanner.nextInt();

        System.out.println("Before swapping: ");
        System.out.println("x = "+x);
        System.out.println("y = "+y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("After swapping: ");
        System.out.println("x = "+x);
        System.out.println("y = "+y);
    }
}
