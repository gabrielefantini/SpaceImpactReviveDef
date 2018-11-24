/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.animation.AnimationTimer;
import model.GameModel;
import java.util.ArrayList;
import model.EnemyModel;
import model.Player;
import model.ProjectileDxModel;
import model.ProjectileSxModel;
import model.SpaceShipModel;
import view.GameWindow;
import view.Space;
import view.StatusBar;

/**
 *
 * @author gabri
 */
public class SpaceImpactRevive extends AnimationTimer{
    private static SpaceImpactRevive instance=null;
    private ArrayList<GameObject> array;
    private int rateo;
    
    private SpaceImpactRevive(){
        this.array = new ArrayList<GameObject>();
        rateo = 0;
    }
    
    public static SpaceImpactRevive getInstance(){
        if(instance==null)instance = new SpaceImpactRevive();
        return instance;
    }
    
     public void add(GameObject g){
        array.add(g);
    }
     
    @Override
    public void handle(long now) {
        gameLoop();
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
            if(a.getType().equals("Enemy") || b.getType().equals("Enemy"))//un nemico è stato colpito da qualcosa e quindi ottengo un punto
                score();
        }
    }
    public void GameOver(){
        System.out.println("GAME OVER");
        this.stop();
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
