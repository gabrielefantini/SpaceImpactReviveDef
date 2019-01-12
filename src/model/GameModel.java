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

    @Override
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
    @Override
    public void addLife(){
        life++;
    } 
    @Override
    public int getLife() {
        return life;
    }
    @Override
    public void immunityTimer(){
        if(immunity>0)immunity--;
    }
    @Override
    public boolean flicker(){
        if(immunity>0)return true;
        else
            return false;
    }

    @Override
    public int getHashId() {
        return this.hashCode();
    }

    @Override
    public void die() {
        Controller.getInstance().removeViewElementById(this.getHashId());
    }

    @Override
    public void loop() {
        immunityTimer();
    }
}
