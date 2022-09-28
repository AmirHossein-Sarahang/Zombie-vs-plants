/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * the panel that keeps our cards
 */
public class PlantCardsPanel extends JPanel {

    private final int height = 90;
    private final int width = 430;
    //the card which is being used: 0->none 1->sunflower 2->peashooter 3->freezepeashooter 4->wallnut 5->cherrybomb
    private int whichCard = 0;

    //images
    private Image sunFlowerCardImage = new ImageIcon(this.getClass().getResource("image/cards/card_sunflower.png")).getImage();
    private Image peaShooterCardImage = new ImageIcon(this.getClass().getResource("image/Cards/card_peashooter.png")).getImage();
    private Image frozenPeaShooterCardImage = new ImageIcon(this.getClass().getResource("image/Cards/card_freezepeashooter.png")).getImage();
    private Image wallNutCardImage = new ImageIcon(this.getClass().getResource("image/Cards/card_wallnut.png")).getImage();
    private Image cherryBombCardImage = new ImageIcon(this.getClass().getResource("image/Cards/card_cherrybomb.png")).getImage();

    //cards
    private Card panel1;
    private Card panel2;
    private Card panel3;
    private Card panel4;
    private Card panel5;

    /**
     * makes the cards panel
     */
    public PlantCardsPanel () {
        setLayout(new GridLayout(1,5));
        setSize(width,height);
        setBackground(new Color(102, 51, 0));
        panel1 = new Card(sunFlowerCardImage);
        panel2 = new Card(peaShooterCardImage);
        panel3 = new Card(frozenPeaShooterCardImage);
        panel4 = new Card(wallNutCardImage);
        panel5 = new Card(cherryBombCardImage);
        panel1.setLocation(110,8);
        panel2.setLocation(175,8);
        panel3.setLocation(240,8);
        panel4.setLocation(305,8);
        panel5.setLocation(370,8);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        setMouseListeners();
//        addMouseListener(this);
    }

    /**
     * handles the mouse clicking
     */
    private void setMouseListeners (){
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whichCard =1;
            }
        });
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whichCard =2;
            }
        });
        panel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whichCard =3;
            }
        });
        panel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whichCard =4;
            }
        });
        panel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                whichCard =5;
            }
        });
    }

    /**
     * @return number of the token card
     */
    public int getWhichCard (){
        return whichCard;
    }

    /**
     * changes the whichCard's value to 0 : no card is token
     */
    public void resetWhichCard (){
        whichCard =0;
    }

    //    public void setActionlistener(ActionListener a){
//        this.actionlistener=a;
//    }
}
