/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */
/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class CherryBomb extends Plant {

    /**
     *
     * @param x
     * @param y
     * @param g gamePanel
     *          furst call super
     */
    protected CherryBomb(int x, int y, GamePanel g) {

        super(70, 150,x, y,g);
    }

    /**
     * getter of price
     * @return price of cherryBomb
     */
    public static int getPrice (){
        return 150;
    }
}
