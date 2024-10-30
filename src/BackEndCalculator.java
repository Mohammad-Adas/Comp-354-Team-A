import java.util.Scanner;

public class BackEndCalculator {
    static StackFloat stackFloat = new StackFloat();
    static StackOperators stackOperators = new StackOperators();
    static String expression;

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();

        System.out.println(evaluate(expression));
    }

    public static void processOperator(char c)  {
        // Convert character to operator and handle precedence
        switch (c) {
            case '+':
            case '-':
                while (!stackOperators.isEmpty() && !(stackOperators.top() instanceof OpenParenthesis)) {
                    // + and - have lower precedence than *, /, and ^, but equal among themselves
                    doOperation();
                }
                if (c == '+') {
                    stackOperators.push(new Addition());
                } else {
                    stackOperators.push(new Subtraction());
                }
                break;
            case '*':
            case '/':
                while (!stackOperators.isEmpty() && (stackOperators.top() instanceof Multiplication || stackOperators.top() instanceof Division || stackOperators.top() instanceof Power)) {
                    // * and / have higher precedence than + and -, but lower than ^
                    doOperation();
                }
                if (c == '*') {
                    stackOperators.push(new Multiplication());
                } else {
                    stackOperators.push(new Division());
                }
                break;
            case '^':
                // ^ has the highest precedence
                stackOperators.push(new Power());
                break;
            case '(':
                stackOperators.push(new OpenParenthesis());
                break;
            case ')':
                // Pop and evaluate until finding the matching '('
                while (!(stackOperators.top() instanceof OpenParenthesis)) {
                    doOperation();
                }
                stackOperators.pop(); // Pop the open parenthesis without evaluating it
                break;
        }
    }

    public static float evaluate(String expr)  {
        // Reset stacks for each new expression evaluation
        stackFloat = new StackFloat();
        stackOperators = new StackOperators();

        StringBuilder numberBuffer = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') { // Support decimal point
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() != 0) {
                    stackFloat.push(Float.parseFloat(numberBuffer.toString())); // Parse as float
                    numberBuffer = new StringBuilder();
                } try {
                                    processOperator(c);

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
        if (numberBuffer.length() != 0) {
            stackFloat.push(Float.parseFloat(numberBuffer.toString()));
        }

        // Final evaluation of the remaining operations
        while (!stackOperators.isEmpty()) {
            try {
                            doOperation();

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        return stackFloat.pop();
    }

    public static void doOperation()  {
        if (stackOperators.isEmpty()) {
            return;
        }

        Operators op = stackOperators.pop();
        if (op instanceof OpenParenthesis) {
        }

        float result = 0;
        float y = stackFloat.pop();
        float x = !stackFloat.isEmpty() ? stackFloat.pop() : 0;

        if (op instanceof Addition) {
            result = x + y;
        } else if (op instanceof Subtraction) {
            result = x - y;
        } else if (op instanceof Multiplication) {
            result = x * y;
        } else if (op instanceof Division) {
            result = x / y;
        } else if (op instanceof Power) {
            result = (float) Math.pow(x, y);
        }

        stackFloat.push(result);
    }
}

// Stack class to store float values
class StackFloat {
    protected float[] a = new float[2];
    private int top = -1;

    public void push(float x) {
        if (top == a.length - 1) {
            growsize();
        }
        a[++top] = x;
    }

    private void growsize() {
        float[] b = new float[a.length * 2];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public float pop() {
        return a[top--];
    }

    public float top()  {
        if (isEmpty()) {
        }
        return a[top];
    }
}

// Stack for operators with dynamic resizing
class StackOperators {
    protected Operators[] a = new Operators[2];
    private int top = -1;

    public void push(Operators x) {
        if (top == a.length - 1) {
            growsize();
        }
        a[++top] = x;
    }

    private void growsize() {
        Operators[] b = new Operators[a.length * 2];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Operators pop() {
        return a[top--];
    }

    public Operators top()  {
        if (isEmpty()) {
        }
        return a[top];
    }
}

// Operator classes for each arithmetic operation
abstract class Operators { protected int rank = 10; }
class Addition extends Operators { public Addition() { rank = 4; } }
class Subtraction extends Operators { public Subtraction() { rank = 4; } }
class Multiplication extends Operators { public Multiplication() { rank = 3; } }
class Division extends Operators { public Division() { rank = 3; } }
class Power extends Operators { public Power() { rank = 2; } }
class OpenParenthesis extends Operators { public OpenParenthesis() { rank = 10; } }

// Custom exception for handling empty stack scenarios

