/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GameObject;


/**
 *
 * @author gabri
 */
public class GameModel {
    protected int life;
    protected int IMMUNITY;
    protected int immunity;
    protected int rateo;
    protected int velocity;
    
    public GameModel(){
    }
    public void collide(){
        getDamage();
    }
    public void getDamage(){
       if(immunity > 0){
            return;
        }
        else{
            if(life > 0){                            
                life--;
                immunity = IMMUNITY;
            }
        } 
    }
    public void addLife(){
        life++;
    } 
    public int getLife() {
        return life;
    }
    public void immunityTimer(){
        if(immunity>0)immunity--;
    }
}
