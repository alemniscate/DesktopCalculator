package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator extends JFrame {

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
//        setLayout(null);
        setVisible(true);
        setTitle("Calculator");
        Font numFont = new Font("MS Gothic", Font.PLAIN, 30);
        Font delFont = new Font("MS Gothic", Font.BOLD, 20);
        Font equationFont = new Font("MS Gothic", Font.PLAIN, 20);

        JPanel textPanel = new JPanel();
        JLabel resultLabel = new JLabel();
        resultLabel.setFont(numFont);
        resultLabel.setPreferredSize(new Dimension(250, 50));
        resultLabel.setName("ResultLabel");

        JLabel equationLabel = new JLabel();
        equationLabel.setName("EquationLabel");
        equationLabel.setPreferredSize(new Dimension(250, 20));
        equationLabel.setFont(equationFont);

        textPanel.setLayout(new GridLayout(2,1));
        textPanel.add(resultLabel);
        textPanel.add(equationLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6,4));

        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton badd = new JButton("+");
        JButton bsub = new JButton("-");
        JButton bmul = new JButton("×");
        JButton bdiv = new JButton("÷");
        JButton bequ = new JButton("=");
        JButton bclr = new JButton("C");
        JButton bdel = new JButton("Del");
        JButton bdot = new JButton(".");
        JButton bpar = new JButton("()");
        JButton bsqr = new JButton("√");
        JButton bpow2 = new JButton("x²");
        JButton bpowy = new JButton("xⁿ");
        JButton bpm = new JButton("±");
        JButton bce = new JButton("CE");

        b0.setName("Zero");
        b1.setName("One");
        b2.setName("Two");
        b3.setName("Three");
        b4.setName("Four");
        b5.setName("Five");
        b6.setName("Six");
        b7.setName("Seven");
        b8.setName("Eight");
        b9.setName("Nine");
        badd.setName("Add");
        bsub.setName("Subtract");
        bmul.setName("Multiply");
        bdiv.setName("Divide");
        bequ.setName("Equals");
        bclr.setName("Clear");
        bdel.setName("Delete");
        bdot.setName("Dot");
        bpar.setName("Parentheses");
        bsqr.setName("SquareRoot");
        bpow2.setName("PowerTwo");
        bpowy.setName("PowerY");
        bpm.setName("PlusMinus");

        b0.setFont(numFont);
        b1.setFont(numFont);
        b2.setFont(numFont);
        b3.setFont(numFont);
        b4.setFont(numFont);
        b5.setFont(numFont);
        b6.setFont(numFont);
        b7.setFont(numFont);
        b8.setFont(numFont);
        b9.setFont(numFont);
        badd.setFont(numFont);
        bsub.setFont(numFont);
        bmul.setFont(numFont);
        bdiv.setFont(numFont);
        bequ.setFont(numFont);
        bclr.setFont(numFont);
        bdot.setFont(numFont);
        bdel.setFont(delFont);
        bpar.setFont(numFont);
        bsqr.setFont(numFont);
        bpow2.setFont(numFont);
        bpowy.setFont(numFont);
        bpm.setFont(numFont);
        bce.setFont(numFont);

        buttonPanel.add(bpar);
        buttonPanel.add(bce);
        buttonPanel.add(bclr);
        buttonPanel.add(bdel);
        buttonPanel.add(bpow2);
        buttonPanel.add(bpowy);
        buttonPanel.add(bsqr);
        buttonPanel.add(bdiv);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(bmul);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(badd);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(bsub);
        buttonPanel.add(bpm);
        buttonPanel.add(b0);
        buttonPanel.add(bdot);
        buttonPanel.add(bequ);

        Container contentPane = getContentPane();
        contentPane.add(textPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        Equation eq = new Equation();
        b0.addActionListener(e -> eq.push("0", equationLabel));
        b1.addActionListener(e -> eq.push("1", equationLabel));
        b2.addActionListener(e -> eq.push("2", equationLabel));
        b3.addActionListener(e -> eq.push("3", equationLabel));
        b4.addActionListener(e -> eq.push("4", equationLabel));
        b5.addActionListener(e -> eq.push("5", equationLabel));
        b6.addActionListener(e -> eq.push("6", equationLabel));
        b7.addActionListener(e -> eq.push("7", equationLabel));
        b8.addActionListener(e -> eq.push("8", equationLabel));
        b9.addActionListener(e -> eq.push("9", equationLabel));
        badd.addActionListener(e -> eq.push("+", equationLabel));
        bsub.addActionListener(e -> eq.push("-", equationLabel));
        bmul.addActionListener(e -> eq.push("×", equationLabel));
        bdiv.addActionListener(e -> eq.push("÷", equationLabel));
        bdot.addActionListener(e -> eq.push(".", equationLabel));
        bsqr.addActionListener(e -> eq.push("√(", equationLabel));
        bpow2.addActionListener(e -> eq.push("^(2)", equationLabel));
        bpowy.addActionListener(e -> eq.push("^(", equationLabel));
        bpm.addActionListener(e -> eq.negate(equationLabel));

        bpar.addActionListener(e -> eq.Parentheses(equationLabel));
        bclr.addActionListener(e -> eq.clear(equationLabel, resultLabel));
        bdel.addActionListener(e -> eq.delete(equationLabel));
        bce.addActionListener(e -> eq.clearError(equationLabel, resultLabel));
        bequ.addActionListener(e -> eq.solve(equationLabel, resultLabel));
    }
}

