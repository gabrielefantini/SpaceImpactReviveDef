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
public class Enemy2Model extends Enemy1Model{
        public Enemy2Model(){
        super();
        life = 2;
        IMMUNITY=150;
        type = "Enemy2";
    }
}
