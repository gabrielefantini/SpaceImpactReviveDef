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
    private int score;
    private static Player instance = null;
    
    private Player(){
        score = 0;
    }
    public static Player getInstance(){
        if(instance == null)instance = new Player();
        return instance;
    }
    public void score(){
        score++;
    }
}
