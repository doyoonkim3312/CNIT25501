package Lab_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.MathContext;

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

    /**
     * <h1>sqRoot</h1>
     * <p>This method calculates squared root of input value, using Babylonian method.</p>
     * <p>A sequence's term is calculated until its 10th term. Calculate lim is way more precise, but</p>
     * <p>since this is a simple calculator, 10th term of sequence ensures enough decimal value.</p>
     * @return squared root of num
     */
    public double sqRoot() {
        double num = valueParser();
        double base = 0;
        while (base < num) {
            base++;
            if ((base * base) == num) {
                return base;
            }
        }

        double termInSequence = ((base * base) + num) / (2 * base);
        for (int i = 0; i < 10; i++) {
            termInSequence = ((termInSequence * termInSequence) + num) / (2 * termInSequence);
        }
        return Double.parseDouble(String.format("%.9f", termInSequence));
    }

    public void pow() {
        mainLabel.setText(Double.toString(StrictMath.pow(valueParser(), 2)));
    }

    public void pi() {
        mainLabel.setText(Double.toString(StrictMath.PI));
    }

    public void e() {
        mainLabel.setText(Double.toString(StrictMath.E));
    }

    public void equal() {
        basicCalculation(valueParser());
        mainLabel.setText(Double.toString(numberStored));
        operatorAssigned = Operator.NULL;
    }

    public void percentage() {
        mainLabel.setText(Double.toString(0.01 * valueParser()));
    }

    public void sign() {
        mainLabel.setText(Double.toString(-1 * valueParser()));
    }

    public void clear() {
        if (mainLabel.getText().equals("0")) {
            numberStored = 0;
            operatorClicked = Operator.NULL;
            operatorAssigned = Operator.NULL;
        } else {
            mainLabel.setText("0");
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
