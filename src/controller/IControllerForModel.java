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
}
