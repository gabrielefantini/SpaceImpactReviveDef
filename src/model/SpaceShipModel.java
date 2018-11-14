/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabri
 */
public class SpaceShipModel extends GameModel{
    public SpaceShipModel(){
        super();
        life = 3;
        IMMUNITY = 300;
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
                immunity = IMMUNITY;
            }
        } 
    }
}
