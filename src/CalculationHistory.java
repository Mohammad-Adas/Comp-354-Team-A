import java.util.ArrayList;
import java.util.*;

public class CalculationHistory {
    // Private array of strings to store the history
    private ArrayList<String> history;

    // Constructor to initialize the history
    public CalculationHistory() {
        history = new ArrayList<>();
    }

    // Adds a string to the history
    public boolean addHistory(String record) {
        try {
            history.add(record);
            return true; // Successful addition
        } catch (Exception e) {
            return false; // Error occurred
        }
    }

    // Retrieves the history as an array of strings
    public String[] retrieveHistory() {
        return history.toArray(new String[0]);
    }

    // Clears the history and returns an empty array
    public String[] clearHistory() {
        history.clear();
        return new String[0];
    }

    // Test the CalculationHistory class
    public static void main(String[] args) {
        CalculationHistory calcHistory = new CalculationHistory();

        // Adding history records
        System.out.println(calcHistory.addHistory("arccos(0.5) = 1.047 radians")); // true
        System.out.println(calcHistory.addHistory("arccos(0.5) = 60 degrees"));   // true

        // Retrieving history
        String[] currentHistory = calcHistory.retrieveHistory();
        System.out.println("History:");
        for (String record : currentHistory) {
            System.out.println(record);
        }

        // Clearing history
        String[] clearedHistory = calcHistory.clearHistory();
        System.out.println("Cleared history:");
        System.out.println(clearedHistory.length); // Should print 0
    }
}
