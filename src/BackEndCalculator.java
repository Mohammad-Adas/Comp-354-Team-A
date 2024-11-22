import java.util.Scanner;

public class BackEndCalculator {
    static Stackdouble stackdouble = new Stackdouble();
    static StackOperators stackOperators = new StackOperators();
    static String expression;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();

        System.out.println(evaluate(expression));
    }

    public static void processOperator(String func) {
        switch (func) {
            case "+":
            case "-":
                while (!stackOperators.isEmpty() && stackOperators.top().getRank() <= 5) {
                    doOperation();
                }
                stackOperators.push(func.equals("+") ? new Addition() : new Subtraction());
                break;
            case "*":
            case "/":
                while (!stackOperators.isEmpty() && stackOperators.top().getRank() <= 4) {
                    doOperation();
                }
                stackOperators.push(func.equals("*") ? new Multiplication() : new Division());
                break;
            case "^":
                while (!stackOperators.isEmpty() && stackOperators.top().getRank() <= 2) {
                    doOperation();
                }
                stackOperators.push(new Power());
                break;
            case "(":
                stackOperators.push(new OpenParenthesis());
                break;
            case ")":
                while (!(stackOperators.top() instanceof OpenParenthesis)) {
                    doOperation();
                }
                stackOperators.pop();
                break;
            case "sin":
                stackOperators.push(new Sin());
                break;
            case "cos":
                stackOperators.push(new Cos());
                break;
            case "tan":
                stackOperators.push(new Tan());
                break;
            case "ln":
                stackOperators.push(new Ln());
                break;
            case "exp":
                stackOperators.push(new Exp());
                break;
            case "sinh":
                stackOperators.push(new Sinh());
                break;
            case "√":
                stackOperators.push(new Sqrt());
                break;
            case "!":
                stackOperators.push(new Factorial());
                break;
            case "arccos":
                stackOperators.push(new Arccos());
                break;
            case "abx":
                stackOperators.push(new Abx());
                break;
            case "mad":
                stackOperators.push(new Mad());
                break;
            case "stddev":
                stackOperators.push(new StdDev());
                break;
            case "gamma":
                stackOperators.push(new Gamma());
                break;
            default:
                System.out.println("Unsupported operator: " + func);
        }
    }

    public static void doOperation() {
        if (stackOperators.isEmpty()) return;

        Operators op = stackOperators.pop();
        double result = 0;
        double y = stackdouble.pop();
        double x = (!stackdouble.isEmpty() && !(op instanceof UnaryOperator)) ? stackdouble.pop() : 0;

        if (op instanceof Addition) {
            result = x + y;
        } else if (op instanceof Subtraction) {
            result = x - y;
        } else if (op instanceof Multiplication) {
            result = x * y;
        } else if (op instanceof Division) {
            result = x / y;
        } else if (op instanceof Power) {
            result = Functions.calculatePower(x, (int) y);
        } else if (op instanceof Sin) {
            result = Helpers.sin(y);
        } else if (op instanceof Cos) {
            result = Helpers.cos(y);
        } else if (op instanceof Tan) {
            result = Helpers.tan(y);
        } else if (op instanceof Ln) {
            result = Helpers.ln(y);
        } else if (op instanceof Exp) {
            result = Helpers.naturalExponential(y);
        } else if (op instanceof Sinh) {
            result = Functions.calculateSinh(y);
        } else if (op instanceof Arccos) {
            result = Functions.arccos(y);
        } else if (op instanceof Abx) {
            result = Functions.abx(x, y, stackdouble.pop());
        } else if (op instanceof Mad) {
            Number[] dataset = retrieveDataset();
            result = Functions.calculateMAD(dataset);
        } else if (op instanceof StdDev) {
            double[] dataset = {};
            result = Functions.calculateStandardDeviation(dataset);
        } else if (op instanceof Gamma) {
            result = Functions.gammaDouble(y);
        } else if (op instanceof Sqrt) {
            result = Helpers.calculateSquareRoot(y);
        } else if (op instanceof Factorial) {
            result = Helpers.factorial((int) y);
        }

        stackdouble.push(result);
    }

    public static double evaluate(String expr) {
        stackdouble = new Stackdouble();
        stackOperators = new StackOperators();

        StringBuilder numberBuffer = new StringBuilder();
        StringBuilder functionBuffer = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
            } else if (Character.isLetter(c) || c == '√' || c == '!') {
                functionBuffer.append(c);
            } else {
                if (numberBuffer.length() != 0) {
                    stackdouble.push(Double.parseDouble(numberBuffer.toString()));
                    numberBuffer = new StringBuilder();
                }
                if (functionBuffer.length() != 0) {
                    processOperator(functionBuffer.toString());
                    functionBuffer = new StringBuilder();
                }
                processOperator(String.valueOf(c));
            }
        }
        if (numberBuffer.length() != 0) {
            stackdouble.push(Double.parseDouble(numberBuffer.toString()));
        }
        if (functionBuffer.length() != 0) {
            processOperator(functionBuffer.toString());
        }

        while (!stackOperators.isEmpty()) {
            doOperation();
        }

        return stackdouble.pop();
    }

    private static Number[] retrieveDataset() {
        // For demonstration, create a dummy dataset.
        // This should convert stackdouble content into a dataset for the MAD function.
        return new Number[] { 1, 2, 3, 4, 5 }; // Replace with logic to read from stackdouble
    }
}

