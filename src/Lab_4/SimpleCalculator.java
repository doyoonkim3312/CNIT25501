package Lab_4;

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

    public CalculatorFrame() {
        super("Simple Calculator");
        setBounds(new Rectangle(500, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainLabel.setPreferredSize(new Dimension(290, 70));
        mainLabel.setOpaque(true);  //setOpaque value should be ture in order to apply the background color
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBackground(Color.white);

        LinearLayoutPanel topLineOperators = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers1 = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers2 = new LinearLayoutPanel(Orient.HORIZONTAL);
        LinearLayoutPanel numbers3 = new LinearLayoutPanel(Orient.HORIZONTAL);

        JButton clear = operatorBtnFactory("AC", Operator.CLEAR);
        JButton sign = operatorBtnFactory("+/-", Operator.SIGN);
        JButton percentage = operatorBtnFactory("%", Operator.PERCENTAGE);
        JButton divide = operatorBtnFactory("/", Operator.DIVIDE);

        JButton number1 = numberBtnFactory("1");
        JButton number2 = numberBtnFactory("2");
        JButton number3 = numberBtnFactory("3");
        numbers3.add(number1, number2, number3);

        JButton number4 = numberBtnFactory("4");
        JButton number5 = numberBtnFactory("5");
        JButton number6 = numberBtnFactory("6");
        numbers2.add(number4, number5, number6);

        JButton number7 = numberBtnFactory("7");
        JButton number8 = numberBtnFactory("8");
        JButton number9 = numberBtnFactory("9");
        numbers1.add(number7, number8, number9);


        mainPanel.add(mainLabel);
        mainPanel.add(numbers1.inflate());
        mainPanel.add(numbers2.inflate());
        mainPanel.add(numbers3.inflate());



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
                mainLabel.setText(mainLabel.getText() + ((JButton) e.getSource()).getText());
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
                    case PLUS:{}
                    case MINUS: {}
                    case MULTIPLY: {}
                    case DIVIDE: {
                        mainLabel.setText("DIVIDD");
                    }
                }
            }
        });
        return btn;
    }
}

