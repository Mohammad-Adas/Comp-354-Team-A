public class Helpers {

    /*
    Please add your helpers functions here.
     */

    /*
    Factorial function
     */
    public static Double factorial(int n){
        if (n==0 || n==1){
            return 1.0;
        }else{
            return n*factorial(n-1);
        }
    }
    public static double factoriall(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /* power function */
    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        // If exponent is negative, take reciprocal of the result
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /*
    Absolute Value function
     */
    //the absolute value of an int
    public static int absoluteValue(int x) {
        if (x < 0) {
            return -x;  // Negate x if it's negative
        } else {
            return x;   // Return x if it's already positive or zero
        }
    }

    //the absolute value of a double
    public static double absoluteValue(double x) {
        if (x < 0) {
            return -x;  // Negate x if it's negative
        } else {
            return x;   // Return x if it's already positive or zero
        }
    }

    /*
    Natural Exponential function
     */
    public static double naturalExponential(double x){
        // using the Taylor series to approximate the power function
        double result = 1;
        double term = 1;
        int n = 30; // calculating first 30 terms.. this could be changed to use some 'convergence precision' value instead..

        for (int i = 1; i <= n; i++) {
            term *= x / i;
            result += term;
        }

        return result;
    }

    /*
    Natural Logarithm function
     */
    public static double ln(double x){
        return Math.log(x);
    }

    /*
    Square Root function
     */

	    public static double calculateSquareRoot(double number) {
	        if (number < 0) {
	            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
	        }

	        double guess = number / 2.0;
	        if (number == 0) return 0;


	        double epsilon = 0.000001;

	        // Babylonian method (Newton's method for square roots)
	        while ((guess * guess - number) > epsilon || (number - guess * guess) > epsilon) {
	            guess = (guess + number / guess) / 2.0;
	        }

	        return guess;
	    }
    /*
    Trigonometric Functions
     */

    public static double sin(double a) {
        double PI = Math.PI;

        // Adjust the input angle to fall within the period of sine
        a %= 2 * PI;

        // Convert any negative angle to its equivalent positive angle
        if (a < 0) {
            a = 2 * PI + a;
        }

        // Since sine is an odd function, adjust the range [0, pi] with the sign
        int sign = 1;
        if (a > PI) {
            a -= PI;
            sign = -1;
        }

        // Calculate sin(a) using a Taylor series approximation
        final int PRECISION = 50;
        double result = 0;
        for (int i = 0; i <= PRECISION; i++) {
            result += power(-1, i) * (power(a, (2 * i + 1)) / factorial(2 * i + 1));
        }

        return sign * result;
    }
    public static double cos(double a) {
        double PI = Math.PI;

        // Adjust the input angle to fall within the period of cosine
        a %= 2 * PI;

        // Convert any negative angle to its equivalent positive angle
        if (a < 0) {
            a = 2 * PI + a;
        }

        // Calculate cos(a) using a Taylor series approximation
        final int PRECISION = 50;
        double result = 0;
        for (int i = 0; i <= PRECISION; i++) {
            result += power(-1, i) * (power(a, 2 * i) / factorial(2 * i));
        }

        return result;
    }

    public static double tan(double a) {
        double sinValue = sin(a);
        double cosValue = cos(a);

        // Handle the case where cos(a) is zero to avoid division by zero
        if (cosValue == 0) {
            throw new ArithmeticException("Undefined value (cosine of angle is zero).");
        }

        return sinValue / cosValue;
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
System.out.println(cos(i));

        }
    }
}



