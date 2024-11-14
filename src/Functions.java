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
}
