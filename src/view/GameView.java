/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameObject;
import controller.SpaceImpactRevive;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author gabri
 */
public class GameView {
    protected Image imageNormal;
    protected Image imageFlicker;
    protected ImageView imageDisplayed;
    protected int a = 0;
    private int b = 0;
    
    public GameView(){
    }
   
    public void animationLoop(){
        
    }

    public boolean outOfSpace() {
        return this.imageDisplayed.getBoundsInParent().getMaxX()<=-20 || this.imageDisplayed.getBoundsInParent().getMinX()>=820;
    }
    public void remove(){
        Space.getInstance().getChildren().remove(imageDisplayed);
    }

    public Bounds getBounds() {
        return imageDisplayed.getBoundsInParent();
    }
    public void flicker(){
        if(a<20){
            imageDisplayed.setImage(imageFlicker);
            a++;
        }
        if(a == 20 && b<20){
            imageDisplayed.setImage(imageNormal);
            b++;
        }
        if(a==20 && b == 20){
            a=0;
            b=0;
        }
            
    }
    public void stopFlicker(){
        imageDisplayed.setImage(imageNormal);
        a=0;b=0;
    }
     public void moveElementBy(int dx, int dy){
        if(dx == 0 && dy == 0) return;        
        final double cx = this.getBounds().getWidth()/2;
        final double cy = this.getBounds().getHeight()/2;
        
        double x = cx + imageDisplayed.getLayoutX() + dx;
        double y = cy + imageDisplayed.getLayoutY() + dy;
        moveElementTo(x,y);
    }
    public void moveElementTo(double x, double y){
        final double cx = this.getBounds().getWidth() /2;
        final double cy = this.getBounds().getHeight() / 2;
        if( x - cx >= 0 && 
            x + cx <= 800 &&
            y - cy >= 0 &&
            y + cy <= 400)
            imageDisplayed.relocate(x - cx,y - cy);            
    }
    public void fire(int direction){
        int x;
        int y; 
        if(direction >0){
            x = (int)this.getBounds().getMaxX()+1;
            y = (int)(this.getBounds().getMaxY()-this.getBounds().getHeight()/2);
            GameObject p = new GameObject("ProjectileDx");
            SpaceImpactRevive.getInstance().add(p);
            p.set(x, y);
            System.out.println("view.GameView.fire()");
        }
        else{
            if(direction == -5){
            x = (int)this.getBounds().getMinX()- 90;
            y = (int)(this.getBounds().getMaxY()- this.getBounds().getHeight()/2);
            GameObject p = new GameObject("ProjectileSx");
            SpaceImpactRevive.getInstance().add(p);p.set(x, y);
            }else
            if(direction ==-1){
            x = (int)this.getBounds().getMinX()- 20;
            y = (int)(this.getBounds().getMaxY()- this.getBounds().getHeight()/2);
            GameObject p = new GameObject("ProjectileSx1");
            SpaceImpactRevive.getInstance().add(p);p.set(x, y);  
            }
        }
            
 
    }
    public void set(int x, int y){
        this.imageDisplayed.relocate(x, y);
    }

    public void stopBackground() {
       
    }
}
