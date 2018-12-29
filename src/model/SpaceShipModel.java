/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;


public class SpaceShipModel extends GameModel{
    public SpaceShipModel(){
        super();
        life = 3;
        IMMUNITY = 300;
        type = "SpaceShip";        
        System.out.println("model.SpaceShipModel.<init>()");
    }
    @Override
    public void getDamage(){
       if(immunity > 0){
            return;
        }
        else{
            if(life > 0){                            
                life--;
                Player.getInstance().removeLife();
                Controller.getInstance().removeHeart();
                immunity = IMMUNITY;
            }
        } 
    }
    @Override
    public void loop(){
        immunityTimer();
        if(flicker())Controller.getInstance().startFlicker(this.getHashId());
        if(!flicker())Controller.getInstance().stopFlicker(this.getHashId());
    }
}
