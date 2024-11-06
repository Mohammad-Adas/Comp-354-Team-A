public class Helpers {

    /*
    Please add your helpers functions here.
     */

    /*
    Factorial function
     */
    public static int factorial(int n){
        if (n==0 || n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
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

    /*
    Square Root function
     */

    /*
    Trigonometric Functions
     */
}
