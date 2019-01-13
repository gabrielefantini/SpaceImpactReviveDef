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
public class Level1 extends Level {
    private static Level1 instance = null;
    protected Level1(){
        super();
    }
    public static Level1 getInstance() {
        if(instance == null)instance = new Level1();
        return instance;
    }
   
    @Override
    public void levelTime(){
        timer++;
        if(timer == 100)Controller.getInstance().addElement("Enemy1");
        if(timer == 200)obstacleBarrier();
        if(timer==500)Controller.getInstance().addElement("Enemy1");
        if(timer==900)Controller.getInstance().addElement("Enemy1");
        if(timer==1000)obstacleBarrier();
        if(timer == 1200)Controller.getInstance().addElement("Bonus1");
        if(timer == 1500)Controller.getInstance().addElement("Bonus2");
        if(timer == 1500)Controller.getInstance().addElement("Obstacle0");
        if(timer == 1500)Controller.getInstance().addElement("Obstacle270");
        if(timer == 2000)Controller.getInstance().addElement("Enemy");
        if(timer == 2500)Controller.getInstance().addElement("Enemy1");
        if(timer == 3000)Controller.getInstance().win();
    }

}
