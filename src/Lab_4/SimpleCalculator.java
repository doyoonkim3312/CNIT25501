package Lab_4;

// View

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorFrame test = new CalculatorFrame();
            }
        });
    }
}

class CalculatorFrame extends JFrame {
    private Container mainContainer = this.getContentPane();
    private LinearLayoutPanel mainPanel = new LinearLayoutPanel(Orient.VERTICAL);
    private JLabel mainLabel = new JLabel();

    private Calculation mainCalculator = new Calculation(mainLabel);

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

        JButton sqrt = mainCalculator.operatorBtnFactory("√", Operator.SQRT);
        JButton pow = mainCalculator.operatorBtnFactory("x²",Operator.POW);
        JButton pi = mainCalculator.operatorBtnFactory("π", Operator.PI);
        JButton e = mainCalculator.operatorBtnFactory("e", Operator.E);
        higherOperators.add(sqrt, pow, pi, e);

        JButton clear = mainCalculator.operatorBtnFactory("C", Operator.CLEAR);
        JButton sign = mainCalculator.operatorBtnFactory("+/-", Operator.SIGN);
        JButton percentage = mainCalculator.operatorBtnFactory("%", Operator.PERCENTAGE);
        JButton divide = mainCalculator.operatorBtnFactory("/", Operator.DIVIDE);
        topLineOperators.add(clear, sign, percentage, divide);

        JButton number0 = mainCalculator.operatorBtnFactory("0",Operator.ZERO);
        JButton decimal = mainCalculator.operatorBtnFactory(".", Operator.DECIMAL);
        JButton equal = mainCalculator.operatorBtnFactory("=", Operator.EQUAL);
        bottomLineOperators.add(number0, decimal, equal);

        JButton number1 = mainCalculator.numberBtnFactory("1");
        JButton number2 = mainCalculator.numberBtnFactory("2");
        JButton number3 = mainCalculator.numberBtnFactory("3");
        JButton plus = mainCalculator.operatorBtnFactory("+", Operator.PLUS);
        numbers3.add(number1, number2, number3, plus);

        JButton number4 = mainCalculator.numberBtnFactory("4");
        JButton number5 = mainCalculator.numberBtnFactory("5");
        JButton number6 = mainCalculator.numberBtnFactory("6");
        JButton minus = mainCalculator.operatorBtnFactory("-", Operator.MINUS);
        numbers2.add(number4, number5, number6, minus);

        JButton number7 = mainCalculator.numberBtnFactory("7");
        JButton number8 = mainCalculator.numberBtnFactory("8");
        JButton number9 = mainCalculator.numberBtnFactory("9");
        JButton multiply = mainCalculator.operatorBtnFactory("*", Operator.MULTIPLY);
        numbers1.add(number7, number8, number9, multiply);


        mainPanel.add(mainLabel, higherOperators.inflate() ,topLineOperators.inflate(), numbers1.inflate(), numbers2.inflate(),
                numbers3.inflate(), bottomLineOperators.inflate());


        add(mainPanel.inflate());
        pack();
        //setResizable(false);
        setVisible(true);
    }
}

