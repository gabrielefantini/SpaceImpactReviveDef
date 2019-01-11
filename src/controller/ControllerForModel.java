/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Config;
import model.BackgroundModel;
import model.Enemy1Model;
import model.Enemy2Model;
import model.EnemyModel;
import model.Model;
import model.ObstacleModel;
import model.Player;
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
        Model.getInstance().getLevel();
    }
    @Override
    public void setLevel(int i){
        Model.getInstance().setLevel(i);
    }
    
    @Override
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

    @Override
    public void setName(String name) {
        Player.getInstance().setName(name);
    }

    @Override
    public String getName() {
        return Player.getInstance().getName();
    }

    @Override
    public void setSpaceShip(int n) {
        try {
            Config.getInstance().setSpaceShip(n);
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void setCurrentTime(int time) {
        try {
            Config.getInstance().setTime(time);
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCurrentTime() {
        return Config.getInstance().getTime();
    }

    @Override
    public int getSpaceShip() {
        return Config.getInstance().getSpaceShip();
    }

    @Override
    public int getCurrentLevel() {
        return Config.getInstance().getCurrentLevel();
    }

    @Override
    public void setCurrentLevel(int n) {
        try {
            Config.getInstance().setCurrentLevel(n);
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCurrentLife() {
        return Config.getInstance().getCurrentLife();
    }

    @Override
    public void setCurrentLife(int n) {
        try {
            Config.getInstance().setCurrentLife(n);
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCurrentScore() {
        return Config.getInstance().getCurrentScore();
    }

    @Override
    public void setCurrentScore(int n) {
        try {
            Config.getInstance().setCurrentScore(n);
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void setLife(int n){
        Player.getInstance().setLife(n);
    }
    @Override
    public int getLife(){
        return Player.getInstance().getLife();
    }

    @Override
    public void setPlayerName() {
        try {
            Config.getInstance().setPlayerName(Controller.getInstance().getName());
        } catch (IOException ex) {
            Logger.getLogger(ControllerForModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getCurrentName() {
        return Config.getInstance().getCurrentName();
    }
    
}
