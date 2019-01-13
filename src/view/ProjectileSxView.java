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
        if(n==0){
            try {
                imageNormal= new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileSx.png"));
            } catch (Exception e) {
            }
            
            type = "ProjectileSx";
        }
        if(n==1){
            try {
                 imageNormal= new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileSx1.png"));
            } catch (Exception e) {
            }
           
            type = "ProjectileSx1";
        }
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
