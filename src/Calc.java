import java.util.Stack;

public class Calc {
    public static int parse(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operations = new Stack<>();
        if (expression.length() <= 6) {
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                // If the current character is a digit, read it as a number
                if (Character.isDigit(c)) {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i));
                        i++;
                    }
                    if (Integer.parseInt(sb.toString()) <= 10){
                        values.push(Integer.parseInt(sb.toString()));
                        //System.out.println(Integer.parseInt(sb.toString()));
                        i--;
                    }else {
                        System.out.println("Numbers must be less or equal to 10");
                        System.exit(1);
                    }
                }
                // If the current character is an operator, solve the previous operations with higher or equal precedence
                else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                        values.push(applyOperation(operations.pop(), values.pop(), values.pop()));
                    }
                    operations.push(c);
                }
                else{
                    System.out.println("Values must be only digits or basic math(+,-,*,/) operators!");
                    System.exit(1);
                }
            }
        }
        else {
            System.out.println("No more than 3 values!");
            System.exit(1);
        }

        // Solve the remaining operations
        while (!operations.isEmpty()) {
            values.push(applyOperation(operations.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Returns the precedence of an operator
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // Applies an operation to two operands
    private static int applyOperation(char c, int b, int a) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}
