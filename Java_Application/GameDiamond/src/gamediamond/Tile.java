/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamediamond;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author HH
 */
public class Tile extends JFrame {

    // create button tile is every button on the screen
    JButton tile = new JButton();
    private int x, y, sizeTile = 60;
    private int tileType;// include: character, diamond, trap, rock, movable, grass

    Icon iconCharacter = new ImageIcon("D:\\character.png");
    Icon iconDiamond = new ImageIcon("D:\\diamond.png");
    Icon iconTrap = new ImageIcon("D:\\trap.png");
    Icon iconRock = new ImageIcon("D:\\brick.png");
    Icon iconMovable = new ImageIcon("D:\\dot.png");
    Icon iconGrass = new ImageIcon("D:\\grass.png");
    
    public Tile(int x, int y, int tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;

        // set position and size of button
        tile.setBounds(x, y, sizeTile, sizeTile);
        
        switch (tileType) {
            case 0: // character position
                tile.setIcon(iconCharacter);
                break;
            case 1: // position can move
                tile.setIcon(iconMovable);
                break;
            case 2: // grass position
                tile.setIcon(iconGrass);
                break;
            case 3: // brick position
                tile.setIcon(iconRock);
                break;
            case 4: // trap position
                tile.setIcon(iconTrap);
                break;
            case 5: // diamond position
                tile.setIcon(iconDiamond);
                break;     
        }
    }

    public JButton getTile() {
        return tile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSizeTile() {
        return sizeTile;
    }

    public int getTileType() {
        return tileType;
    }

    public void setTile(JButton tile) {
        this.tile = tile;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSizeTile(int sizeTile) {
        this.sizeTile = sizeTile;
    }

    public void setTileType(int tileType) {
        this.tileType = tileType;
        
        switch (tileType) {
            case 0: // character position
                tile.setIcon(iconCharacter);
                break;
            case 1: // position can move
                tile.setIcon(iconMovable);
                break;
            case 2: // grass position
                tile.setIcon(iconGrass);
                break;
            case 3: // brick position
                tile.setIcon(iconRock);
                break;
            case 4: // trap position
                tile.setIcon(iconTrap);
                break;
            case 5: // diamond position
                tile.setIcon(iconDiamond);
                break;     
        }
    }    
}
