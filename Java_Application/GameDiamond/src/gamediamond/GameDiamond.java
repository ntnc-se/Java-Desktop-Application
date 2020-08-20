/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamediamond;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HH
 */
public class GameDiamond extends JFrame implements ActionListener {

    private int SizeTile = 60;
    public Tile[][] tiles = new Tile[18][10];
    int numberOfRock = 13, numberOfTrap = 13, numberOfDiamond = 13;
    private int x = tiles.length - 1;    //
    private int y = tiles[0].length - 1; // pos of character
    private int score = 0;
    JOptionPane k = new JOptionPane();

    public GameDiamond(String title) {
        initComponent(title);
    }

    public int getRandomInteger(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    public void initComponent(String title) {
        // design window
        this.setSize(1086, 629);
        this.setLayout(null);
        this.setTitle(title);
        this.setVisible(true);
        this.setResizable(false); // user cannot resize window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //design map
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                int tileType = getRandomInteger(0, 8);
                switch (tileType) {
                    case 3://Rocks position
                        if (numberOfRock <= 0) {
                            tileType = 2;
                        }
                        numberOfRock--;
                        break;
                    case 4://Trap position
                        if (numberOfTrap <= 0) {
                            tileType = 2;
                        }
                        numberOfTrap--;
                        break;
                    case 5://Diamonds position
                        if (numberOfDiamond <= 0) {
                            tileType = 2;
                        }
                        numberOfDiamond--;
                        break;
                    default://grass position  
                        tileType = 2;
                }
                tiles[i][j] = new Tile(SizeTile * i, SizeTile * j, tileType);
                this.add(tiles[i][j].getTile());
                tiles[i][j].getTile().addActionListener(this);
            }
        }
        // set position of character 
        tiles[tiles.length - 1][tiles[0].length - 1].setTileType(0);
        tiles[tiles.length - 1][tiles[0].length - 2].setTileType(1);
        tiles[tiles.length - 2][tiles[0].length - 1].setTileType(1);
    }

    void changeMovableArea(int x, int y, int tileType) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 || j == 0) && !(i == 0 && j == 0)) {
                    try {
                        if (isGrass(tiles[x + i][y + j]) || isMovable(tiles[x + i][y + j])) {
                            tiles[x + i][y + j].setTileType(tileType);
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }

    void changeTileType(Tile CurrTile, Tile NextTile) {
        NextTile.setTileType(0);
        CurrTile.setTileType(2);
    }

    boolean canMove(Tile tile) {
        if (isBrick(tile)) {
            return false;
        }
        return true;
    }

    boolean isGrass(Tile tile) {
        if (tile.getTileType() == 2) {
            return true;
        }
        return false;
    }

    boolean isMovable(Tile tile) {
        if (tile.getTileType() == 1) {
            return true;
        }
        return false;
    }

    boolean isBrick(Tile tile) {
        if (tile.getTileType() == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 || j == 0) && !(i == 0 && j == 0)) {
                    try {
                        if (canMove(tiles[x + i][y + j])) {
                            if (e.getSource() == tiles[x + i][y + j].getTile()) {
                                if (tiles[x + i][y + j].getTileType() == 5) {
                                    score += 1;
                                    if (score == 13) {
                                        JOptionPane.showMessageDialog(this, "You WIN !");
                                        System.exit(0);
                                    }
                                }
                                if (tiles[x + i][y + j].getTileType() == 4) {
                                    JOptionPane.showMessageDialog(this, "You LOSE !");
                                    System.exit(0);
                                }
                                changeTileType(tiles[x][y], tiles[x + i][y + j]);
                                changeMovableArea(x, y, 2);
                                x += i;
                                y += j;
                            }
                            changeMovableArea(x, y, 1);
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }
}
