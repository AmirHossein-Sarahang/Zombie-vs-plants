package ZVP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
/**
 * panel of the game's frame
 * @author Mobina Hadavifar and AmirHossein Sarahang
 * @version 1.0
 * @since 2020
 */
public class GamePanel extends JLayeredPane implements MouseMotionListener {

    private boolean isNormal;

    private long startTime;

    private int sunScore;
    private JLabel sun;
    private Random random;

    //Timers
    private Timer moves;
    private Timer redrawTimer;
    private Timer makeSun;
    private Timer makeZombie;
    Timer makeZombie1;
    Timer makeZombie2;
    Timer makeZombie3;
    private Timer gameParts;

    private int counter=0;

    ImageMaker im;
    PlantCardsPanel cards;

    //plants, zombies , bullets and suns
    private PlantPanel[][] plantPanels = new PlantPanel[9][5];
    private ArrayList<Zombie> [] rowsZombies = new ArrayList[5];
    private ArrayList<Bullet> [] rowsPeas = new ArrayList[5];
    private ArrayList<Sun> suns = new ArrayList<>();
    Mower[] mowers;

    public GamePanel(boolean isNormal){
        this.isNormal = isNormal;
        im = new ImageMaker();
        random = new Random();
        setSize(1000, 752);
        setLayout(null);
        repaint();
        setCards();
        setPlantPanels();

        for (int i = 0 ; i<5 ; i++){
            rowsZombies[i] = new ArrayList<>();
            rowsPeas[i] = new ArrayList<>();
        }

        setMowers();
        setSunLabel();

        //////////////////////////////////////////////////////////////
        startTime = System.currentTimeMillis();
        gameParts = new Timer ((30000) , (ActionEvent e) -> {
            counter++;
            if (counter < 6){
                if (counter == 1) {
                    addRandomZombie();
                    makeZombie1 = new Timer((30000), (ActionEvent e2) -> {
                        addRandomZombie();
                    });
                    makeZombie1.start();
                }
            } else if (counter < 12){
                if (counter == 6) {
                    makeZombie1.stop();
                    addRandomZombie();
                    addRandomZombie();
                    makeZombie2 = new Timer((30000), (ActionEvent e2) -> {
                        addRandomZombie();
                        addRandomZombie();
                    });
                    makeZombie2.start();
                }
            } else if (counter < 17){
                if (counter == 12) {
                    makeZombie2.stop();
                    addRandomZombie();
                    addRandomZombie();
                    makeZombie3 = new Timer((25000), (ActionEvent e2) -> {
                        addRandomZombie();
                        addRandomZombie();
                    });
                    makeZombie3.start();
                }
            } else
                makeZombie3.stop();
        });
//        gameParts.start();

        Thread t = new Thread(){
            public void run(){
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameParts.start();
            }
        };
        t.start();

        makeSun= new Timer((isNormal?25000:30000), (ActionEvent e) -> {
            Sun sta = new Sun(this, random.nextInt(850)+100 , 0, random.nextInt(600)+100);
            suns.add(sta);
            add(sta, new Integer(1));
        });
        makeSun.start();

        moves = new Timer(60, (ActionEvent e) -> {
            sunMove();
            peasMove();
            zombiesMove();
        });
        moves.start();

        redrawTimer = new Timer(60, (ActionEvent e) -> {
           repaint();
        });
        redrawTimer.start();

        //////////////////////////////////////////////////////////////
    }

    /**
     * make 2 of an integer (r : type of zombie / l : line of zombie)
     * then add zombie to rowsZombie and give gamePanel and l+1 to it
     */
    private void addRandomZombie (){
        int r = random.nextInt(3);
        int l = random.nextInt(5);
        if (r==0)
            rowsZombies[l].add( new NormalZombie(this,l+1) );
        else if (r==1)
            rowsZombies[l].add( new ConeHeadZombie(this,l+1) );
        else if (r==2)
            rowsZombies[l].add( new BucketHeadZombie(this,l+1) );
    }
    /**
     * check normal or no
     * @return true if isNormal else false
     */
    public boolean isNormal (){
        return isNormal;
    }

    /**
     * make new label and set location and size
     * and finally set sun score and add to game panel
     */
    private void setSunLabel (){
        sun = new JLabel("Sun : " ) ;
        sun.setLocation(37, 80);
        sun.setSize(60, 20);
        setSunScore(150);
        sun.setLocation(32,80);
        this.add(sun);
    }

