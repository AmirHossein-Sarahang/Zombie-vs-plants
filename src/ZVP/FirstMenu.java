/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;

public class FirstMenu extends JPanel {

    protected Image FirstMenuImage;

    public FirstMenu() {
        setSize(1000, 700);
        FirstMenuImage = new ImageIcon(this.getClass().getResource("image/Screenshot_20161214-104326.png")).getImage();
        setVisible(true);


    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage( FirstMenuImage, 0, 0, null);

    }
}