// Stack Classes
class Stackdouble {
    protected double[] a = new double[2];
    private int top = -1;

    public void push(double x) {
        if (top == a.length - 1) growsize();
        a[++top] = x;
    }

    private void growsize() {
        double[] b = new double[a.length * 2];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public double pop() {
        return a[top--];
    }

    public double top() {
        return a[top];
    }
}

class StackOperators {
    protected Operators[] a = new Operators[2];
    private int top = -1;

    public void push(Operators x) {
        if (top == a.length - 1) growsize();
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

    public Operators top() {
        return a[top];
    }
}

// Operators Classes
abstract class Operators {
    protected int rank;

    public int getRank() {
        return rank;
    }
}

// Binary Operators
class Addition extends Operators {
    public Addition() {
        rank = 5;
    }
}

class Subtraction extends Operators {
    public Subtraction() {
        rank = 5;
    }
}

class Multiplication extends Operators {
    public Multiplication() {
        rank = 4;
    }
}

class Division extends Operators {
    public Division() {
        rank = 4;
    }
}

class Power extends Operators {
    public Power() {
        rank = 2;
    }
}

class OpenParenthesis extends Operators {
    public OpenParenthesis() {
        rank = 10;
    }
}

// Unary Operators
abstract class UnaryOperator extends Operators { }

class Arccos extends UnaryOperator {
    public Arccos() {
        rank = 3;
    }
}

class Abx extends Operators {
    public Abx() {
        rank = 4;
    }
}

class Mad extends UnaryOperator {
    public Mad() {
        rank = 3;
    }
}

class StdDev extends UnaryOperator {
    public StdDev() {
        rank = 3;
    }
}

class Gamma extends UnaryOperator {
    public Gamma() {
        rank = 3;
    }
}

class Exp extends UnaryOperator {
    public Exp() {
        rank = 3;
    }
}

class Sinh extends UnaryOperator {
    public Sinh() {
        rank = 3;
    }
}

class Sqrt extends UnaryOperator {
    public Sqrt() {
        rank = 3;
    }
}

class Factorial extends UnaryOperator {
    public Factorial() {
        rank = 3;
    }
}
class Sin extends UnaryOperator {
    public Sin() {
        rank = 3; // Set appropriate rank
    }
}
class Cos extends UnaryOperator {
    public Cos() {
        rank = 3; // Set appropriate rank
    }
}
class Tan extends UnaryOperator {
    public Tan() {
        rank = 3;
    }
}
class Ln extends UnaryOperator {
    public Ln() {
        rank = 3;
    }
}
