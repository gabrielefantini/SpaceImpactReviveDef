/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author gabriele fantini
 */
public interface IView {
    public void addElement(GameView x, int id);
    public GameView getElementById(int hashId);
    public void removeElementById(int hashId);
    public void toDo();
    public void collisionCheck(GameView a, GameView b);
    public void setSound();
    public void levelTime(int i);
    public void removeLife();
}