class Equation {

    void negate(JLabel equationLabel) {
        String equation = equationLabel.getText().trim();
        if ("".equals(equation)) {
            equation = "(-";
        } else if ("√((-".equals(equation)) {
            equation = "√(";
        } else if ("√(".equals(equation)) {
            equation = "√((-";
        } else if (equation.startsWith("(-")) {
            equation = equation.substring(2);
        } else {
            equation = "(-" + equation;
        }
        equationLabel.setForeground(Color.BLACK);
        equationLabel.setText(equation);
    }

    void Parentheses(JLabel equationLabel) {
        String equation = equationLabel.getText().trim();
        long lcount = equation.chars().filter(ch -> ch == '(').count();
        long rcount = equation.chars().filter(ch -> ch == ')').count();
        if (lcount == rcount) {
            equation += "(";
        } else {
            String endChar = getEndChar(equation);
            if ("(".equals(endChar) || isOperator(endChar)) {
                equation += "(";
            } else {
                equation += ")";
            }
        }
        equationLabel.setForeground(Color.BLACK);
        equationLabel.setText(equation);
    }

    void push(String button ,JLabel equationLabel) {
//        System.out.print(button);
        try {
            Thread.sleep(10); // wait 10 mili seconds
        } catch (InterruptedException e) {}
        String equation = equationLabel.getText().trim();
        if ("".equals(equation)) {
            if (isOperator(button)) {
                return;
            }
        } else {
            if (isOperator(button)) {
                if (isOperator(getEndChar(equation))) {
                    equation = cutEndChar(equation);
                }
                if (equation.startsWith(".")) {
                    equation = "0" + equation; 
                }        
                if (equation.endsWith(".")) {
                    equation += "0"; 
                }        
            }
        }
        equationLabel.setForeground(Color.BLACK);
        equationLabel.setText(equation + button);
    }

    String getEndChar(String s) {
        return s.substring(s.length() - 1, s.length());
    }

    String cutEndChar(String s) {
        return s.substring(0, s.length() - 1);
    }

    boolean isOperator(String button) {
        if ("+".equals(button) || "-".equals(button) || "×".equals(button) || "÷".equals(button)) {
            return true;
        }
        return false;
    }

    void clear(JLabel equationLabel, JLabel resultLabel) {
        equationLabel.setForeground(Color.BLACK);
        equationLabel.setText("");
        resultLabel.setText("");
    }
    
    void clearError(JLabel equationLabel, JLabel resultLabel) {
        equationLabel.setForeground(Color.BLACK);
        resultLabel.setText("");
    }

    void delete(JLabel equationLabel) {
        String equation = equationLabel.getText().trim();
        if (equation.length() == 0) {
            return;
        }
        equationLabel.setForeground(Color.BLACK);
        equationLabel.setText(equation.substring(0, equation.length() - 1));
    }

