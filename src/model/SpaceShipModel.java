/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.GameModel;

/**
 *
 * @author gabri
 */
public class SpaceShipModel extends GameModel{
    public SpaceShipModel(){
        life = 3;
        IMMUNITY = 300;
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
                immunity = IMMUNITY;
            }
        } 
    }
}
