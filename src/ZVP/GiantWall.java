/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class GiantWall extends Plant{
    /**
     *
     * @param x of plant
     * @param y of plant
     * @param g of plant
     *          and call super to set health , price of  GiantWall , x ,y and gamePanel
     */
    public GiantWall(int x, int y, GamePanel g) {
        super(150,50,x,y,g);
    }

    /**
     * getter of price
     * @return price of plant
     */
    public static int getPrice (){
        return 50;
    }
}
