/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class BucketHeadZombie extends Zombie{
    /**
     *
     * @param g -> gamePanel
     * @param l
     * first call super and then make new image maker class to set image
     */
    protected BucketHeadZombie(GamePanel g , int l) {
        super(g, 200+1100 , (g.isNormal()?3.5:3),(g.isNormal()?20:25) , l);
        ImageMaker im = new ImageMaker();
        super.setImage(im.getBucketHeadZombieImage());
    }
}
