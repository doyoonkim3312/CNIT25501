package Lab_4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Calculation {
    private JLabel mainLabel;
    private Operator operatorClicked, operatorAssigned;
    private double numberStored;

    public Calculation(JLabel label) {
        mainLabel = label;
        operatorAssigned = Operator.NULL;
        operatorClicked = Operator.NULL;
        // assignedOperator = Operator.NULL;
        numberStored = 0;
    }

    public void addition() {
        operatorClicked = Operator.PLUS;
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
    }

    public void minus() {
        operatorClicked = Operator.MINUS;
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
    }

    public void multiply() {
        operatorClicked = Operator.MULTIPLY;
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
    }

    public void divide() {
        operatorClicked = Operator.DIVIDE;
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
    }

    public void equal() {
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
    }

    public void clear() {
        if (mainLabel.getText().equals("0.0")) {
            numberStored = 0;
            operatorClicked = Operator.NULL;
            operatorAssigned = Operator.NULL;
        } else {
            mainLabel.setText("0.0");
        }
    }

    public void basicCalculation(double input) {
        switch (operatorAssigned) {
            case PLUS -> numberStored += input;
            case MINUS -> numberStored -= input;
            case DIVIDE -> numberStored /= input;
            case MULTIPLY -> numberStored *= input;
            default -> numberStored = input;
        }
        operatorAssigned = operatorClicked;
    }

    private double valueParser() {
        if (!mainLabel.getText().equals("")) {
            return Double.parseDouble(mainLabel.getText());
        } else {
            return 0.0;
        }
    }

}
