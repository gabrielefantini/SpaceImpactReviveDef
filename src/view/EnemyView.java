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
public class EnemyView extends GameView{
    public EnemyView(){
            super();
        this.imageNormal = new Image(EnemyView.class.getResourceAsStream("/img/enemy2.png"));
        //this.imageFlicker = new Image(EnemyView.class.getResourceAsStream("/img/enemy2.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(750,0);
        
    }
    @Override
    public void animationLoop(){
        moveElementBy(-1, 0);
    }

    
}
