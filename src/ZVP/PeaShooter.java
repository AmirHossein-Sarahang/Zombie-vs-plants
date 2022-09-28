/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PeaShooter extends Plant {

    private Timer shootPea;
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
    public PeaShooter(int x, int row, GamePanel g) {
        super(70,100,x,row,g);
        shootPea = new Timer(1000, (ActionEvent e) -> {
            Pea fp = new Pea(g, 60 + x * 100, row);
            g.getRowPeas(row).add(fp);
//            gamePanel.add(fp, new Integer(0));
        });
        shootPea.start();
    }

    public static int getPrice (){
        return 100;
    }
}
