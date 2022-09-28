
/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */
package ZVP;
import javax.swing.*;
import java.awt.*;

public class Bullet extends JPanel {

        private Image image;

        private int harm;
        private GamePanel gamePanel;
        private int x;
        private int y;
        private int row;
        private double speed;

    /**
     * set
     * @param gamePanel game panel
     * @param x x
     * @param row row
     * @param harm harm
     */
        public Bullet (GamePanel gamePanel, int x, int row, int harm){
            this.gamePanel = gamePanel;
            this.x = x;
            y = 130 + (row * 120);
            this.harm = harm;
            speed =3;
        }

    /**
     *
     * @param image to set bukket image
     */
        public void setImage (Image image){
            this.image = image;
        }

    /**
     * getter of x
     * @return x
     */
        public int getX (){
            return x;
        }

    /**
     *
     * @return
     */
        public Zombie attack (){
            Zombie z = null;
//            for (int i = 0; i < gamePanel.getRowZombies(row).size(); i++) {
//                z = gamePanel.getRowZombies(row).get(i);
//                if (x == z.getX()) {
//                    z.setHealth(z.getHealth() - harm);
//                    if (z.getHealth() < 0) {
//                        System.out.println("Zombie died");
//                        gamePanel.getRowZombies(row).remove(i);
////                        GamePanel.setProgress(10);
//                        return null;
//                    }
//                    gamePanel.getRowPeas(row).remove(this);
//                    break;
//                }
//            }
            x += 14;
            setLocation(x,y);
            return z;
        }

    /**
     *
     * @param g tp draw image
     */
        public void paintComponent (Graphics g){
            g.drawImage(image,0,0,null);
        }

    /**
     * getter of row
     * @return row
     */
        public int getRow (){
            return row;
        }

}
