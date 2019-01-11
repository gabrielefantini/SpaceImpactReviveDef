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
        System.out.println(timer);
        if(timer == 100){
            Controller.getInstance().addElement("Enemy1");
        }
        if(timer==1400)Controller.getInstance().addElement("Enemy");
        //if(timer==200)SpaceImpactRevive.getInstance().stopBackground();
    }

}
