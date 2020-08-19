
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
public class Controller_ntnc {

    private GUI g;

    private int sizeOfMatrix;
    private JButton[][] matrix;
    private Timer timer;
    private int numberOfMove = 0;
    private boolean isGameStarted = false;
    private final int BUTTON_SIZE = 60;
    private final int GAP = 10;

    public Controller_ntnc() {
        g = new GUI();
        g.setVisible(true);
        g.setResizable(false);
        g.setLocationRelativeTo(null);

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
                g.getLblTime().setText(second + "");
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
        sizeOfMatrix = g.getCbxSize().getSelectedIndex() + 3;
        g.getPnScreen().removeAll();
        g.getPnScreen().setLayout(new GridLayout(sizeOfMatrix, sizeOfMatrix, GAP, GAP));
        g.getPnScreen().setPreferredSize(new Dimension(sizeOfMatrix * BUTTON_SIZE
                + (sizeOfMatrix - 1) * GAP, sizeOfMatrix * BUTTON_SIZE + (sizeOfMatrix - 1) * GAP));
        matrix = new JButton[sizeOfMatrix][sizeOfMatrix];
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                JButton button = new JButton(i * sizeOfMatrix + j + 1 + "");
                matrix[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isGameStarted) {
                            if (canMoved(button)) {
                                moveButton(button);
                                numberOfMove++;
                                g.getLblMove().setText(numberOfMove + "");
                                if (isWon()) {
                                    isGameStarted = false;
                                    JOptionPane.showMessageDialog(null, "You Won");
                                    timer.stop();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Press new game to start");
                        }
                    }
                });
                g.getPnScreen().add(button);
            }
        }
        matrix[sizeOfMatrix - 1][sizeOfMatrix - 1].setText("");
        randomMatrix();
        g.pack();
    }

    public void randomMatrix() {
        //
        for (int i = 0; i < 500; i++) {
            Point p = getPosition();
            int x = p.x;
            int y = p.y;
            Random r = new Random();
            int n = r.nextInt(4);
            switch (n) {
                // empty button up
                case 0:
                    if (y > 0) {
                        matrix[x][y].setText(matrix[x][y - 1].getText());
                        matrix[x][y - 1].setText("");
                    }
                    break;
                // empty button down
                case 1:
                    if (y < sizeOfMatrix - 1) {
                        matrix[x][y].setText(matrix[x][y + 1].getText());
                        matrix[x][y + 1].setText("");
                    }
                    break;
                // empty button turn left
                case 2:
                    if (x < sizeOfMatrix - 1) {
                        matrix[x][y].setText(matrix[x + 1][y].getText());
                        matrix[x + 1][y].setText("");
                    }
                    break;
                // empty button turn right
                case 3:
                    if (x > 0) {
                        matrix[x][y].setText(matrix[x - 1][y].getText());
                        matrix[x - 1][y].setText("");
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

    public void newGame() {
        if (isGameStarted) {
            timer.stop();
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to "
                    + "start a new game", "New Game", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                numberOfMove = 0;
                g.getLblMove().setText("0");
                this.run();
            } else {
                timer.start();
            }
        } else {
            this.run();
            numberOfMove = 0;
            g.getLblMove().setText("0");
        }
    }

    public boolean isWon() {
        if (!matrix[sizeOfMatrix - 1][sizeOfMatrix - 1].getText().equals("")) {
            return false;
        }
        //int a = 0;
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                //a++;
                //if ((i != sizeOfMatrix - 1) && (j != sizeOfMatrix - 1)) {
                if (!matrix[i][j].getText().equals(i * sizeOfMatrix + j + 1 + "")) {
                    return false;
                    //  }
                }
            }
        }
        return true;
    }
}
