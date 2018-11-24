/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import javafx.scene.media.AudioClip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author gabri
 */
public class SpaceShipView extends GameView{
    private int rateo;
    private int RATEO;
    public SpaceShipView(){ 
        super();
        this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal.png"));
        this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        try {
            fireSound = new AudioClip(SpaceShipView.class.getResource("/audio/laser10.wav").toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        Space.getInstance().getChildren().add(imageDisplayed);
        System.out.println("view.SpaceShipView.<init>()");  
        rateo = 0;
        RATEO=10;
    }
    @Override
    public void animationLoop(){
        int dx = 0;
        int dy = 0;
        if(GameWindow.UP) dy -=2;
        if(GameWindow.DOWN) dy +=2;
        if(GameWindow.LEFT) dx -=2;
        if(GameWindow.RIGHT) dx +=2;
        if(GameWindow.FIRE && rateo == 0){fire(1);fireSound.play(7); rateo = RATEO;} 
        if(rateo>0)rateo--;
        moveElementBy(dx,dy);
        
    }
    public void setRateo(int x){
        RATEO = x;
    }
}
