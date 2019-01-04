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
public interface IControllerForView {

    public void score();

    public void toDo();

    public void removeLife();

    public void levelTimer(int i);
    
    public void addElement(int id,String type);

    public void removeViewElementById(int id);

    public void startFlicker(int id);

    public void stopFlicker(int id);
}
