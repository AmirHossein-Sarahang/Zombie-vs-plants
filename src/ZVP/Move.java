/**
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */

package ZVP;

import javax.swing.*;

public class Move extends JPanel {

    protected boolean isPea;
    protected boolean isSun;
    protected boolean isZombie;

    public Move(boolean p,boolean s,boolean z) {

        switch (setAll(p,s,z)) {
            case Pea :
                PeaMove();
                break;
            case Sun :
                SunMove();
                break;
            case Zombie:
                ZombieMove();
                break;
        }
    }

    public TypeofMove setAll(boolean pea,boolean sun,boolean zombie) {
        if (pea == true) {
            setPea(true);
            setSun(false);
            setZombie(false);
            return TypeofMove.Pea;
        }
        if (sun == true) {
            setPea(false);
            setSun(true);
            setZombie(false);
            return TypeofMove.Sun;
        }
        if (zombie == true) {
            setPea(false);
            setSun(false);
            setZombie(true);
            return TypeofMove.Zombie;
        }
        else
            return TypeofMove.None;
    }


    public void ZombieMove(){

    }
    public void SunMove(){}
    // public void SunMove(GamePanel gp , Sun S, int Y ,int Y2,int endTime){
    //     while (Y < Y2){
    //    Y += 5;
    //  setLocation(getX(),getY());

    //   }
//
    //   }


    public void PeaMove(){

    }

    public void setPea(boolean pea) {
        isPea = pea;
    }

    public void setSun(boolean sun) {
        isSun = sun;
    }

    public void setZombie(boolean zombie) {
        isZombie = zombie;
    }


}