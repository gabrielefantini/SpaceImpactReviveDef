/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javafx.scene.media.AudioClip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Config;

/**
 *
 * @author gabri
 */
public class SpaceShipView extends GameView{
    private int rateo;
    private int RATEO;
    private int timer;
    public SpaceShipView(){ 
        super();
        type = "SpaceShip";
        int n = Config.getInstance().getSpaceShip();
        try {
            this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal1.png"));
            this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker1.png"));
            switch(n){
                case 1 :this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal1.png"));
                        this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker1.png"));break;
                case 2 : this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal2.png"));
                        this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker2.png"));break;
                case 3 :this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal3.png"));
                        this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker3.png"));break;
            }
            this.imageDisplayed = new ImageView(imageNormal);
            fireSound = new AudioClip(SpaceShipView.class.getResource("/audio/laser10.wav").toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        Space.getInstance().getChildren().add(imageDisplayed);
        rateo = 0;
        RATEO=10;
        timer = 0;
    }
    @Override
    public void animationLoop(){
        int dx = 0;
        int dy = 0;
        if(GameWindow.UP) dy -=2;
        if(GameWindow.DOWN) dy +=2;
        if(GameWindow.LEFT) dx -=2;
        if(GameWindow.RIGHT) dx +=2;
        if(GameWindow.FIRE && rateo == 0){fire(1);if(sound)fireSound.play(0.8); rateo = RATEO;} 
        if(rateo>0)rateo--;
        if(timer>0)timer--;
        if(timer == 0)RATEO = 10;
        moveElementBy(dx,dy);
        if(flicker)flicker();
        
    }
    @Override
    public void setRateo(int x){
        RATEO = x;
        timer = 600;
    }
    
}
