public class Functions {

    /* Please add your main functions here */

    /* arccos(x) function */
    public static double arccos(double x) {
        // Ensure input is within valid range for arccos
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("Input must be between -1 and 1");
        }

        // Taylor series approximation for arccos(x)
        double sum = Math.PI / 2; // start with π/2 as arccos(0) is π/2
        double term = x; // first term in the series
        double fact = 1; // factorial component of the series
        int n = 1; // term counter

        // Use the Taylor series to approximate arccos(x)
        for (int i = 1; i <= 10; i++) {
            sum -= term / (fact * (2 * n - 1)); // add the next term
            term *= x * x * (2 * n - 1) * (2 * n) / ((2 * n + 1) * (2 * n + 2));
            fact *= n;
            n++;
        }

        // Convert result to degrees if isRadian is false
//        if (!isRadian) {
//            sum = Math.toDegrees(sum);
//        }

        return sum;
    }

 //Function ab^x
    public static double abx(double a, double b, double x) {
        double result = 0;
        if ((b < 0) && (x > 0 && x < 1)) {
            throw new IllegalArgumentException("Cannot sqrt a negative number");
        } else if (((b) == 0) & (x < 0)) {
            throw new IllegalArgumentException("Cannot divide by zero");
        } else if ((b == 0) && (x == 0)) {
            throw new IllegalArgumentException("Undefined");
        } else {
            if (x > 0 && x < 1) {
                result += Helpers.decimalPower(b, x);
                //System.out.println("X is a decimal");
                //System.out.println(result);
            } else {
                result += Helpers.power(b, (int) x);
                //System.out.println("X is an int");
            }
        }
        result *= a;
        return result;
    }

     //Function 2^x
    public static double BaseTwoExponential(double exp){

        double result = 0;
        if(exp<0){
            exp = -exp;
            if(exp > 0 && exp < 1 ){

                result += 1/Helpers.decimalPower(2,exp);
            }else{
                result += 1/Helpers.power(2,exp);
            }
        }else{

            if(exp > 0 && exp < 1 ){

                result +=Helpers.decimalPower(2,exp);
            }else{
                result += Helpers.power(2,exp);
            }
        }
        return result;

    }

    //Function 10^x
    public static double BaseTenExponential(double exp){

        double result = 0;
        if(exp<0){
            exp = -exp;
            if(exp > 0 && exp < 1 ){

                result += 1/Helpers.decimalPower(10,exp);
            }else{
                result += 1/Helpers.power(10,exp);
            }
        }else{

            if(exp > 0 && exp < 1 ){

                result +=Helpers.decimalPower(10,exp);
            }else{
                result += Helpers.power(10,exp);
            }
        }
        return result;

    }


    /* Mean Absolute Deviation (MAD) */
    public static double calculateMAD(Number[] dataset) {
        double sum = 0.0;
        for (Number numerator : dataset) {
            sum += numerator.doubleValue();  // Convert Number to double
        }

        // Calculate mean
        double mean = sum / dataset.length;

        // Calculate the sum of absolute differences from the mean
        double madSum = 0.0;
        for (Number numerator : dataset) {
            madSum += Helpers.absoluteValue(numerator.doubleValue() - mean);
        }

        // Return the Mean Absolute Deviation (MAD)
        return madSum / dataset.length;

        // Test cases for different data types (integers, doubles, mixed)
        // Number[] dataset1 = {1, 2, 3, 4, 5};          // All integers
        // Number[] dataset2 = {1.5, 2.5, 3.5, 4.5};    // All doubles
        // Number[] dataset3 = {1, 2.5, 3, 4.5};        // Mixed integers and doubles
    }

    /* Power function */
public static double calculatePower(double number, int power) {
    double outcome = 1;
    int absPower = power < 0 ? -power : power; // Absolute value of power

    // Multiply number by itself absPower times
    for (int i = 0; i < absPower; i++) {
        outcome *= number;
    }

    // If power was negative, take the reciprocal of the outcome
    if (power < 0) {
        outcome = 1 / outcome;
    }

    return outcome;
}
    /* Gamma Function */
    // Gamma function for integer inputs

        public static double gammaDouble(double z) {
        if (z < 0.5) {
            // Reflection formula for Gamma function
            return pi() / (Helpers.sin(pi() * z) * gammaDouble(1 - z));
        } else {
            // Lanczos approximation for Gamma function
            z -= 1;
            double[] p = {
                    676.5203681218851, -1259.1392167224028, 771.32342877765313,
                    -176.61502916214059, 12.507343278686905, -0.13857109526572012,
                    9.9843695780195716e-6, 1.5056327351493116e-7
            };
            double x = 0.99999999999980993;
            for (int i = 0; i < p.length; i++) {
                x += p[i] / (z + i + 1);
            }
            double t = z + p.length - 0.5;
            return Helpers.sqrt(2 * pi()) * Helpers.pow(t, z + 0.5) * Helpers.exp(-t) * x;
        }
    }

    // Hyperbolic sine function using exponential logic
    public static double calculateSinh(double x) {
        // sinh(x) = (e^x - e^(-x)) / 2
        double expX = Helpers.naturalExponential(x); // e^x
        double expNegX = Helpers.naturalExponential(-x); // e^(-x)
        return (expX - expNegX) / 2;
    }

    // Standard Deviation function (takes an array of Numbers)
    public static double calculateStandardDeviation(double[] data) {

        // calculate mean
        double sum = 0.0;
        for (double num : data) {
            sum += num;
        }
        double mean = sum / data.length;

        // calculate variance
        double varianceSum = 0.0;
        for (double num : data) {
            varianceSum += Helpers.power(num - mean, 2);
        }
        double variance = varianceSum / data.length;

        return Helpers.calculateSquareRoot(variance);
    }
}
