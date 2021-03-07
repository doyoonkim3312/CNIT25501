package Lab_4;

import javax.swing.*;

public class Calculation {
    private JLabel mainLabel;
    private Operator operator;
    private double numberStored;

    public Calculation(JLabel label) {
        mainLabel = label;
        operator = Operator.NULL;
        // assignedOperator = Operator.NULL;
        numberStored = 0;
    }

    public void addition(double number) {
        basicCalculation(Double.parseDouble(mainLabel.getText()));
        mainLabel.setText(Double.toString(numberStored));
    }

    public void basicCalculation(double input) {
        switch (operator) {
            case PLUS -> numberStored += input;
            case MINUS -> numberStored -= input;
            case DIVIDE -> numberStored /= input;
            case MULTIPLY -> numberStored *= input;
        }
    }

}
