import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String expression = scanner.nextLine();
        System.out.println("Output: " + MathParser.parse(expression));
    }
}





