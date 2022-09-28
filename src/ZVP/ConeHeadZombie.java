/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class ConeHeadZombie extends Zombie {
    /**
     * @param g game panel
     * @param l
     * first call super and make new image maker class to set image
     */
    protected ConeHeadZombie(GamePanel g , int l) {
        super(g, 200+360 , (g.isNormal()?3.5:3),(g.isNormal()?10:15) , l);
        ImageMaker im = new ImageMaker();
        super.setImage(im.getConeHeadZombieImage());
    }
}
