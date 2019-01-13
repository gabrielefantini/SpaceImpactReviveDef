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
public class Level3 extends Level {
    private static Level3 instance = null;
    protected Level3(){
        super();
    }
    public static Level3 getInstance() {
        if(instance == null)instance = new Level3();
        return instance;
    }
    @Override
    public void levelTime(){
        timer++;
        System.out.println(timer);
        if(timer == 50)Controller.getInstance().addElement("Enemy1");
        if(timer == 250)Controller.getInstance().addElement("Bonus2");
        if(timer == 300)obstacleBarrier();
        if(timer == 500)obstacleBarrier();
        if(timer==900)Controller.getInstance().addElement("Enemy1");
        if(timer==1200)Controller.getInstance().addElement("Enemy");
        if(timer==1500){
            Controller.getInstance().addElement("Bonus1");
            Controller.getInstance().addElement("Bonus2");
        }
        if(timer==1600)obstacleBarrier();
        if(timer == 1700)Controller.getInstance().addElement("Obstacle0");
        if(timer == 1700)Controller.getInstance().addElement("Obstacle270");
        if(timer == 2000)Controller.getInstance().addElement("Enemy");
        if(timer == 2500)Controller.getInstance().addElement("Enemy1");
        if(timer == 3000)Controller.getInstance().win();
    }
}
