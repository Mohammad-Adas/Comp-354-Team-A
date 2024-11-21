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


    /* power function */
    public static double power(double base, double exponent) {
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

    //Find the gcd
    public static int gcd(int a, int b) {
        int largest = max(a, b);
        int smallest = min(a, b);
        int quotitent;
        int remainder;
        int prevNum = 1;
        if (largest % smallest == 0) {
            return smallest;
        }
        while (true) {
            quotitent = largest / smallest;
            remainder = largest % smallest;
            if (remainder == 0) {
                break;
            }
            largest = smallest;
            smallest = remainder;
            prevNum = remainder;
        }
        return prevNum;
    }

    //Newton Method to find nth root
    public static double decimalPower(double base, double exponent) {

        //Converting to decimal
        String str = Double.toString(exponent);
        int index = str.indexOf('.');
        int num = str.length() - 1;
        int denominator = (int) Helpers.power(10, (num - index));
        int numerator = Integer.parseInt(str.replace(".", ""));
        int gcd = Helpers.gcd(numerator, denominator);
        denominator = denominator / gcd;
        numerator = numerator / gcd;

        int nthRoot = denominator;
        double result;
        double prev = (int) (base / 2);

        while (true) {

            result = (nthRoot - 1) * prev;
            result += (base / (Helpers.power(prev, nthRoot - 1)));


            result *= (double) 1 / (double) nthRoot;

            if (absoluteValue(result - prev) < 0.00001) {
                break;
            }

            prev = result;

        }

        result = Helpers.power(result, numerator);
        return result;


    }

     //Find min and max
    public static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }

    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

	
    /*
    Natural Logarithm function
     */
    public static double ln(double x){
           if (x <= 0){
            throw new ArithmeticException();
        }
        double a = 1;
        double n = 50;
        double deltaX = x-a/n;
        double result = 1;
        double beginig = 1;
        double last = 1/50;
        for (double i = 1; i <= n; i++) {
            if (i%2==0){
                result += 4*(1/i+1);
            }else{
                result += 2*(1/i+1);

            }
        }
        return result;

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
System.out.println(sin(i));

        }
    }
}



