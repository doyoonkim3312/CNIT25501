package Lab_4;

// Controller

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.math.MathContext;

public class Calculation {
    private JLabel mainLabel;
    private CalculationData calculationData = new CalculationData();

    public Calculation(JLabel label) {
        mainLabel = label;
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
        if (mainLabel.getText().equals("0.0")) {
            calculationData.setNumberStored(0);
            calculationData.setOperatorClicked(Operator.NULL);
            calculationData.setOperationAssigned(Operator.NULL);
        } else {
            calculationData.setOperatorClicked(Operator.NULL);
            calculationData.setNumberButtonClickStatus(false);
        }
        return 0.0;
    }

    public void basicCalculation(double input) {
        double numberStored = calculationData.getNumberStored();
        System.out.println("BSC: " + calculationData.getOperatorAssigned());
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


    /**
     * This method update button click status in Model.
     * @param status New Button click status
     * @param buttonType 0 is assigned to number Button, 1 is assigned to OperatorButton
     */
    public void updateButtonClickStatus(boolean status, int buttonType) {
        if (buttonType == 0) {
            calculationData.setNumberButtonClickStatus(status);
        } else {
            calculationData.setOperatorButtonClickStatus(status);
        }
    }

    // getter for button click status need to be created.

    public JButton numberBtnFactory(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(70,70));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculationData.setNumberButtonClickStatus(true);
                if (!calculationData.getOperatorButtonClickStatus()) {
                    mainLabel.setText(mainLabel.getText() + text);
                } else {
                    mainLabel.setText(text);
                    calculationData.setOperatorButtonClickStatus(false);
                }
            }
        });
        return  btn;
    }

    // This button method needs more modifications.
    public JButton operatorBtnFactory(String text, Operator operator) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(70,70));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonClickStatus(true, 1);
                switch (operator) {
                    case PLUS, MINUS, MULTIPLY, DIVIDE -> {
                        operatorButtonHandler(operator);
                    }
                    case EQUAL -> {
                        mainLabel.setText(Double.toString(equal()));
                    }
                    case SIGN -> {
                        updateButtonClickStatus(false, 1);
                        sign();
                    }
                    case PERCENTAGE -> {
                        mainLabel.setText(Double.toString(percentage()));
                    }
                    case ZERO, DECIMAL -> {
                        updateButtonClickStatus(false,1);
                        // This case handles number button 0 and decimal point button
                        if (!mainLabel.getText().equals("")) {
                            mainLabel.setText(mainLabel.getText() + text);
                        }
                    }
                    case CLEAR -> {
                        mainLabel.setText(Double.toString(clear()));
                    }
                    case SQRT -> {
                        mainLabel.setText(Double.toString(sqRoot()));
                    }
                    case POW -> {
                        mainLabel.setText(Double.toString(pow()));
                    }
                    case PI -> {
                        mainLabel.setText(Double.toString(pi()));
                    }
                    case E -> {
                        mainLabel.setText(Double.toString(e()));
                    }
                }
                calculationData.setNumberButtonClickStatus(false);
            }
        });
        return btn;
    }

    public void operatorButtonHandler(Operator operator) {
        if (!calculationData.getNumberButtonClickStatus()) {
            calculationData.setOperationAssigned(operator);
        } else {
            switch (operator) {
                case PLUS -> mainLabel.setText(Double.toString(addition()));
                case MINUS -> mainLabel.setText(Double.toString(minus()));
                case MULTIPLY -> mainLabel.setText(Double.toString(multiply()));
                case DIVIDE -> mainLabel.setText(Double.toString(divide()));
            }
        }
    }

}
