/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FreezePeaShooter extends Plant {


    private Timer shootFreezePea;

    /**
     *
     * @param x
     * @param row
     * @param g game panel
     *          first call super and set health , price ,x,row and gamePanel
     *          then make new Timer to shoot FreezePea
     *          and get rows from gamePanel
     *          and finally start shoot
     */
    protected FreezePeaShooter(int x, int row, GamePanel g) {
        super(100, 175, x, row, g);
        shootFreezePea = new Timer(1000, (ActionEvent e) -> {
            FreezePea fp = new FreezePea(g, 60 + x * 100, row);
            g.getRowPeas(row).add(fp);
//            gamePanel.add(fp, new Integer(0));
        });
        shootFreezePea.start();
    }

    /**
     * getter of price
     * @return price of plant
     */
    public static int getPrice (){
        return 175;
    }
}
