package ZVP;
/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */


import javax.swing.*;
import java.awt.*;

/**
 * keeps the images
 */
public class ImageMaker {

    protected Image BackgroundImage;
    protected Image PeashooterImage;
    protected Image FreezePeashooterImage;
    protected Image SunflowerImage;
    protected Image PeaImage;
    protected Image FreezePeaImage;
    protected Image CherryBombImage;
    protected Image GiantImage;
    protected Image NormalZombieImage;
    protected Image ConeHeadZombieImage;
    protected Image BucketHeadZombieImage;

    /**
     * males a new ImageMaker
     */
    public ImageMaker(){
        BackgroundImage = new ImageIcon(this.getClass().getResource("image/BG.png")).getImage();
        PeashooterImage = new ImageIcon(this.getClass().getResource("image/peashooter.gif")).getImage();
        FreezePeashooterImage = new ImageIcon(this.getClass().getResource("image/freezepeashooter.gif")).getImage();
        SunflowerImage = new ImageIcon(this.getClass().getResource("image/sunflower.gif")).getImage();
        PeaImage = new ImageIcon(this.getClass().getResource("image/pea.png")).getImage();
        FreezePeaImage = new ImageIcon(this.getClass().getResource("image/freezepea.png")).getImage();
        CherryBombImage = new ImageIcon(this.getClass().getResource("image/CherryBomb.gif")).getImage();
        GiantImage = new ImageIcon(this.getClass().getResource("image/walnut_full_life.gif")).getImage();
        NormalZombieImage = new ImageIcon(this.getClass().getResource("image/zombie_normal2.gif")).getImage();
        ConeHeadZombieImage = new ImageIcon(this.getClass().getResource("image/coneheadzombie2.gif")).getImage();
        BucketHeadZombieImage = new ImageIcon(this.getClass().getResource("image/bucketheadzombie2.gif")).getImage();

    }

    public Image getBackgroundImage() {
        return BackgroundImage;
    }

    public Image getCherryBombImage() {
        return CherryBombImage;
    }

    public Image getGiantImage() {
        return GiantImage;
    }

    public Image getBucketHeadZombieImage() {
        return BucketHeadZombieImage;
    }

    public Image getConeHeadZombieImage() {
        return ConeHeadZombieImage;
    }

    public Image getFreezePeaImage() {
        return FreezePeaImage;
    }

    public Image getFreezePeashooterImage() {
        return FreezePeashooterImage;
    }

    public Image getPeaImage() {
        return PeaImage;
    }

    public Image getPeashooterImage() {
        return PeashooterImage;
    }

    public Image getSunflowerImage() {
        return SunflowerImage;
    }

    public Image getNormalZombieImage() {
        return NormalZombieImage;
    }

}
