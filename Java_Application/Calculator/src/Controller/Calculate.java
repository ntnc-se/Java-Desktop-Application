/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.Calculator;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author __ntnc__
 */
public class Calculate {

    Calculator c;

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private BigDecimal memory = new BigDecimal("0");
    //private boolean reset;
    private boolean isMR = false;
    private boolean isProcessing;
    private int operator = -1;

    public Calculate() {
        c = new Calculator();
        c.setVisible(true);

        c.getLblClear().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c.getTxtScreen().setText("0");
                pressClear();
            }
        });

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

        c.getBtnMSUB().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMSub();
                c.getBtnMR().setBackground(Color.red);
            }
        });
        c.getBtnMADD().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressMAdd();
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

        c.getBtnSUB().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(2);
            }
        });
        c.getBtnDIV().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(4);
            }
        });
        c.getBtnADD().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(1);
            }
        });
        c.getBtnMUL().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate();
                setOperator(3);
            }
        });

        c.getBtnSQRT().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressSqrt();
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
        if (isProcessing) {
            c.getTxtScreen().setText("0");
            isProcessing = false;
            //reset = false;
        }
        isMR = false;
        if (c.getTxtScreen().getText().equals("ERROR")) {
            c.getTxtScreen().setText(button.getText());
        } else {
            temp = new BigDecimal(c.getTxtScreen().getText() + value);
            c.getTxtScreen().setText(temp + "");
        }
    }

    public void pressDot() {
        if (isProcessing) {
            c.getTxtScreen().setText("0");
            isProcessing = false;
            //reset = false;
        }
        if (!c.getTxtScreen().getText().contains(".")) {
            c.getTxtScreen().setText(c.getTxtScreen().getText() + ".");
        }
    }

    public void pressClear() {
        firstNumber = new BigDecimal("0");
        secondNumber = new BigDecimal("0");
        operator = -1;
    }

    public BigDecimal getValue() {
        if (isMR) {
            return memory;
        }
        String value = c.getTxtScreen().getText();
        BigDecimal temp;
        try {
            temp = new BigDecimal(value);
        } catch (Exception e) {
            return firstNumber;
        }
        return temp;
    }

    public void calculate() {
        if (!isProcessing) {
            if (operator == -1) {
                firstNumber = getValue();
            } else {
                secondNumber = getValue();
            }
            switch (operator) {
                case 1:
                    // to add value
                    firstNumber = firstNumber.add(secondNumber);
                    break;
                case 2:
                    // to sub value
                    firstNumber = firstNumber.subtract(secondNumber);
                    break;
                case 3:
                    // to multi value
                    firstNumber = firstNumber.multiply(secondNumber);
                    break;
                case 4:
                    // to divide value
                    if (secondNumber.compareTo(BigDecimal.ZERO) == 0) {
                        c.getTxtScreen().setText("ERROR");
                        isProcessing = false;
                        return;
                    } else {
                        firstNumber = firstNumber.divide(secondNumber, 12, RoundingMode.HALF_EVEN);
                        break;
                    }
            }
        }
        c.getTxtScreen().setText(firstNumber + "");
        isProcessing = true;
    }

    public void pressResult() {
        if (!c.getTxtScreen().getText().equals("ERROR")) {
            calculate();
            operator = -1;
        } else {
            c.getTxtScreen().setText(firstNumber + "");
        }
    }

    public void pressSqrt() {
        pressResult();
        BigDecimal result = getValue();
        if (result.doubleValue() >= 0) {
            String display = Math.sqrt(result.doubleValue()) + "";
            if (display.endsWith(".0")) {
                display = display.replace(".0", "");
            }
            c.getTxtScreen().setText(display);
            isProcessing = false;
        } else {
            c.getTxtScreen().setText("ERROR");
        }
        //reset = true;
    }

    public void pressNegate() {
        // pressResult();
        c.getTxtScreen().setText(getValue().negate() + "");
        isProcessing = false;
        //reset = true;
    }

    public void pressPercent() {
        // pressResult();
        c.getTxtScreen().setText(getValue().doubleValue() / 100 + "");
        isProcessing = false;
        //reset = true;
    }

    public void pressInvert() {
        //  pressResult();
        double result = getValue().doubleValue();
        if (result != 0) {
            c.getTxtScreen().setText((1 / result) + "");
            isProcessing = false;
        } else {
            c.getTxtScreen().setText("ERROR");
        }
        //reset = true;
    }

    public void pressMR() {
        c.getTxtScreen().setText(memory + "");
        isMR = true;
    }

    public void pressMC() {
        memory = new BigDecimal("0");
    }

    public void pressMAdd() {
        memory = memory.add(getValue());
        isProcessing = false;
        //reset = true;
    }

    public void pressMSub() {
        memory = memory.add(getValue().negate());
        isProcessing = false;
        //reset = true;
    }
}
