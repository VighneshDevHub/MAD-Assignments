package Day04;

public class ThrowsExample {
    public void divide(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result = numerator / denominator;
        System.out.println("Result of division: " + result);
    }
    public static void main(String[] args) {
        ThrowsExample example = new ThrowsExample();

        try {
            // Call the method that throws an ArithmeticException
            example.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }}}
