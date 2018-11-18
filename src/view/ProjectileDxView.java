/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import model.ProjectileModel;

/**
 *
 * @author gabri
 */
public class ProjectileDxView extends GameView{
    public ProjectileDxView(){
        super();
        imageNormal= new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileDx.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
    }
    @Override
    public void animationLoop(){
        int c=8;
        
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()+c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }
}
