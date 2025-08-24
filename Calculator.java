public class Calculator {

    private double result;

    public Calculator() {
        this.result = 0.0;
    }

    public Calculator(double initialValue) {
        this.result = initialValue;
    }

    public double getResult() {
        return result;
    }

    public double add(double a, double b) {
        this.result = a + b;
        return result;
    }

    public double add(double a) {
        this.result += a;
        return result;
    }

    public double subtract(double a, double b) {
        this.result = a - b;
        return result;
    }

    public double subtract(double a) {
        this.result -= a;
        return result;
    }

    public double multiply(double a, double b) {
        this.result = a * b;
        return result;
    }

    public double multiply(double a) {
        this.result *= a;
        return result;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.result = a / b;
        return result;
    }

    public double divide(double a) throws ArithmeticException {
        if (a == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        this.result /= a;
        return result;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            System.out.println("Initial result: " + calc.getResult());
            System.out.println("Adding 5 and 3: " + calc.add(5, 3));
            System.out.println("Adding 2 to current result: " + calc.add(2));
            System.out.println("Subtracting 10 from 20: " + calc.subtract(20, 10));
            System.out.println("Subtracting 5 from current result: " + calc.subtract(5));
            System.out.println("Multiplying 4 by 6: " + calc.multiply(4, 6));
            System.out.println("Multiplying current result by 2: " + calc.multiply(2));
            System.out.println("Dividing 100 by 4: " + calc.divide(100, 4));
            System.out.println("Dividing current result by 5: " + calc.divide(5));

        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
