/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author gabri
 */
public class SpaceShipView extends GameView{
    public SpaceShipView(){ 
        super();
        this.imageNormal = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipNormal.png"));
        this.imageFlicker = new Image(SpaceShipView.class.getResourceAsStream("/img/SpaceShipFlicker.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        System.out.println("view.SpaceShipView.<init>()");   
    }
    @Override
    public void animationLoop(){
        int dx = 0;
        int dy = 0;
        if(GameWindow.UP) dy -=2;
        if(GameWindow.DOWN) dy +=2;
        if(GameWindow.LEFT) dx -=2;
        if(GameWindow.RIGHT) dx +=2;
        if(GameWindow.FIRE)fire(1);
        moveElementBy(dx,dy);
        
    }
    
}
