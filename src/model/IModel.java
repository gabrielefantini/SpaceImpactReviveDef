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
public interface IModel {
    public int addElement(GameModel x);
    public GameModel getElementById(int hashId);
    public void toDo();
    public void score();
    public int getLevel();
    public void setLevel(int i);
}
