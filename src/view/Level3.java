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
public class Level3 extends Level {
    private static Level3 instance = null;
    protected Level3(){
        super();
        SpaceImpactRevive.getInstance().setLevel(3); 
    }
    public static Level3 getInstance() {
        if(instance == null)instance = new Level3();
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
            SpaceImpactRevive.getInstance().add(new GameObject("Enemy2"));
        }
        if(timer==1400)SpaceImpactRevive.getInstance().add(new GameObject("Enemy1"));
        //if(timer==200)SpaceImpactRevive.getInstance().stopBackground();
    }
}
