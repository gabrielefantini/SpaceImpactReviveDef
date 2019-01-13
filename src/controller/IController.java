/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;



public interface IController{
    
    //metodi per la gestione degli elementi del gioco
    public int addElement(String type);
    public void removeViewElementById(int id);
    public void startFlicker(int id);
    public void stopFlicker(int id);
    public void collide(int id);
    
    //metodi per la gestione della partita
    public void GameOver();
    public void win();
    public void score();
    public void setName(String name);
    public String getName();
    public void removeHeart();
    public void setLife(int n);
    public int getLife();
    public void addLife();//parte grafica
    public void setPlayerName();
    public int getScore();
    public void setScore(int score);
    public void setRateo(int i);
    public int PlayerStatus();
    
    //metodi per la gestione dei loop
    public void start();
    public void stop();
    public void gameLoop();
    
    //metodi per la gestione del livello

    public void levelTimer();    
    public int getLevel();
    public void setLevel(int i);
    
    //metodi per il salvataggio
    public void setSpaceShip(int n);
    public void setCurrentLevel(int level);
    public void setCurrentLife(int n);
    public void setLevelTimer(int t);
    public void setCurrentTime(int levelTimer);
    public void setCurrentScore(int score);
    public void setTopPlayer(String name);
    public void setTopScore(int score);
    
    //metodi per il caricamento
    public int getCurrentLevel();
    public int getCurrentLife();
    public int getLevelTimer();
    public int getCurrentTime();
    public String getCurrentName();
    public int getCurrentScore();
    public String getTopPlayer();
    public String getTopScore();
   

}
