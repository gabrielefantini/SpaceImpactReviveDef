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
        Controller.getInstance().setLevel(2);
    }
    public static Level2 getInstance() {
        if(instance == null)instance = new Level2();
        return instance;
    }
    @Override
    public void levelTime(){
        timer++;
        System.out.println(timer);
        if(timer==100){
            obstacleBarrier();
        }
        if(timer == 600){
            Controller.getInstance().addElement("Enemy2");
        }
        if(timer==1400)Controller.getInstance().addElement("Enemy1");
        //if(timer==200)SpaceImpactRevive.getInstance().stopBackground();
    }
}
