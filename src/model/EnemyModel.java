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
public class EnemyModel extends GameModel{
    public EnemyModel(){
        super();
        life = 3;
        IMMUNITY = 200;
        type = "Enemy";
    }
}
