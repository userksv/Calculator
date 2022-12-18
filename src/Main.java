import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String expression = scanner.nextLine();
        System.out.println("Output: " + Calc.parse(expression));
        System.out.println();
    }
}





