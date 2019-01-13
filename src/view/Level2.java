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
public class Level2 extends Level {
    private static Level2 instance = null;
    protected Level2(){
        super();
    }
    public static Level2 getInstance() {
        if(instance == null)instance = new Level2();
        return instance;
    }
    @Override
    public void levelTime(){
        timer++;
        if(timer == 100)Controller.getInstance().addElement("Bonus2");
        if(timer==200){
            obstacleBarrier();
        }
        if(timer==300){
            obstacleBarrier();
        }
        if(timer==400){
            obstacleBarrier();
        }
        if(timer==500){
            obstacleBarrier();
        }
        if(timer==900)Controller.getInstance().addElement("Enemy1");
        if(timer==1400)Controller.getInstance().addElement("Enemy2");
        if(timer == 1500){
            Controller.getInstance().addElement("Obstacle0");
            Controller.getInstance().addElement("Obstacle270");
        }
        if(timer == 1600)Controller.getInstance().addElement("Bonus1");
        if(timer==2000)Controller.getInstance().addElement("Enemy");
        if(timer==2400)Controller.getInstance().addElement("Enemy2");
        if(timer == 2500){
            Controller.getInstance().addElement("Obstacle0");
            Controller.getInstance().addElement("Obstacle270");
        }
        if(timer == 2600)Controller.getInstance().addElement("Bonus1");
        if(timer==3000)Controller.getInstance().addElement("Enemy");
        if(timer == 3500)Controller.getInstance().win();
        
    }
}
