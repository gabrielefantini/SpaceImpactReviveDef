/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;

/**
 *
 * @author gabri
 */
public class GameModel implements IGameModel{
    
    protected int life;
    protected int IMMUNITY;
    protected int immunity;
    protected String type;
    
    public GameModel(){
        life = 1;
        immunity=0;
    }

    public void getDamage(){
       if(immunity > 0){
            return;
        }
        if(life > 0){                            
            life--;
            immunity = IMMUNITY;
        }
        if(life==0){
            die();
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
    public boolean flicker(){
        if(immunity>0)return true;
        else
            return false;
    }

    public int getHashId() {
        return this.hashCode();
    }

    private void die() {
        Controller.getInstance().removeViewElementById(this.getHashId());
    }

    public void loop() {
        immunityTimer();
    }
}
