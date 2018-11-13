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
public class Player {
    private int life;
    private int score;
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
    
    public void removeLife() {
        if(life==1)SpaceImpactRevive.gameOver();
        life--;
    }
}
