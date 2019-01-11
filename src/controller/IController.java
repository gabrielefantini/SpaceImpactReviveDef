/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



public interface IController{
    public int addElement(String type);
    public void removeViewElementById(int id);
    public void GameOver();
    public void startFlicker(int id);
    public void stopFlicker(int id);
    public void score();
    public void start();
    public void stop();
    public void gameLoop();
    public void collide(int id);
    public void levelTimer();    
    public int getLevel();
    public void setLevel(int i);
    public void removeHeart();
    public void setName(String name);
    public String getName();
    public void setSpaceShip(int n);
    public int getCurrentLevel();
    public int getCurrentLife();
    public void setLife(int n);
    public void setCurrentLevel(int level);
    public int getLife();
    public void setCurrentLife(int n);
    public int getLevelTimer();
    public void setLevelTimer(int t);
    public void setCurrentTime(int levelTimer);
    public int getCurrentTime();
    public void setPlayerName();

    public String getCurrentName();
}
