/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BackgroundModel;
import model.Enemy1Model;
import model.GameModel;
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
            case "Enemy1" : model = new Enemy1Model(); view = new Enemy1View(); break;
            case "ProjectileDx" : model = new ProjectileDxModel(); view = new ProjectileDxView(); break;
            case "ProjectileSx" : model = new ProjectileSxModel(); view = new ProjectileSxView(); break;
            case "Background" : model = new BackgroundModel(); view = new BackgroundView(); break;
        }
    }
    public void die(){
        view.remove();
    }
    public String getType(){
        return type;
    }
    public void immunityTimer(){
        model.immunityTimer();
    }
    public void animationLoop(){
        this.view.animationLoop();
    }
    public boolean check(){
        if(model.getLife()<= 0 || view.outOfSpace())
            return true;
        else
            return false;
    }
}
