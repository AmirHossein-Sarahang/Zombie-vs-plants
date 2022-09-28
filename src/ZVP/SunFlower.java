/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class SunFlower extends Plant {

    private Timer MakeSun;

    /**
     * call super and set health , price x ,row ,g
     * @param x x plant
     * @param row row of plant
     * @param g GamePanel
     *          make new Timer to make sun
     *          and make new sun too
     *          then add sun to suns list
     *          finally add tp panel and start make sun
     */
    public SunFlower(int x, int row, GamePanel g) {
        super(50,50, x , row , g);
        MakeSun = new Timer(/*(g.isNormal()?20000:25000)*/5000, (ActionEvent e) -> {
            Sun sta = new Sun(g, 60 + x * 100, 110 + row * 120, 130 + row * 120);
            g.getSuns().add(sta);
            g.add(sta, new Integer(1));
        });
        MakeSun.start();
    }

    /**
     * getter of price
     * @return price of SunFlower
     */
    public static int getPrice (){
        return 50;
    }
}