    void solve(JLabel equationLabel, JLabel resultLabel) {
//        System.out.println();
        String equation = equationLabel.getText().trim();
        if ("".equals(equation)) {
            return;
        }
        if (equation.endsWith(".")) {
            equation += "0";
            equationLabel.setText(equation);
        }
        String endChar = getEndChar(equation);
        if (isOperator(endChar)) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        }    
        if (equation.matches(".*?÷0.*")) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        }
        long lcount = equation.chars().filter(ch -> ch == '(').count();
        long rcount = equation.chars().filter(ch -> ch == ')').count();
        if (lcount != rcount) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        }

        java.util.List<Token> tokens = buildToken(equation);
        java.util.List<Token> rpn = buildRpn(tokens);
        double answer = calc(rpn);
        if (Double.isNaN(answer)) {
            equationLabel.setForeground(Color.RED.darker());
            return;
        }
        String strAnswer = "" + answer;
        if (strAnswer.endsWith(".0")) {
            strAnswer = strAnswer.substring(0, strAnswer.length() - 2);
        }
        resultLabel.setText(strAnswer);
    }

    java.util.List<Token> buildToken(String equation) {
        java.util.List<Token> tokens = new ArrayList<>();
        TokenType type = null;
        int priority = -1;
        String operand = "";
        String operator = "";
        for (int i = 0; i < equation.length();) {
            type = null;
            priority = -1;
            operand = "";
            operator = "";
            while (i < equation.length()) {
                char ch = equation.charAt(i);
                switch (ch) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '.':
                        operand += ch;
                        break;
                    case '+':
                    case '-':
                        type = TokenType.OPERATOR;
                        priority = 1;
                        operator = "" + ch;
                        break;
                    case '×':
                    case '÷':
                        type = TokenType.OPERATOR;
                        priority = 2;
                        operator = "" + ch;
                        break;
                    case '(':
                        type = TokenType.LPARENTHESES;
                        priority = -1;
                        operator = "" + ch;
                        break;
                    case ')':
                        type = TokenType.RPARENTHESES;
                        priority = -1;
                        operator = "" + ch;
                        break;
                    case '√': 
                        type = TokenType.FUNCTION;
                        priority = 3;
                        operator = "" + ch;
                        break;
                    case '^': 
                        type = TokenType.FUNCTION;
                        priority = 3;
                        operator = "" + ch;
                        break;
                }
                i++;
                if (!"".equals(operator)) {
                    if (!"".equals(operand)) {
                        tokens.add(new Token(TokenType.OPERAND, -1, Double.parseDouble(operand), ""));
                    }

                    tokens.add(new Token(type, priority, 0, operator));
                    operand = "";
                    break;
                }
            }
        }
        if (!"".equals(operand)) {
            tokens.add(new Token(TokenType.OPERAND, -1, Double.parseDouble(operand), ""));
        }
        return tokens;
    }

    java.util.List<Token> buildRpn(java.util.List<Token> tokens) {
        java.util.List<Token> rpn = new ArrayList<>();
        Stack<Token> stack = new Stack<>();
        Token prevToken = null;
        for (Token token: tokens) {
            switch (token.type) {
                case OPERAND:
                    rpn.add(token);
                    break;
                case OPERATOR:
                case FUNCTION:
                    if (stack.isEmpty()) {
                        stack.push(token);
                        break;
                    }
                    prevToken = stack.peek();
                    if (token.priority <= prevToken.priority) {
                        rpn.add(stack.pop());                        
                    }
                    stack.push(token);
                    break; 
                case LPARENTHESES:
                    stack.push(token);
                    break;
                case RPARENTHESES:
                    while (!stack.isEmpty()) {
                        if (stack.peek().type == TokenType.LPARENTHESES) {
                            stack.pop();
                            break;
                        }
                        rpn.add(stack.pop());
                    }
            } 
        }
        while (!stack.isEmpty()) {
            rpn.add(stack.pop());
        }
        return rpn;
    }

    double calc(java.util.List<Token> rpn) {
        Stack<Double> stack = new Stack<>();
        for (Token token: rpn) {
            double a = 0;
            double b = 0;
            double answer = 0;
            switch (token.type) {
                case OPERAND:
                    stack.push(token.operand);
                    break;
                case OPERATOR:
                    b = stack.pop();
                    if ("-".equals(token.operator) && stack.isEmpty()) {
                        stack.push(-b);
                        break;
                    }
                    a = stack.pop();
                    switch (token.operator) {
                        case "+":
                            answer = a + b;
                            break;
                        case "-":
                            answer = a - b;
                            break;
                        case "×":
                            answer = a * b;
                            break;
                        case "÷":
                            answer = a / b;
                            break;
                    }
                    stack.push(answer);
                    break;
                case FUNCTION:
                    a = stack.pop();
                    switch (token.operator) {
                        case "√":
                            answer = Math.sqrt(a);
                            break;
                        case "^":
                            b = stack.pop();
                            answer = Math.pow(b, a);
                            break;
                    }
                    stack.push(answer);
                    break;        
            }
        }
        return stack.pop();
    }
}

enum TokenType {OPERATOR, LPARENTHESES, RPARENTHESES, FUNCTION, OPERAND}

class Token {
    TokenType type;
    int priority;
    double operand;
    String operator;

    Token(TokenType type, int priority, double operand, String operator) {
        this.type = type;
        this.priority = priority;
        this.operand = operand;
        this.operator = operator;
    }
}