/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SpaceImpactRevive;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

/**
 *
 * @author gabri
 */
public abstract class Animations {
    private static int v = 2;
    public static Bounds loopForSpaceship(Bounds oldBounds){
        double x = oldBounds.getMinX();
        double y = oldBounds.getMinY();
        if(GameWindow.UP)y-= v;
        if(GameWindow.DOWN)y+=v;
        if(GameWindow.LEFT)x-=v;
        if(GameWindow.RIGHT)x+=v;
        
        if(oldBounds.getMinX()<0 && oldBounds.getMinY()<0)return new BoundingBox(x+=v, y+=v, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMinX()<0 && oldBounds.getMaxY()>Space.SceneHeight)return new BoundingBox(x+=v, y-=v, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMaxX()>Space.SceneWidth && oldBounds.getMinY()<0)return new BoundingBox(x-=v, y+=v, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMaxX()>Space.SceneWidth && oldBounds.getMaxY()>Space.SceneHeight)return new BoundingBox(x-=v, y-=v, oldBounds.getWidth(), oldBounds.getHeight());
        
        if(oldBounds.getMinX()<0)return new BoundingBox(x+=v, y, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMinX()<0)return new BoundingBox(x+=v, y, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMaxX()>Space.SceneWidth )return new BoundingBox(x-=v, y, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMinY()<0)return new BoundingBox(x, y+=v, oldBounds.getWidth(), oldBounds.getHeight());
        if(oldBounds.getMaxY()>Space.SceneHeight)return new BoundingBox(x, y-=v, oldBounds.getWidth(), oldBounds.getHeight());
        
        else 
            return new BoundingBox(x, y, oldBounds.getWidth(), oldBounds.getHeight());
    }
    public static Bounds loopForEnemy(Bounds oldBounds) {
        double x = oldBounds.getMinX();
        double y = oldBounds.getMinY();
        if((x>=600&&x<=800)||(x>=200 &&x<=400)){
            x--;
            y++;
        }
        if((x<400 && x>600)||(x<200)){
            x--;
            y--;
        }
        return new BoundingBox(x, y, oldBounds.getWidth(), oldBounds.getHeight());
    }
    public static Bounds loopForProjectileDx(Bounds oldBounds){
        double x = oldBounds.getMinX();
        double y = oldBounds.getMinY();
        x+=2;
        return new BoundingBox(x, y, oldBounds.getWidth(), oldBounds.getHeight());
    }
     public static Bounds loopForProjectileSx(Bounds oldBounds){
        double x = oldBounds.getMinX();
        double y = oldBounds.getMinY();
        x--;
        return new BoundingBox(x, y, oldBounds.getWidth(), oldBounds.getHeight());
    }
    public static Bounds loopForBackground(Bounds oldBounds){
        double x = oldBounds.getMinX();
        double y = oldBounds.getMinY();
        x++;
        return new BoundingBox(x, y, oldBounds.getWidth(), oldBounds.getHeight());
    }
    public static void animation4(){
        
    }
    public static void animation5(){
        
    }
    public static void relocate(ImageView image){
        
    }

    
}
