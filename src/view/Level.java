/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameObject;
import controller.SpaceImpactRevive;
import javafx.animation.AnimationTimer;

/**
 *
 * @author gabri
 */
public class Level extends AnimationTimer {
    protected int timer;
    protected Level(){
        timer = 0;
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        SpaceImpactRevive.getInstance().add(new GameObject("Background"));
        SpaceImpactRevive.getInstance().add(new GameObject("SpaceShip"));
        start();
        
    }
    public void setTime(int n){
        timer = n;
    }
    public void levelTime(){
    }

    @Override
    public void handle(long now) {
        SpaceImpactRevive.getInstance().gameLoop();
        levelTime();
    }
    public void obstacleBarrier(){
        SpaceImpactRevive.getInstance().add(new GameObject("Obstacle0"));
        SpaceImpactRevive.getInstance().add(new GameObject("Obstacle140"));
        SpaceImpactRevive.getInstance().add(new GameObject("Obstacle270"));
    }
}
