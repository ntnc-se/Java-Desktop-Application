
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author __ntnc__
 */
public class Controller {

    private GUI g;

    // declare timer like a thread
    private Timer timer;
    // declare size of matrix buttons
    private int sizeOfMatrix;
    // declare matrix of button
    private JButton[][] matrix;
    private boolean isGameStarted = false;
    private int numbersOfMove = 0;

    public Controller() {
        // create new frame
        g = new GUI();
        g.setVisible(true);
        g.setResizable(false);
        g.setLocationRelativeTo(null);

        // create a screen like requirement
        addButton();

        g.getBtnStart().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGame();
            }
        });
    }

    public void countTime() {
        g.getLblTime().setText("0");
        timer = new Timer(1000, new ActionListener() {
            int second = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                g.getLblTime().setText(String.valueOf(second));
            }
        });
        timer.start();
    }

    public void run() {
        this.countTime();
        this.addButton();
        isGameStarted = true;
    }

    public void addButton() {
        // size of gap, width is variable
        // size button, num*size + (num-1)* gap
        // 123, 71, 42,
        // check win
        sizeOfMatrix = g.getCbxSize().getSelectedIndex() + 3;
        g.getPnScreen().removeAll();
        g.getPnScreen().setLayout(new GridLayout(sizeOfMatrix, sizeOfMatrix, 10, 10));
        g.getPnScreen().setPreferredSize(new Dimension(sizeOfMatrix * 60 + 10 * (sizeOfMatrix - 1), sizeOfMatrix * 60 + 10 * (sizeOfMatrix - 1)));

        //g.getPnScreen().setSize(sizeOfMatrix * 60 + 5, sizeOfMatrix * 60 + 5);
        matrix = new JButton[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                JButton btn = new JButton(i * sizeOfMatrix + j + 1 + "");
                matrix[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isGameStarted) {
                            // check button can move to the next or not
                            if (canMoved(btn)) {
                                moveButton(btn);
                                numbersOfMove++;
                                g.getLblMove().setText(numbersOfMove + "");
                                if (isWon()) {
                                    isGameStarted = false;
                                    JOptionPane.showMessageDialog(null, "You won!");
                                    timer.stop();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Press New Game to start");
                        }
                    }
                });
                g.getPnScreen().add(btn);
            }
        }
        matrix[sizeOfMatrix - 1][sizeOfMatrix - 1].setText("");
        randomMatrix();
        g.pack();
    }

    public void randomMatrix() {
        for (int i = 0; i < 500; i++) {
            Point p = getPosition();
            int x = p.x;
            int y = p.y;
            Random r = new Random();
            int n = r.nextInt(4);
            switch (n) {
                case 0://up
                    if (y > 0) {
                        matrix[x][y].setText(matrix[x][y - 1].getText());
                        matrix[x][y - 1].setText("");
                    }
                    break;
                case 1:
                    if (y < sizeOfMatrix - 1) {
                        matrix[x][y].setText(matrix[x][y + 1].getText());
                        matrix[x][y + 1].setText("");
                    }
                    break;
                case 2:
                    if (x > 0) {
                        matrix[x][y].setText(matrix[x - 1][y].getText());
                        matrix[x - 1][y].setText("");
                    }
                    break;
                case 3:
                    if (x < sizeOfMatrix - 1) {
                        matrix[x][y].setText(matrix[x + 1][y].getText());
                        matrix[x + 1][y].setText("");
                    }
                    break;
            }
        }
    }

    public Point getPosition() {
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (matrix[i][j].getText().equals("")) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

//123
//457
//86
//
//128
//457
//63
    public void moveButton(JButton btn) {
        Point p = getPosition();
        matrix[p.x][p.y].setText(btn.getText());
        btn.setText("");
    }

    public boolean canMoved(JButton btn) {
        if (btn.getText().equals("")) {
            return false;
        }
        Point p = getPosition();
        Point p1 = null;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (matrix[i][j].getText().equals(btn.getText())) {
                    p1 = new Point(i, j);
                }
            }
        }
        if (p.x == p1.x && Math.abs(p.y - p1.y) == 1) {
            return true;
        }
        if (p.y == p1.y && Math.abs(p.x - p1.x) == 1) {
            return true;
        }
        return false;
    }

    public boolean isWon() {
        if (!matrix[sizeOfMatrix - 1][sizeOfMatrix - 1].getText().equals("")) {
            return false;
        }
        int a = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                a++;
                if ((i == sizeOfMatrix - 1) && (j == sizeOfMatrix - 1)) {
                    return true;
                } else if (!matrix[i][j].getText().equals(a + "")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void newGame() {
        if (isGameStarted) {
            timer.stop();
            int confirm = JOptionPane.showConfirmDialog(null, "Do you"
                    + " want to make a new game?", "New Game", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                numbersOfMove = 0;
                g.getLblMove().setText("0");
                this.run();
            } else if (confirm == JOptionPane.NO_OPTION) {
                timer.start();
            }
        } else {
            this.run();
        }
    }
}
