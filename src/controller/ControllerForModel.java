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
import model.Model;
import model.ObstacleModel;
import model.ProjectileDxModel;
import model.ProjectileSxModel;
import model.SpaceShipModel;


/**
 *
 * @author gabriele fantini
 */
public class ControllerForModel implements IControllerForModel{
    private static IControllerForModel instance = null;
    private ControllerForModel(){
        Model.getInstance();
    }
    public static IControllerForModel getInstance(){
        if(instance==null)instance = new ControllerForModel();
        return instance;
    }
    @Override
    public void score(){
        Model.getInstance().score();
    }
    @Override
    public void toDo(){
        Model.getInstance().toDo();
    }
    @Override
    public void collide(int id){
        Model.getInstance().getElementById(id).getDamage();
    }
    public void levelTimer(){
        int i = Model.getInstance().getLevel();
    }
    public void setLevel(int i){
        Model.getInstance().setLevel(i);
    }
    public int getLevel(){
        return Model.getInstance().getLevel();
    }

    @Override
    public int addElement(String type) {
        int id = 0;
        switch (type){
            case "SpaceShip" :  id = Model.getInstance().addElement(new SpaceShipModel());break;
            case "Enemy" :  id = Model.getInstance().addElement(new EnemyModel());break;
            case "Enemy1" : id = Model.getInstance().addElement(new Enemy1Model()); break;
            case "Enemy2" : id = Model.getInstance().addElement(new Enemy2Model());break;
            case "ProjectileDx" :   id = Model.getInstance().addElement(new ProjectileDxModel());break;
            case "ProjectileSx" :   id = Model.getInstance().addElement(new ProjectileSxModel());break; 
            case "ProjectileSx1" :   id = Model.getInstance().addElement(new ProjectileSxModel());break; 
            case "Background" : id = Model.getInstance().addElement(new BackgroundModel());break; 
            case "Obstacle0" :  id = Model.getInstance().addElement(new ObstacleModel());break; 
            case "Obstacle140" :    id = Model.getInstance().addElement(new ObstacleModel());break; 
            case "Obstacle270" :    id = Model.getInstance().addElement(new ObstacleModel());break; 
        }
        return id;
    }

    
}
