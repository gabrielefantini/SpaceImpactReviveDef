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
public class Player {
    private int win;
    private int level;
    private int life;
    private int score;
    private String name;
    private static Player instance = null;
    
    private Player(){
        win=0;
        name = "Sconosciuto";
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
        if(life==1)Controller.getInstance().GameOver();
        life--;
    }
    public void setName(String value){
        name = value;
    }
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int i){
        level = i;
    }
    public void setLife(int n){
        life = n;
    }
    public int getLife(){
       return life;
    }

    public void setScore(int n) {
        score = n;
    }
    public void GameOver(){
        win = 2;
    }
    public void win(){
        win = 1;
    }

    public int getStatus() {
        return win;
    }
}
