/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.Controller;


/**
 *
 * @author gabri
 */
public abstract class Level {
    protected int timer;
    protected Level(){
        timer = 0;
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        StatusBar.getInstance().addLife();
        Controller.getInstance().addElement("Background");
        Controller.getInstance().addElement("SpaceShip");
        Controller.getInstance().start();
        
    }
    public void setTime(int n){
        timer = n;
    }
    public void levelTime(){
        timer++;
    }
    public int getLevelTime(){
        return timer;
    }
    public void obstacleBarrier(){
        Controller.getInstance().addElement("Obstacle0");
        Controller.getInstance().addElement("Obstacle140");
        Controller.getInstance().addElement("Obstacle270");
    }
}
