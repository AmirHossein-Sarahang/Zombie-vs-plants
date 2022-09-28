/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class NormalZombie extends Zombie {
    /**
     * first call super and set g,l
     * @param g game panel
     * @param l line
     *          and then make new image maker class to set image
     */
    protected NormalZombie(GamePanel g, int l) {
        super(g, 200, 4, 5, l);
        ImageMaker im = new ImageMaker();
        super.setImage(im.getNormalZombieImage());
    }

}
