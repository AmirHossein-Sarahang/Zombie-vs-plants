
/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */
package ZVP;

import javax.swing.*;
import java.awt.*;

/**
 * a single card panel
 */
public class Card extends JPanel {

    //card's image
    Image image;

    /**
     * makes a new card panel
     * @param image
     */
    public Card (Image image){
        this.image = image;
        repaint();
    }

    /**
     *  @Override paintComponent
     * @param g to draw image
     */
    @Override
    public void paintComponent (Graphics g){
        g.drawImage(image,0,0,null);
    }

}
