/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author gabri
 */
public class GameView {
    private Image imageNormal;
    private Image imageFlicker;
    private ImageView imageDisplayed;
    private int a;
    private int b;
    
    public GameView(){
        a=0;
        b=0;
    }
   
    public void animationLoop(){
        
    }

    public boolean outOfSpace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void remove(){
        Space.getInstance().getChildren().remove(imageDisplayed);
    }

    public Bounds getBounds() {
        return imageDisplayed.getBoundsInParent();
    }
    public void flicker(){
        if(a<10){
            imageDisplayed.setImage(imageFlicker);
            a++;
        }
        if(a == 10 && b<10){
            imageDisplayed.setImage(imageNormal);
            b++;
        }
        if(a==10 && b == 10){
            a=0;
            b=0;
        }
            
    }
    public void stopFlicker(){
        imageDisplayed.setImage(imageNormal);
        a=0;b=0;
    }
}
