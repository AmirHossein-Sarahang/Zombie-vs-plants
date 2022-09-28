/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FreezePea extends Bullet {


    /**
     *
     * @param gamePanel game panel
     * @param x
     * @param row
     * first call super by gamePanel,x and row
     * then make new image maker and finally call super again and set FreezePea image
     */
    public FreezePea (GamePanel gamePanel, int x, int row){
        super(gamePanel,x,row,35);
        ImageMaker imageMaker = new ImageMaker();
        super.setImage(imageMaker.getFreezePeaImage());
    }

    /**
     *
     * @return
     */
    public Zombie attack (){
        Zombie z = super.attack();
        if (z != null) {
            //z.setSpeed(getSpeed()/2);
        }
        return null;
    }



}
