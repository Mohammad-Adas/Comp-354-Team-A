public class CalculationAccuracy {
    // Private variable to store accuracy
    private int accuracy;

    // Constructor to initialize the accuracy (default to a reasonable value, e.g., 5)
    public CalculationAccuracy() {
        this.accuracy = 2; // Default accuracy value
    }

    // Getter for the accuracy variable
    public int getAccuracyDigits() {
        return accuracy;
    }

    // Increases the accuracy by 1
    public void increaseAccuracy() {
        accuracy++;
    }

    // Decreases the accuracy by 1, ensuring it doesn't go below 1
    public void decreaseAccuracy() {
        if (accuracy > 1) {
            accuracy--;
        }
    }

    // Test the CalculationAccuracy class
    public static void main(String[] args) {
        CalculationAccuracy calcAccuracy = new CalculationAccuracy();

        // Get initial accuracy
        System.out.println("Initial accuracy: " + calcAccuracy.getAccuracyDigits());

        // Increase accuracy
        calcAccuracy.increaseAccuracy();
        System.out.println("After increase: " + calcAccuracy.getAccuracyDigits());

        // Decrease accuracy
        calcAccuracy.decreaseAccuracy();
        calcAccuracy.decreaseAccuracy(); // Test edge case
        System.out.println("After decrease: " + calcAccuracy.getAccuracyDigits());
    }
}
