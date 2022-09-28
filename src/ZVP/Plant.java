/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

public class Plant {

    private int health;
    private static int price;
    private int x;
    private int y;
    private int row;
    private boolean alive;
    private GamePanel gamePanel;

    /**
     *  set
     * @param h to health
     * @param p to plant price
     * @param x to x
     * @param row to row
     * @param g to gamePanel
     */
    protected Plant(int h, int p, int x, int row, GamePanel g){
        health = h ;
        price = p ;
        this.x = x;
        this.row = row;
        alive = true;
        gamePanel = g;

    }

    /**
     * set health
     * @param h
     */
    public void setHealth(int h){
        health = h ;
    }

    /**
     * set Price
     * @param p
     */
    public static void setPrice(int p){
        price = p ;
    }

    /**
     * set alive
     * @param a
     */
    public void setAlive(boolean a){
        alive = a ;
    }

    /**
     * getter of alive
     * @return
     */
    public boolean getAlive(){
        return alive;
    }
    /**
     * getter of Health
     * @return
     */
    public int getHealth(){
        return health;
    }
    /**
     * getter of price
     * @return
     */
    public static int getPrice(){
        return price;
    }
    /**
     * getter of x
     * @return
     */
    public int getX(){
        return this.x;
    }
    /**
     * getter of y
     * @return
     */
    public int getY(){
        return this.y;
    }
}
