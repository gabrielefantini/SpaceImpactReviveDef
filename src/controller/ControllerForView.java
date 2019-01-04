/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.BackgroundView;
import view.Enemy1View;
import view.Enemy2View;
import view.EnemyView;
import view.ObstacleView;
import view.ProjectileDxView;
import view.ProjectileSxView;
import view.SpaceShipView;
import view.StatusBar;
import view.View;

/**
 *
 * @author gabriele fantini
 */
public class ControllerForView implements IControllerForView{
    private static IControllerForView instance = null;
    private ControllerForView(){
        View.getInstance();
    }
    public static IControllerForView getInstance(){
        if(instance==null)instance = new ControllerForView();
        return instance;
    }
    @Override
    public void startFlicker(int id){
        View.getInstance().getElementById(id).startFlicker();
    }
    @Override
    public void stopFlicker(int id){
        View.getInstance().getElementById(id).stopFlicker();
    }
    @Override
    public void score(){
        StatusBar.getInstance().score();
    }
    @Override
    public void toDo(){
        View.getInstance().toDo();
    }
    @Override
    public void levelTimer(int i){
        View.getInstance().levelTime(i);
    }
    public void removeHeart() {
        View.getInstance().removeLife();
    }

    @Override
    public void removeLife() {
        View.getInstance().removeLife();
    }

    @Override
    public void addElement(int id, String type) {
        switch (type){
            case "SpaceShip" : View.getInstance().addElement(new SpaceShipView(),id);break;
            case "Enemy" : View.getInstance().addElement(new EnemyView(),id);break;
            case "Enemy1" :View.getInstance().addElement(new Enemy1View(),id);break;
            case "Enemy2" :View.getInstance().addElement(new Enemy2View(),id);break;
            case "ProjectileDx" :View.getInstance().addElement(new ProjectileDxView(),id);break;
            case "ProjectileSx" :View.getInstance().addElement(new ProjectileSxView(0),id);break;
            case "ProjectileSx1" :View.getInstance().addElement(new ProjectileSxView(1),id);break;
            case "Background" :View.getInstance().addElement(new BackgroundView(),id);break;
            case "Obstacle0" : View.getInstance().addElement(new ObstacleView(0),id);break;
            case "Obstacle140" :View.getInstance().addElement(new ObstacleView(140),id);break;
            case "Obstacle270" :View.getInstance().addElement(new ObstacleView(270),id);break;
        }
    }
    @Override
    public void removeViewElementById(int id){
        View.getInstance().getElementById(id).remove();
        View.getInstance().removeElementById(id);
    }
}
