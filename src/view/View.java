/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author gabriele fantini
 */
public class View implements IView{
    private static View instance = null;
    private ArrayList<GameView> array;
    
    private boolean sound;
    
    private View(){
        array = new ArrayList<>();
        sound = true;
    }
    public static IView getInstance(){
        if(instance==null)instance=new View();
        return instance;
    }
    @Override
    public void addElement(GameView x, int id){
        array.add(x);
        x.setHashId(id);
    }
    @Override
    public GameView getElementById(int hashId){
        for(int i = 0; i<array.size(); i++)
            if(array.get(i).getHashId()==hashId)return array.get(i);
        return null;
    }
    @Override
    public void removeElementById(int hashId){
        for(int i = 0; i<array.size(); i++)
            if(array.get(i).getHashId()==hashId)array.remove(i);
    }
    @Override
    public void toDo() {
        for(int i = 0; i<array.size(); i++){
            array.get(i).setSound(sound);
            array.get(i).loop();
            array.get(i).outOfSpace();
        }
        for(int i = 0; i < array.size(); i++){
            GameView g = array.get(i);
            for(int l = 0; l < array.size(); l++){
                GameView f = array.get(l);
                if(!g.equals(f))
                    collisionCheck(g,f);
            }
        }
    }
    @Override
    public void collisionCheck(GameView a, GameView b){
        if(a.intersect(b) && !a.getType().equals(b.getType()) && (a.getType().equals("Bonus1") || b.getType().equals("Bonus1")||a.getType().equals("Bonus2") || b.getType().equals("Bonus2"))&& !a.getType().equals("Background") && !b.getType().equals("Background")){
            if(a.getType().equals("Bonus1")||a.getType().equals("Bonus2"))a.collide();
            if(b.getType().equals("Bonus1")||b.getType().equals("Bonus2"))b.collide();
            return;
        }
        if(a.intersect(b) && !a.getType().equals(b.getType()) && !a.getType().equals("Background") && !b.getType().equals("Background")){
            a.collide();
            b.collide();
            if(a.getType().equals("Enemy") || b.getType().equals("Enemy")||
                    a.getType().equals("Enemy1") || b.getType().equals("Enemy1")||
                    a.getType().equals("Enemy2") || b.getType().equals("Enemy2")||
                    a.getType().equals("Obstacle0") || b.getType().equals("Obstacle0")||
                    a.getType().equals("Obstacle140") || b.getType().equals("Obstacle140")||
                    a.getType().equals("Obstacle270") || b.getType().equals("Obstacle270"))//un nemico è stato colpito da qualcosa e quindi ottengo un punto
                Controller.getInstance().score();
        }
    }

    @Override
    public void setSound() {
        sound = !sound;
    }

    @Override
    public void levelTime(int i) {
        switch(i){
            case 1: Level1.getInstance().levelTime();break;
            case 2: Level2.getInstance().levelTime();break;
            case 3: Level3.getInstance().levelTime();break;
        }
    }

    @Override
    public void removeLife() {
        StatusBar.getInstance().removeLife();
    }
    public void addLife(){
        StatusBar.getInstance().addLife();
    }
    public void setRateo(int r){
        for(int i = 0; i <array.size(); i++){
            GameView g = array.get(i);
            if(g.getType().equals("SpaceShip"))g.setRateo(r);
        }
    }
    
}
