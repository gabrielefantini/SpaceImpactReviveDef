/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author gabriele fantini
 */
public interface IControllerForModel {

    public void score();

    public void toDo();
    
    public void collide(int id);

    public int getLevel();

    public void setLevel(int i);
    
    public int addElement(String type);
    
    public void setName(String name);
     
    public String getName();
    
    public void setSpaceShip(int n);
    
    public void setTime(int time);
    
    public int getTime();
    
    public int getSpaceShip();
    
    public int getCurrentLevel();
    
    public void setCurrentLevel(int n);
    
    public int getCurrentLife();
    
    public void setCurrentLife(int n);
    
    public int getCurrentScore();
    
    public void setCurrentScore(int n);
    
    public void setLife(int n);
}
