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
 * @author gabriele fantini
 */
public class BackgroundView extends GameView{
    private int c;
    public BackgroundView(){
        super();
        imageNormal = new Image(BackgroundView.class.getResourceAsStream("/img/Background.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(0,0);
        c=1;
    }
    @Override
    public void stopBackground(){
        c=0;
    }
    @Override
    public void animationLoop(){
       
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }
}
