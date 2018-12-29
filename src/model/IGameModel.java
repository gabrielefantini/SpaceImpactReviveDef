/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriele fantini
 */
public interface IGameModel {
    public void getDamage();
    public void addLife();
    public int getLife();
    public void immunityTimer();
    public boolean flicker();
    public int getHashId();
    public void die();
    public void loop();
}
