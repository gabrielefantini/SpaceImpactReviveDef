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
    
    public void setCurrentTime(int time);
    
    public int getCurrentTime();
    
    public int getSpaceShip();
    
    public int getCurrentLevel();
    
    public void setCurrentLevel(int n);
    
    public int getCurrentLife();
    
    public void setCurrentLife(int n);
    
    public int getCurrentScore();
    
    public void setCurrentScore(int n);
    
    public void setLife(int n);
    
    public int getLife();
    
    public void setPlayerName();

    public String getCurrentName();

    public int getScore();

    public void setScore(int score);

    public void GameOver();

    public void win();
    
    public int PlayerStatus();

    public String getTopPlayer();

    public String getTopScore();

    public void setTopPlayer(String name);

    public void setTopScore(int score);
}
