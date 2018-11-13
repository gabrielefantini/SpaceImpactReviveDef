/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.animation.AnimationTimer;
import model.BackgroundModel;
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
        for(int i = 0;i<getLife();i++)
                StatusBar.getInstance().addLife();
        rateo = 0;
    }
    
    public static SpaceImpactRevive getInstance(){
        if(instance==null)instance = new SpaceImpactRevive();
        return instance;
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
        //verifica se i bounds del model, aggiornati, collidono tramite il metodo collisionCheck 
        for(int i = 0; i < array.size(); i++){
            GameObject g = array.get(i);
            for(int l = 0; l < array.size(); l++){
                GameObject f = array.get(l);
                if(!g.equals(f))
                    collisionCheck(g,f);
            }
            if(g.getType() == "SpaceShip" && GameWindow.FIRE && rateo==0){
                fire(1,g);
                rateo = 10;
            }
            g.immunityTimer();
        }
        if(rateo>0)
            rateo--;
        
    }
    
    public void animate(){
        //muovi elementi modificando minx e miny dei bounds del model
        if(!array.isEmpty()){
            for(int i = 0; i < array.size(); i++){
                GameObject g = array.get(i);
                g.animationLoop();
            }
       }
    }
    public void check(){ //aggiorna 
        if(!array.isEmpty()){
            for(int i = 0; i < array.size(); i++){
                GameObject g =array.get(i);
                if(g.check()){
                    g.die();
                    array.remove(g);
                }
            }
       }       
    }

    public void score() {
        Player.getInstance().score();
        StatusBar.getInstance().score(getScore());
    }
    public void collisionCheck(GameObject a, GameObject b){
        if(a.getBounds().intersects(b.getBounds()) && !a.getClass().isInstance(b) && !(a instanceof BackgroundModel) && !(b instanceof BackgroundModel)){
            a.collide();
            b.collide();
            if(a instanceof EnemyModel || b instanceof EnemyModel)//un nemico è stato colpito da qualcosa e quindi ottengo un punto
                score();
        }
    }  
    public int getLife(){
        for(int i = 0; i < GameModel.getInstance().getSize(); i++){
            GameObject g = GameModel.getInstance().get(i);
            if(g instanceof SpaceShipModel)return g.getLife();
        }
        return 0;
    }
    public void removeLife(){
        for(int i = 0; i < GameModel.getInstance().getSize(); i++){
            GameObject g = GameModel.getInstance().get(i);
            if(g instanceof SpaceShipModel)g.getDamage();
        }
        StatusBar.getInstance().removeLife();
        for(int i = 0;i<getLife();i++)
                StatusBar.getInstance().addLife();
    }
 
    public void fire(int direction,GameObject g){
        System.out.println("fire");
        int x = 0;
        int y=0; 
        if(direction >0){
            x = (int)g.getBounds().getMaxX()+1;
            y = (int)((int)g.getBounds().getMaxY()-g.getBounds().getHeight()/2);
            ProjectileDxModel p = new ProjectileDxModel();
            GameModel.getInstance().add(p);
            p.upBounds(new BoundingBox(x, y, 0, 0));
            
        }
        if(direction <=0){
            x = (int)g.getBounds().getMinX()- 30;
            y = (int) ((int)g.getBounds().getMinY()+ g.getBounds().getHeight()/2);
            ProjectileSxModel p = new ProjectileSxModel();
            GameModel.getInstance().add(p);
            p.upBounds(new BoundingBox(x, y, 0, 0));
        }
        
    }
}
