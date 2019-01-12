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
public class Bonus2View extends BonusView{
    public Bonus2View() {
        super();
        type = "Bonus2";
        this.imageNormal = new Image(EnemyView.class.getResourceAsStream("/img/bonus2.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(800,200);
    }
    @Override
    public void animationLoop(){
        int c=1;
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }

}
