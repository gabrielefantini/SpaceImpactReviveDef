/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BackgroundModel;
import model.Enemy1Model;
import model.Enemy2Model;
import model.EnemyModel;
import model.GameModel;
import model.ObstacleModel;
import model.ProjectileDxModel;
import model.ProjectileSxModel;
import model.SpaceShipModel;
import view.GameView;
import view.*;

/**
 *
 * @author gabri
 */
public class GameObject {
    private GameModel model;
    private GameView view;
    private String type;
    
    public GameObject(String nomeEntita){
        model = new GameModel();
        view = new GameView();
        type = nomeEntita;
        
        switch (nomeEntita){
            case "SpaceShip" : model = new SpaceShipModel(); view = new SpaceShipView(); break;
            case "Enemy" : model = new EnemyModel(); view = new EnemyView(); break;
            case "Enemy1" : model = new Enemy1Model(); view = new Enemy1View(); break;
            case "Enemy2" : model = new Enemy2Model(); view = new Enemy2View(); break;
            case "ProjectileDx" : model = new ProjectileDxModel(); view = new ProjectileDxView(); break;
            case "ProjectileSx" : model = new ProjectileSxModel(); view = new ProjectileSxView(0); break;
            case "ProjectileSx1" : model = new ProjectileSxModel(); view = new ProjectileSxView(1); break;
            case "Background" : model = new BackgroundModel(); view = new BackgroundView(); break;
            case "Obstacle0" : model = new ObstacleModel(); view = new ObstacleView(0); break;
            case "Obstacle140" : model = new ObstacleModel(); view = new ObstacleView(140); break;
            case "Obstacle270" : model = new ObstacleModel(); view = new ObstacleView(270); break;
        }
    }
    public void die(){
        view.remove();
    }
    public String getType(){
        return type;
    }
    public void timer(){
        model.immunityTimer();
    }
    public void animationLoop(){
        this.view.animationLoop();
    }
    public boolean daDistruggere(){
        return model.getLife()<= 0 || view.outOfSpace();
    }
    public boolean intersect(GameObject b){
        return view.getBounds().intersects(b.returnView().getBounds());
    }
    public GameView returnView(){
        return this.view;
    }
    public GameModel returnModel(){
        return this.model;
    }
    public void collide(){
        model.collide();
    }
    public void flicker(){
        if(type.equals("SpaceShip")){
        if(model.flicker())
            view.flicker();
        if(!model.flicker())
            view.stopFlicker();
        }
    }
    public void set(int x, int y){
        this.view.set(x, y);
    }

    void stopBackground() {
        view.stopBackground();
    }
}
