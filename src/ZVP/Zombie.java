/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;
import java.awt.*;

public class Zombie extends JPanel{

    private Image image;

    private int health;
    private double speed ;
    private int damage;
    private boolean alive;
    private boolean isFrozen = false;
    private GamePanel gamePanel;
    private int line;
    private int x;
    private int y;

    /**
     * set
     * @param g to game panel
     * @param health to health
     * @param speed to speed
     * @param damage to damge
     * @param l to line
     *          and set alive true
     *          set x 1000
     *          and set y
     */
    public Zombie(GamePanel g , int health , double speed , int damage , int l ){
        gamePanel = g;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        alive = true;
        line = l;
        x=1000;
        y = 109 + line * 120;
    }

    /**
     * setter of image
     * @param image image of zombie
     */
    public void setImage (Image image){
        this.image = image;
    }

    /**
     *
     Move based on decreasing x
     */
    public void move (){
        x -= 4.5/speed;
        setLocation(x,y);
    }

    public void eat (){

    }

    /**
     * set freeze if shoot freezePea
     * and decrease speed
     */
    public void freez (){
        if (!isFrozen){
            speed = speed/2;
            isFrozen = true;
        }
    }

    /**
     * getter of x
     * @return x
     */
    public int getX (){
        return x;
    }

    /**
     * set health
     * @param h health
     */
    public void setHealth(int h){
        health = h ;
    }

    /**
     * getter of health
     * @return health
     */
    public int getHealth(){
        return health;
    }

    /**
     * set speed
     * @param s speed
     */
    public void setSpeed(double s){
        speed = s ;
    }

    /**
     * getter of speed
     * @return speed
     */
    public double getSpeed(){
        return speed;
    }

    /**
     * set alive
     * @param a alive
     */
    public void setAlive(boolean a){
        alive = a ;
    }

    /**
     * get alive
     * @return alive
     */
    public boolean getAlive(){
        return alive;
    }

    /**
     * setter of damage
     * @param d damage
     */
    public void setDamage(int d){
        damage = d ;
    }

    /**
     * getter of damage
     * @return damage
     */
    public int getDamage(){
        return damage;
    }

    /**
     * getter of line
     * @return line
     */
    public int getLine (){
        return line;
    }
}
