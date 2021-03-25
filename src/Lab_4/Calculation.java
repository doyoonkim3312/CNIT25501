package Lab_4;

// Controller

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.MathContext;

public class Calculation {
    private JLabel mainLabel;
    private Operator operatorClicked;
    private CalculationData calculationData = new CalculationData();

    public Calculation(JLabel label) {
        mainLabel = label;
        operatorClicked = Operator.NULL;
    }

    public double addition() {
        calculationData.setOperatorClicked(Operator.PLUS);
        basicCalculation(valueParser());
        return calculationData.getNumberStored();
    }

    public double minus() {
        calculationData.setOperatorClicked(Operator.MINUS);
        basicCalculation(valueParser());
        return calculationData.getNumberStored();
    }

    public double multiply() {
        calculationData.setOperatorClicked(Operator.MULTIPLY);
        basicCalculation(valueParser());
        return calculationData.getNumberStored();
    }

    public double divide() {
        calculationData.setOperatorClicked(Operator.DIVIDE);
        basicCalculation(valueParser());
        return calculationData.getNumberStored();
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

    public double pow() {
        return StrictMath.pow(valueParser(), 2);
    }

    public double pi() {
        return StrictMath.PI;
    }

    public double e() {
        return StrictMath.E;
    }

    public double equal() {
        basicCalculation(valueParser());
        calculationData.setOperationAssigned(Operator.NULL);
        return calculationData.getNumberStored();
    }

    public double percentage() {
        return 0.01 * valueParser();
    }

    public void sign() {
        mainLabel.setText(Double.toString(-1 * valueParser()));
    }

    public double clear() {
        if (mainLabel.getText().equals("0")) {
            calculationData.setNumberStored(0);
            operatorClicked = Operator.NULL;
            calculationData.setOperationAssigned(Operator.NULL);
        }
        return 0.0;
    }

    public void basicCalculation(double input) {
        double numberStored = calculationData.getNumberStored();
        switch (calculationData.getOperatorAssigned()) {
            case PLUS -> numberStored += input;
            case MINUS -> numberStored -= input;
            case DIVIDE -> numberStored /= input;
            case MULTIPLY -> numberStored *= input;
            default -> numberStored = input;
        }
        calculationData.setNumberStored(numberStored);
        calculationData.updateOperatorAssigned();
    }

    private double valueParser() {
        if (!mainLabel.getText().equals("")) {
            return Double.parseDouble(mainLabel.getText());
        } else {
            return 0.0;
        }
    }

}
