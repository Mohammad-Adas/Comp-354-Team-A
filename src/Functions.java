public class Functions {

    /* Please add your main functions here */

    /* arccos(x) function */
    public static double arccos(double x, boolean isRadian) {
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
        if (!isRadian) {
            sum = Math.toDegrees(sum);
        }

        return sum;
    }

    /* Mean Absolute Deviation (MAD) */
    public static double calculateMAD(Number[] dataset) {
        double sum = 0.0;
        for (Number num : dataset) {
            sum += num.doubleValue();  // Convert Number to double
        }

        // Calculate mean
        double mean = sum / dataset.length;

        // Calculate the sum of absolute differences from the mean
        double madSum = 0.0;
        for (Number num : dataset) {
            madSum += Helpers.absoluteValue(num.doubleValue() - mean);
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
      public static int gammaInt(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Gamma function is not defined for non-positive integers.");
        }
        return Helpers.factorial(n-1);
    }
      public static double gammaDouble(double z) {
        if (z < 0.5) {
            // Using Helpers.sin and Helpers.pi directly
            return pi() / (Helpers.sin(pi() * z) * gammaDouble(1 - z)); // Reflection formula
        } else {
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
            // Using Helpers.sqrt, Helpers.power, and Helpers.naturalExponential directly
            return Helpers.calculatesquareroot(2 * pi()) * Helpers.power(t, z + 0.5) * Helpers.naturalExponential(-t) * x;
        }
    }
    
    // Method to return the value of Pi
    public static double pi() {
        return 3.141592653589793;
    }
    


}
