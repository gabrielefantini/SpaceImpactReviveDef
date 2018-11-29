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
public class Level1 extends AnimationTimer {
    private int timer;
    private static Level1 instance = null;
    protected Level1(){
        timer = 0;
        SpaceImpactRevive.getInstance().setLevel(1);
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        SpaceImpactRevive.getInstance().add(new GameObject("Background"));
        SpaceImpactRevive.getInstance().add(new GameObject("SpaceShip"));
        //SpaceImpactRevive.getInstance().add(new GameObject("Enemy1"));
        start();
        
    }
    public static Level1 getInstance() {
        if(instance == null)instance = new Level1();
        return instance;
    }
    public void levelTime(){
        timer++;
        System.out.println(timer);
        if(timer==100){
            obstacleBarrier();
        }
        if(timer == 600){
            SpaceImpactRevive.getInstance().add(new GameObject("Enemy2"));
        }
        if(timer==1400)SpaceImpactRevive.getInstance().add(new GameObject("Enemy1"));
        //if(timer==200)SpaceImpactRevive.getInstance().stopBackground();
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
