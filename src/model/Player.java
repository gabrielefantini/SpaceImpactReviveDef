/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.SpaceImpactRevive;

/**
 *
 * @author gabri
 */
public class Player {
    private int life;
    private int score;
    private String name;
    private static Player instance = null;
    
    private Player(){
        score = 0;
        life=3;
    }
    public static Player getInstance(){
        if(instance == null)instance = new Player();
        return instance;
    }
    public void score(){
        score++;
    }    
    public int getScore(){
        return score;
    }
    public void removeLife() {
        if(life==1)SpaceImpactRevive.getInstance().GameOver();
        life--;
        SpaceImpactRevive.getInstance().removeHeart();
    }
    public void setName(String value){
        name = value;
    }
    public String getName(){
        return name;
    }
}
