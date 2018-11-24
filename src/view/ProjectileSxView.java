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
public class ProjectileSxView extends ProjectileView{
    public ProjectileSxView(int n){
        super();
        if(n==0)imageNormal= new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileSx.png"));
        if(n==1)imageNormal= new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileSx1.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
    }
    @Override
    public void animationLoop(){
        int c=2;
        
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }
}
