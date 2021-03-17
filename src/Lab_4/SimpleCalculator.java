package Lab_4;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class SimpleCalculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorFrame test = new CalculatorFrame();
                // test.setVisible(true);
            }
        });
    }
}

class CalculatorFrame extends JFrame {
    private Container mainContainer = this.getContentPane();
    private LinearLayoutPanel mainPanel = new LinearLayoutPanel(Orient.VERTICAL);
    private JLabel mainLabel = new JLabel();

    private Calculation mainCalculator = new Calculation(mainLabel);
    private boolean isOperatorClicked = false;

    public CalculatorFrame() {
        super("Simple Calculator");
        setBounds(new Rectangle(500, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainLabel.setPreferredSize(new Dimension(290, 70));
        mainLabel.setOpaque(true);  //setOpaque value should be ture in order to apply the background color
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBackground(Color.white);

        LinearLayoutPanel higherOperators = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel topLineOperators = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers1 = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers2 = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers3 = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel bottomLineOperators = new LinearLayoutPanel(Orient.HORIZONTAL);

        JButton sqrt = operatorBtnFactory("√", Operator.SQRT);
        JButton pow = operatorBtnFactory("x²",Operator.POW);
        JButton pi = operatorBtnFactory("π", Operator.PI);
        JButton e = operatorBtnFactory("e", Operator.E);
        higherOperators.add(sqrt, pow, pi, e);

        JButton clear = operatorBtnFactory("C", Operator.CLEAR);
        JButton sign = operatorBtnFactory("+/-", Operator.SIGN);
        JButton percentage = operatorBtnFactory("%", Operator.PERCENTAGE);
        JButton divide = operatorBtnFactory("/", Operator.DIVIDE);
        topLineOperators.add(clear, sign, percentage, divide);

        JButton number0 = operatorBtnFactory("0",Operator.ZERO);
        JButton decimal = operatorBtnFactory(".", Operator.DECIMAL);
        JButton equal = operatorBtnFactory("=", Operator.EQUAL);
        bottomLineOperators.add(number0, decimal, equal);

        JButton number1 = numberBtnFactory("1");
        JButton number2 = numberBtnFactory("2");
        JButton number3 = numberBtnFactory("3");
        JButton plus = operatorBtnFactory("+", Operator.PLUS);
        numbers3.add(number1, number2, number3, plus);

        JButton number4 = numberBtnFactory("4");
        JButton number5 = numberBtnFactory("5");
        JButton number6 = numberBtnFactory("6");
        JButton minus = operatorBtnFactory("-", Operator.MINUS);
        numbers2.add(number4, number5, number6, minus);

        JButton number7 = numberBtnFactory("7");
        JButton number8 = numberBtnFactory("8");
        JButton number9 = numberBtnFactory("9");
        JButton multiply = operatorBtnFactory("*", Operator.MULTIPLY);
        numbers1.add(number7, number8, number9, multiply);


        mainPanel.add(mainLabel, higherOperators.inflate() ,topLineOperators.inflate(), numbers1.inflate(), numbers2.inflate(),
                numbers3.inflate(), bottomLineOperators.inflate());


        add(mainPanel.inflate());
        pack();
        //setResizable(false);
        setVisible(true);

    }

    public JButton numberBtnFactory(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(70,70));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperatorClicked) {
                    mainLabel.setText(mainLabel.getText() + text);
                } else {
                    mainLabel.setText(text);
                    isOperatorClicked = false;
                }
            }
        });
        return  btn;
    }

    public JButton operatorBtnFactory(String text, Operator operator) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(70,70));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operator) {
                    case PLUS -> {
                        isOperatorClicked = true;
                        mainCalculator.addition();
                    }
                    case MINUS -> {
                        isOperatorClicked = true;
                        mainCalculator.minus();
                    }
                    case MULTIPLY -> {
                        isOperatorClicked = true;
                        mainCalculator.multiply();
                    }
                    case DIVIDE -> {
                        isOperatorClicked = true;
                        mainCalculator.divide();
                    }
                    case EQUAL -> {
                        isOperatorClicked = true;
                        mainCalculator.equal();
                    }
                    case CLEAR -> {
                        isOperatorClicked = true;
                        mainCalculator.clear();
                    }
                    case SIGN -> mainCalculator.sign();
                    case PERCENTAGE -> {
                        isOperatorClicked = true;
                        mainCalculator.percentage();
                    }
                    case SQRT -> {
                        isOperatorClicked = true;
                        mainLabel.setText(Double.toString(mainCalculator.sqRoot()));
                    }
                    case POW -> {
                        isOperatorClicked = true;
                        mainCalculator.pow();
                    }
                    case PI -> {
                        isOperatorClicked = true;
                        mainCalculator.pi();
                    }
                    case E -> {
                        isOperatorClicked = true;
                        mainCalculator.e();
                    }
                    case ZERO, DECIMAL -> {
                        // This case handles number button 0 and decimal point button
                        if (!mainLabel.getText().equals("")) {
                            mainLabel.setText(mainLabel.getText() + text);
                        }
                    }
                }
            }
        });
        return btn;
    }
}

