/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;

/**
 * a panel which keeps a plant
 */
public class PlantPanel extends JPanel {

    private Plant plant;

    /**
     * makes a new plant panel
     */
    public PlantPanel (){
        setOpaque(false);
        setSize(100,120);
    }

    /**
     * sets the plant of the panel
     * @param p the plant we want to set
     */
    public void setPlant (Plant p){
        plant = p;
    }

    /**
     * @return the plant
     */
    public Plant getPlant (){
        return plant;
    }

//    public void paintComponent (Graphics g){
//        if (plant!=null){
//            if (plant instanceof SunFlower)
//                g.drawImage(im.SunflowerImage, 0, 0,null);
//            if (plant instanceof PeaShooter)
//                g.drawImage(im.PeashooterImage, 0, 0,null);
//            if (plant instanceof FreezePeaShooter)
//                g.drawImage(im.FreezePeashooterImage, 0, 0,null);
//            if (plant instanceof GiantWall)
//                g.drawImage(im.GiantImage, 0, 0,null);
//            if (plant instanceof CherryBomb)
//                g.drawImage(im.CherryBombImage, 0, 0,null);
//        }
//    }

}

