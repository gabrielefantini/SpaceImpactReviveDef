/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ProjectileModel extends GameModel{
    public ProjectileModel(){
        super();
        life = 3;
        IMMUNITY = 300;
        type = "Projectile";        
    } 
}