    /**
     * first make array of mower
     * and give gamePanel to mower in for
     * then set mower to mowers list
     * finally add mower
     */
    private void setMowers (){
        mowers = new Mower[5];
        for (int i=0; i<5 ; i++){
            Mower mower = new Mower(this,i);
            mower.setLocation(0,150 + i * 120);
            mowers[i] = mower;
            add(mower,0);
        }
    }
    /**
     * First make new plant and set location
     * then set final i and j
     * finally add MouseListener and  @Override mouseClicked to update plantPanels
     */
    private void setPlantPanels (){
        for (int i = 0; i < 9; i++) {
            for (int j = 0 ; j<5 ; j++) {
                PlantPanel a = new PlantPanel();
                a.setLocation(44 + i * 100, 109 + j * 120);
                int finalI = i;
                int finalJ = j;
                a.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        paintPlant(finalI, finalJ);
                    }
                });
                plantPanels[i][j] = a;
                add(a, 0);
            }
        }
    }

    /**
     * First make new PlantCardsPanel and set loacation
     * then add cards by index
     */
    private void setCards (){
        cards = new PlantCardsPanel();
        cards.setLocation(100,8);
        add(cards,0);
    }
    /**
     * @param row -> row of zombie
     * @return arraylist of zombies
     */
    public ArrayList<Zombie> getRowZombies (int row){
        return rowsZombies[row-1];
    }
    /**
     * @param row -> row of Peas
     * @return list of peas
     */
    public ArrayList<Bullet> getRowPeas (int row){
        return rowsPeas[row];
    }
    /**
     *
     * @param sunScore its an integer to set sun score to
     *                 suns label
     */
    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sun.setText("Suns : " + sunScore);
    }
    /**
     * getter of sunscore
     * @return sunscore
     */
    public int getSunScore(){
        return sunScore;
    }
    /**
     * getter of suns
     * @return list of suns
     */
    public ArrayList<Sun> getSuns (){
        return suns;
    }

    /**
     *
     * @param x of plant
     * @param y of plant
     *          fist switch to cards and call getWitchCard method,
     *          second set plant to  plantPanels
     *          and Deduction of sunScore
     *          then  set new sunScore
     *          and finally repaint plant panel and call reset witch card
     */
    public void paintPlant (int x, int y){

        switch (cards.getWhichCard()){
            case 1:
                if (getSunScore() >= SunFlower.getPrice()) {
                    plantPanels[x][y].setPlant(new SunFlower(x, y, this));
                    setSunScore(getSunScore() - SunFlower.getPrice());
                }
                break;
            case 2:
                if (getSunScore() >= PeaShooter.getPrice()){
                    plantPanels[x][y].setPlant(new PeaShooter(x,y,this));
                    setSunScore(getSunScore() - PeaShooter.getPrice());
                }
                break;
            case 3:
                if (getSunScore() >= FreezePeaShooter.getPrice()){
                    plantPanels[x][y].setPlant(new FreezePeaShooter(x,y,this));
                    setSunScore(getSunScore() - FreezePeaShooter.getPrice());
                }
                break;
            case 4:
                if (getSunScore() >= GiantWall.getPrice()) {
                    plantPanels[x][y].setPlant(new GiantWall(x, y, this));
                    setSunScore(getSunScore() - GiantWall.getPrice());
                }
                break;
            case 5:
                if (getSunScore() >= CherryBomb.getPrice()){
                    plantPanels[x][y].setPlant(new CherryBomb(x,y,this));
                    setSunScore(getSunScore() - CherryBomb.getPrice());
                }
                break;
        }
        plantPanels[x][y].repaint();
        cards.resetWhichCard();
    }

    /**
     * @Override  paintComponent
     * @param g to draw image by get background from image maker class
     *          first make new plant panel
     *          second Specify the type of card
     *          and then draw the plant to fit its card
     *
     *
     *          also for zombies and peas :
     *           check all value of rowsZombies or  rowsPeas for peas ,
     *           and paint, Depending on their type
     *
     *
     */
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.drawImage(im.getBackgroundImage(), 0, 0, null);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                PlantPanel c = plantPanels[i][j];
                if (c.getPlant() != null) {
                    Plant p = c.getPlant();
                    if (p instanceof PeaShooter) {
                        g.drawImage(im.getPeashooterImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof FreezePeaShooter) {
                        g.drawImage(im.getFreezePeashooterImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof SunFlower) {
                        g.drawImage(im.getSunflowerImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof GiantWall) {
                        g.drawImage(im.getGiantImage(), 60 + i * 100, 129 + j * 120, null);
                    } else if (p instanceof CherryBomb) {
                        g.drawImage(im.getCherryBombImage(), 60 + i * 100, 129 + j * 120, null);
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (Zombie z : rowsZombies[i]) {
                if (z instanceof NormalZombie) {
                    g.drawImage(im.getNormalZombieImage(), z.getX(), 109 + ((i) * 120), null);
                } else if (z instanceof ConeHeadZombie) {
                    g.drawImage(im.getConeHeadZombieImage(), z.getX(), 109 + ((i) * 120), null);
                } else if (z instanceof BucketHeadZombie) {
                    g.drawImage(im.getBucketHeadZombieImage(), z.getX(), 109 + ((i) * 120), null);
                }
            }

            for (Bullet b : rowsPeas[i]) {
                if (b instanceof FreezePea) {
                    g.drawImage(im.getFreezePeaImage(), b.getX()+65, 135 + ((i) * 120), null);
                } else {
                    g.drawImage(im.getPeaImage(), b.getX()+65, 135 + ((i) * 120), null);
                }
            }
        }


        for (int i=0; i<5 ; i++){
            Mower mower = mowers[i];
            if (mower.isEnable()){
                g.drawImage(mower.getImage(), mower.getX(), mower.getMapY(), null);
            }
        }
    }
    /**
     * check list of suns and give them
     * to move method from sun class
     */
    public void sunMove(){
        for (Sun value : suns) {
            value.move();
        }
    }
    /**
     * check list of peas and give them
     * to move method from peas class
     */
    public void peasMove (){
        for (int i = 0 ; i<5 ; i++){
            for (Bullet b : rowsPeas[i]){
                b.attack();
            }
        }
    }

    /**
     * check list of zombie and give them
     * to move method from zombie class
     */
    public void zombiesMove (){
        for (int i = 0 ; i<5 ; i++){
            for (Zombie z : rowsZombies[i])
                z.move();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) { }
    @Override
    public void mouseMoved(MouseEvent e) { }
}
