/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Calculator;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.JButton;

/**
 *
 * @author __ntnc__
 */
public class Calculate_ntnc {

    Calculator c;
    // define the first number 
    private BigDecimal firstNumber;
    // define the second number
    private BigDecimal secondNumber;
    // define value for memory to save value
    private BigDecimal memory = new BigDecimal("0");
    // define whenever cal is processing or not
    private boolean isProcessing;
    // define memory is saving or not
    //private boolean isMR = false;
    // define reset for remain buttons
    //private boolean reset;
    // define + - x :
    private int operator = -1;

    public Calculate_ntnc() {
        c = new Calculator();
        c.setVisible(true);

        // press clear label
        c.getLblClear().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c.getTxtScreen().setText("0");
                pressClear();
            }
        });

        // press number and dot
        c.getBtn0().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn0());
            }
        });
        c.getBtn1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn1());
            }
        });
        c.getBtn2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn2());
            }
        });
        c.getBtn3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn3());
            }
        });
        c.getBtn4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn4());
            }
        });
        c.getBtn5().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn5());
            }
        });
        c.getBtn6().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn6());
            }
        });
        c.getBtn7().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn7());
            }
        });
        c.getBtn8().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn8());
            }
        });
        c.getBtn9().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNumber(c.getBtn9());
            }
        });
        c.getBtnDot().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressDot();
            }
        });

        // press m+, m-, mc, mr
        c.getBtnMSUB().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMSUB();
                c.getBtnMR().setBackground(Color.red);
            }
        });
        c.getBtnMADD().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMADD();
                c.getBtnMR().setBackground(Color.red);
            }
        });
        c.getBtnMC().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMC();
                c.getBtnMR().setBackground(new Color(255, 153, 0));
            }
        });
        c.getBtnMR().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMR();
            }
        });

        // press operation
        c.getBtnSUB().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(1);
            }
        });
        c.getBtnDIV().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(3);
            }
        });
        c.getBtnADD().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(0);
            }
        });
        c.getBtnMUL().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(2);
            }
        });

        // press function
        c.getBtnSQRT().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressSQRT();
            }
        });
        c.getBtnNegate().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressNegate();
            }
        });
        c.getBtnPercent().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressPercent();
            }
        });
        c.getBtnInvert().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressInvert();
            }
        });

        // press = 
        c.getBtnResult().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressResult();
            }
        });
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void pressNumber(JButton button) {
        BigDecimal temp;
        String value = button.getText();
        if (isProcessing || c.getTxtScreen().getText().equals("Error")) {
            c.getTxtScreen().setText(value);
            isProcessing = false;
            //reset = false;
        } //isMR = false;
        else {
            temp = new BigDecimal(c.getTxtScreen().getText() + value);
            c.getTxtScreen().setText(temp + "");
        }
    }

//    public void pressNumber(JButton button){
//        BigDecimal temp;
//        String value = button.getText();
//        if(isProcessing||reset){
//            c.getTxtScreen().setText("0");
//            isProcessing=false;
//            reset= false;
//        }
//        isMR= false;
//        if(c.getTxtScreen().getText().equals("Error")){
//           c.getTxtScreen().setText(value);
//        }
//        else{
//            temp = new BigDecimal(c.getTxtScreen().getText()+value);
//            c.getTxtScreen().setText(temp+"");
//        }
//    }
    public BigDecimal getValue() {
//        if (isMR) {
//            return memory;
//        }
        BigDecimal temp;
        try {
            temp = new BigDecimal(c.getTxtScreen().getText());
            return temp;
        } catch (Exception e) {
            return firstNumber;
        }
    }

//    public BigDecimal getValue(){
//        if(isMR){
//            return memory;
//        }
//        BigDecimal temp;
//        try{
//            temp= new BigDecimal(c.getTxtScreen().getText());
//        }catch(Exception e){
//            return firstNumber;
//        }
//        return temp;
//    }
    public void calculate() {
        if (!isProcessing) {
            if (operator == -1) {
                firstNumber = getValue();
            } else {
                secondNumber = getValue();
            }
            switch (operator) {
                case 0:
                    firstNumber = firstNumber.add(secondNumber, MathContext.DECIMAL32);
                    break;
                case 1:
                    firstNumber = firstNumber.subtract(secondNumber, MathContext.DECIMAL32);
                    break;
                case 2:
                    firstNumber = firstNumber.multiply(secondNumber, MathContext.DECIMAL32);
                    break;
                case 3:
                    if (secondNumber.compareTo(BigDecimal.ZERO) == 0) {
                        c.getTxtScreen().setText("Error");
                        isProcessing = false;
                        return;
                    } else {
                        try {
                            firstNumber = firstNumber.divide(secondNumber, MathContext.DECIMAL32);
                        } catch (ArithmeticException e) {
                            firstNumber = firstNumber.divide(secondNumber, 12, RoundingMode.CEILING);
                        }
                        break;
                    }
            }
        }
        c.getTxtScreen().setText(firstNumber + "");
        isProcessing = true;
    }

    public void pressDot() {
        if (isProcessing) {
            c.getTxtScreen().setText("0.");
            isProcessing = false;
            //reset = false;
        }
//        if(isProcessing==true){
//            c.getTxtScreen().setText("0.");
//        }
        if (!c.getTxtScreen().getText().contains(".")) {
            c.getTxtScreen().setText(c.getTxtScreen().getText() + ".");
        }
    }

    public void pressResult() {
        if (!c.getTxtScreen().getText().equals("Error")) {
            calculate();
            operator = -1;
        } else {
            c.getTxtScreen().setText(firstNumber + "");
        }
    }

    public void pressMC() {
        memory = new BigDecimal("0");
    }

    public void pressMR() {
        c.getTxtScreen().setText(memory + "");
        //isMR = true;
    }

    public void pressMADD() {
        memory = memory.add(getValue());
        isProcessing = true;
        //reset = true;
    }

    public void pressMSUB() {
        memory = memory.add(getValue().negate());
        isProcessing = true;
        //reset = true;
    }

    public void pressNegate() {
        //pressResult();
        c.getTxtScreen().setText(getValue().negate() + "");
        isProcessing = true;
        //reset = true;
    }

    public void pressSQRT() {
        //pressResult();
        BigDecimal result = getValue();
        if (result.doubleValue() >= 0) {
            String display = Math.sqrt(result.doubleValue()) + "";
//            if (display.endsWith(".0")) {
//                display = display.replace(".0", "");
//            }
//            String regex = "^(\\d+\\.\\d*?[1-9])0+$";
            display = display.replaceAll(".0+", "");
            c.getTxtScreen().setText(display);
            isProcessing = true;
            //reset = true;
        } else {
            isProcessing = true;
            c.getTxtScreen().setText("Error");
        }
    }

    public void pressPercent() {
        //pressResult();
        c.getTxtScreen().setText(getValue().doubleValue() / 100 + "");
        isProcessing = true;
        //reset = true;
    }

    public void pressInvert() {
        //pressResult();
        double result = getValue().doubleValue();
        if (result != 0) {
            c.getTxtScreen().setText(1 / result + "");
            isProcessing = true;
            //reset = true;
        } else {
            isProcessing = true;
            c.getTxtScreen().setText("Error");
        }
    }

    public void pressClear() {
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        operator = -1;
    }
}
