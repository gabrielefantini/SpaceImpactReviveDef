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
public class ObstacleModel extends EnemyModel{
    public ObstacleModel(){
        super();
        life=2;
        IMMUNITY=150;        
        type = "Obstacle";
    }
}
