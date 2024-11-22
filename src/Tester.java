import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tester implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JTextArea historyArea; // Text area for history
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[26];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton openParaButton, closeParaButton, powerButton, factorialButton;
    JButton sinButton, cosButton, tanButton, lnButton, sqrtButton, expButton;
    JButton arccosButton, abxButton, madButton, gammaButton, sinhButton, stdDevButton;
    JButton historyButton, clearHistoryButton;

    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    private CalculationHistory calcHistory = new CalculationHistory();

    Tester() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 750); // Adjusted to fit history area
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 400, 50);
        textfield.setFont(myFont);

        // Initialize history area
        historyArea = new JTextArea();
        historyArea.setBounds(460, 100, 200, 550); // Adjust dimensions
        historyArea.setFont(new Font("Ink Free", Font.PLAIN, 15));
        historyArea.setEditable(false);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        openParaButton = new JButton("(");
        closeParaButton = new JButton(")");
        powerButton = new JButton("^");
        factorialButton = new JButton("!");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        lnButton = new JButton("ln");
        sqrtButton = new JButton("√");
        expButton = new JButton("exp");
        arccosButton = new JButton("arccos");
        abxButton = new JButton("abx");
        madButton = new JButton("mad");
        gammaButton = new JButton("gamma");
        sinhButton = new JButton("sinh");
        stdDevButton = new JButton("stdDev");
        historyButton = new JButton("History");
        clearHistoryButton = new JButton("Clear History");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = openParaButton;
        functionButtons[9] = closeParaButton;
        functionButtons[10] = powerButton;
        functionButtons[11] = factorialButton;
        functionButtons[12] = sinButton;
        functionButtons[13] = cosButton;
        functionButtons[14] = tanButton;
        functionButtons[15] = lnButton;
        functionButtons[16] = sqrtButton;
        functionButtons[17] = expButton;
        functionButtons[18] = arccosButton;
        functionButtons[19] = abxButton;
        functionButtons[20] = madButton;
        functionButtons[21] = gammaButton;
        functionButtons[22] = sinhButton;
        functionButtons[23] = stdDevButton;
        functionButtons[24] = historyButton;
        functionButtons[25] = clearHistoryButton;
        
        for (int i = 0; i < functionButtons.length; i++) {
            if (functionButtons[i] != null) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);
            }
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 650, 190, 50);
        clrButton.setBounds(260, 650, 190, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 400, 550);
        panel.setLayout(new GridLayout(8, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(openParaButton);
        panel.add(closeParaButton);
        panel.add(powerButton);
        panel.add(factorialButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(lnButton);
        panel.add(sqrtButton);
        panel.add(expButton);
        panel.add(arccosButton);
        panel.add(abxButton);
        panel.add(madButton);
        panel.add(gammaButton);
        panel.add(sinhButton);
        panel.add(stdDevButton);
        panel.add(historyButton);
        panel.add(clearHistoryButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.add(historyArea); // Add the history area
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            if (!string.equals("")) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            textfield.setText(textfield.getText().concat("+"));
        }
        if (e.getSource() == subButton) {
            textfield.setText(textfield.getText().concat("-"));
        }
        if (e.getSource() == mulButton) {
            textfield.setText(textfield.getText().concat("*"));
        }
        if (e.getSource() == divButton) {
            textfield.setText(textfield.getText().concat("/"));
        }
        if (e.getSource() == openParaButton) {
            textfield.setText(textfield.getText().concat("("));
        }
        if (e.getSource() == closeParaButton) {
            textfield.setText(textfield.getText().concat(")"));
        }
        if (e.getSource() == powerButton) {
            textfield.setText(textfield.getText().concat("^"));
        }
        if (e.getSource() == factorialButton) {
            textfield.setText(textfield.getText().concat("!"));
        }
        if (e.getSource() == sinButton) {
            textfield.setText(textfield.getText().concat("sin("));
        }
        if (e.getSource() == cosButton) {
            textfield.setText(textfield.getText().concat("cos("));
        }
        if (e.getSource() == tanButton) {
            textfield.setText(textfield.getText().concat("tan("));
        }
        if (e.getSource() == lnButton) {
            textfield.setText(textfield.getText().concat("ln("));
        }
        if (e.getSource() == sqrtButton) {
            textfield.setText(textfield.getText().concat("√("));
        }
        if (e.getSource() == expButton) {
            textfield.setText(textfield.getText().concat("exp("));
        }
        if (e.getSource() == arccosButton) {
            textfield.setText(textfield.getText().concat("arccos("));
        }
        if (e.getSource() == abxButton) {
            textfield.setText(textfield.getText().concat("abx("));
        }
        if (e.getSource() == madButton) {
            textfield.setText(textfield.getText().concat("mad("));
            String input = JOptionPane.showInputDialog(frame, "Enter numbers separated by commas:");
            if (input != null && !input.trim().isEmpty()) {
                try {
                    // Split the input into an array of strings and convert to a double array
                    String[] inputArray = input.split(",");
                    Number[] data = new Number[inputArray.length];

                    for (int i = 0; i < inputArray.length; i++) {
                        data[i] = Double.parseDouble(inputArray[i].trim());  // Convert string to double
                    }

                    // Calculate MAD
                    double mad = Functions.calculateMAD(data);

                    // Display the result
                    textfield.setText(String.valueOf(mad));

                    // Optionally add the result to history
                    calcHistory.addHistory("MAD(" + input + ") = " + mad);
                    updateHistoryArea();
                } catch (NumberFormatException ex) {
                    textfield.setText("Invalid input");
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
                }
            }
        }
        if (e.getSource() == gammaButton) {
            textfield.setText(textfield.getText().concat("gamma("));
        }
        if (e.getSource() == sinhButton) {
            textfield.setText(textfield.getText().concat("sinh("));
        }
        if (e.getSource() == stdDevButton) {
            textfield.setText(textfield.getText().concat("stddev("));
            // going to add my testing logic here to input and array of Numbers or to use a sample array for testing purposes
        }
        if (e.getSource() == historyButton) {
            String[] history = calcHistory.retrieveHistory();
            JOptionPane.showMessageDialog(frame, "History:\n" + String.join("\n", history));
        }
        if (e.getSource() == clearHistoryButton) {
            calcHistory.clearHistory();
            historyArea.setText(""); // Clear the history display
            JOptionPane.showMessageDialog(frame, "History cleared.");
        }

        if (e.getSource() == equButton) {
            try {
                String expression = textfield.getText();
                String result = String.valueOf(BackEndCalculator.evaluate(expression));
                textfield.setText(result);

                // Add to history
                calcHistory.addHistory(expression + " = " + result);

                // Update the history display
                updateHistoryArea();
            } catch (Exception ex) {
                textfield.setText("Error");
            }
        }
    }
    private void updateHistoryArea() {
        String[] history = calcHistory.retrieveHistory();
        int start = Math.max(0, history.length - 5); // Get the last 5 calculations
        StringBuilder displayText = new StringBuilder("History (Last 5):\n");
        for (int i = start; i < history.length; i++) {
            displayText.append(history[i]).append("\n");
        }
        historyArea.setText(displayText.toString());
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
    }
}

