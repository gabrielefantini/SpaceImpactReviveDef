/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import model.Player;
import view.GameWindow;
import view.Level1;
import view.Level2;
import view.Level3;

import view.StatusBar;

/**
 *
 * @author gabri
 */
public class SpaceImpactRevive {
    private static SpaceImpactRevive instance=null;
    private ArrayList<GameObject> array;
    private int currentLevel;
    private boolean sound;
    
    private SpaceImpactRevive(){
        this.array = new ArrayList<>();
        sound = true;
    }
    
    public static SpaceImpactRevive getInstance(){
        if(instance==null)instance = new SpaceImpactRevive();
        return instance;
    }
    public void setLevel(int level){
        currentLevel = level;
    }
    public int getLevel(){
        return currentLevel;
    }
    public void add(GameObject g){
        array.add(g);
    }
     
    public void setSound(){
        if(sound)sound=false;
        else
            sound=true;
    }
    
    public void gameLoop(){
        sync();
        animate();
        check();
    }
    
    public void sync(){
        //verifica se gli oggetti collidono tramite il metodo collisionCheck e dai al model degli oggetti il timer
        for(int i = 0; i < array.size(); i++){
            GameObject g = array.get(i);
            for(int l = 0; l < array.size(); l++){
                GameObject f = array.get(l);
                if(!g.equals(f))
                    collisionCheck(g,f);
            }
            g.timer();
            g.setSound(sound);
        }
    }
    
    public void animate(){
        if(!array.isEmpty()){
            for(int i = 0; i < array.size(); i++){
                GameObject g = array.get(i);
                g.animationLoop();
                g.flicker();
            }
       }
    }
    public void check(){ //aggiorna l'array e vedi se ci sono elementi da rimuovere
        if(!array.isEmpty()){
            for(int i = 0; i < array.size(); i++){
                GameObject g =array.get(i);
                if(g.daDistruggere()){
                    g.die();
                    array.remove(g);
                }
            }
       }       
    }

    public void score() {
        Player.getInstance().score();
        StatusBar.getInstance().score();
    }
    public void collisionCheck(GameObject a, GameObject b){
        if(a.intersect(b) && !a.getType().equals(b.getType()) && !a.getType().equals("Background") && !b.getType().equals("Background")){
            a.collide();
            b.collide();
            if(a.getType().equals("Enemy") || b.getType().equals("Enemy")||
                    a.getType().equals("Enemy1") || b.getType().equals("Enemy1")||
                    a.getType().equals("Enemy2") || b.getType().equals("Enemy2")||
                    a.getType().equals("Obstacle0") || b.getType().equals("Obstacle0")||
                    a.getType().equals("Obstacle140") || b.getType().equals("Obstacle140")||
                    a.getType().equals("Obstacle270") || b.getType().equals("Obstacle270"))//un nemico è stato colpito da qualcosa e quindi ottengo un punto
                score();
        }
    }
    public void GameOver(){
        System.out.println("GAME OVER");
        switch (this.currentLevel){
            case 1: Level1.getInstance().stop();break;
            case 2: Level2.getInstance().stop();break;
            case 3: Level3.getInstance().stop();break;
        }
        GameWindow.getInstance().GameOver();
    }

    public void removeHeart() {
        StatusBar.getInstance().removeLife();
    }
    public void stopBackground(){
        for(int i = 0; i < array.size(); i++){
            GameObject g =array.get(i);
            if(g.getType().equals("Background")){
                g.stopBackground();
            }
        }
    }
}
