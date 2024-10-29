import javax.swing.*;
import java. awt.*;
import java.awt.event.*;
public class Tester implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton [10];
    JButton[] functionButtons = new JButton[11];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton ,openParaButton,closeParaButton, powerButton;
    JPanel panel;
    char operator;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    Tester(){
        frame = new JFrame ("Calculator");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds (50, 25, 300, 50);
        textfield.setFont(myFont) ;
        addButton = new JButton ("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton ("=");
        delButton = new JButton("Delete");
        clrButton = new JButton ("Clear");
        openParaButton = new JButton ("(");
        closeParaButton = new JButton (")");
        powerButton = new JButton ("^");


        functionButtons[0] = addButton;
        functionButtons [1] = subButton;
        functionButtons [2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons [4] = decButton;
        functionButtons[5] = equButton;
        functionButtons [6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = openParaButton;
        functionButtons[9] = closeParaButton;
        functionButtons[10] = powerButton;


        for (int i =0;i<11;i++) {
            functionButtons [i].addActionListener(this);
            functionButtons [i].setFont(myFont) ;
            functionButtons[i].setFocusable(false);
        }
        for (int i =0;i<10;i++) {
            numberButtons [i] = new JButton(String. valueOf(i));
            numberButtons [i].addActionListener(this);
            numberButtons [i].setFont (myFont) ;
            numberButtons[i].setFocusable(false) ;
        }

        delButton.setBounds (50,430, 145,50);
        clrButton. setBounds (205,430,145,50);

        panel = new JPanel();
        panel. setBounds (50, 100, 300, 300);
        panel. setLayout (new GridLayout (4,4,10,10));
        panel. add (numberButtons [1]) ;
        panel. add (numberButtons [2]);
        panel. add (numberButtons [3]);
        panel. add(addButton) ;
        panel. add (numberButtons [4]);
        panel. add (numberButtons [5]);
        panel. add (numberButtons [6]);
        panel. add (subButton);
        panel. add (numberButtons[7]);
        panel. add (numberButtons [8]);
        panel. add (numberButtons [9]);
        panel. add (mulButton);
        panel. add (decButton) ;
        panel. add (numberButtons [0]);
        panel. add (equButton) ;
        panel. add (divButton);
        panel.add(powerButton);
        panel.add(openParaButton);
        panel.add(closeParaButton);
//        panel. setBackground (Color .GRAY) ;
        frame. add (panel);
        frame.add (delButton);
        frame.add (clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws emptySTackException {
        Tester tester = new Tester();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");}
            if (e.getSource() == delButton) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
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
        if (e.getSource() == openParaButton) {
            textfield.setText(textfield.getText().concat("("));
        }if (e.getSource() == closeParaButton) {
            textfield.setText(textfield.getText().concat(")"));
        }if (e.getSource() == powerButton) {
            textfield.setText(textfield.getText().concat("^"));
        }
                if (e.getSource() == divButton) {
                    operator = '/';
                    textfield.setText(textfield.getText().concat("/"));
                }
                    if (e.getSource() == equButton) {
                        try {
                            textfield.setText((String.valueOf(calculator.evaluate(textfield.getText()))));
                        } catch (emptySTackException ex) {
                            textfield.setText("");
                            throw new RuntimeException(ex);
                        }
                    }

            }
    }
