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
    private int rateo;
    public EnemyView(){
        super();
        this.imageNormal = new Image(EnemyView.class.getResourceAsStream("/img/enemy.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(805,100);
        rateo = 50;
        
    }
    @Override
    public void animationLoop(){
        int c=1;
        if(rateo==0){fire(-5);rateo = 150;}
        rateo--;
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
        
    }

}
