/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class Pea extends Bullet{
    /**
     *
     * @param gamePanel game panel
     * @param x
     * @param row
     * first call super by gamePanel,x and row
     */
    public Pea (GamePanel gamePanel, int x, int row){
        super(gamePanel,x,row,30);
    }

    public Zombie attack (){
        Zombie z = super.attack();
        if (z != null) {
            //z.setSpeed(getSpeed()/2);
        }
        return null;
    }

}
