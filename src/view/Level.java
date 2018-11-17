/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameObject;
import controller.SpaceImpactRevive;
import javafx.animation.AnimationTimer;
import model.GameModel;
import model.SpaceShipModel;

/**
 *
 * @author gabri
 */
class Level extends AnimationTimer {
    private int timer;
    private static Level instance = null;
    protected Level(){
        timer = 0;
        SpaceImpactRevive.getInstance().start();
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        SpaceImpactRevive.getInstance().add(new GameObject("SpaceShip"));
        SpaceImpactRevive.getInstance().add(new GameObject("Enemy"));
        start();
        
    }
    public static Level getInstance() {
        if(instance == null)instance = new Level();
        return instance;
    }
    public void levelTime(){
        timer++;
        System.out.println(timer);
        if(timer == 600)SpaceImpactRevive.getInstance().add(new GameObject("Enemy"));
    }

    @Override
    public void handle(long now) {
        levelTime();
    }
    
}
