/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;

public class Mower extends JPanel {

    private GamePanel gamePanel;
    private Image image;
    private int y;
    private int mapY;
    private int x=-35;
    private boolean enable =true;
    private double speed =2;

    /**
     * Mower class is a Panel and first set Opaque to false
     * @param gamePanel
     * @param y
     * second set image
     * and then set :
     * @param gamePanel
     * @param y
     * and finally set location
     */
    public Mower (GamePanel gamePanel, int y){
        setOpaque(false);
        image = new ImageIcon(this.getClass().getResource("image/lawn_mower.gif")).getImage();
        this.gamePanel = gamePanel;
        this.y = y;
        mapY = 150 + y * 120;
        setLocation(x, mapY);
    }

    /**
     *
     * @param g is Graphics element
     *          call super and use paintComponent and give g
     *          and finally draw image by g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    /**
     * Move based on increasing x and set location
     */
    public void mow() {
        if (x < 1000) {
            x += 4;
        } else {
            enable=false;
//            gamePanel.remove(this);
        }
        setLocation(x, 109 + y * 120);
    }

    /**
     *
     * @return boolean enable
     */
    public boolean isEnable (){
        return enable;
    }

    /**
     * getter of image
     * @return image
     */
    public Image getImage (){
        return image;
    }

    /**
     * getter of x
     * @return x
     */
    public int getX (){
        return x;
    }
    /**
     * getter of y
     * @return y
     */
    public int getY (){
        return y;
    }
    /**
     * getter of MapY
     * @return MapY
     */
    public int getMapY (){
        return mapY;
    }

//    public void mow (){
//        gamePanel.clearTheRow(y);
//    }
}
