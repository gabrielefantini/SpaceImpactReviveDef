/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameObject;
import controller.SpaceImpactRevive;
import model.GameModel;
import model.SpaceShipModel;

/**
 *
 * @author gabri
 */
class Level {
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
        
    }
    public static Level getInstance() {
        if(instance == null)instance = new Level();
        return instance;
    }
    public void levelTime(){
        timer++;
    }
    
}
