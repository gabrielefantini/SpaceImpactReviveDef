/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.BackgroundView;
import view.Bonus1View;
import view.Bonus2View;
import view.Enemy1View;
import view.Enemy2View;
import view.EnemyView;
import view.Level1;
import view.Level2;
import view.Level3;
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
            case "Bonus1" :View.getInstance().addElement(new Bonus1View(),id);break;
            case "Bonus2" :View.getInstance().addElement(new Bonus2View(),id);break;
        }
    }
    @Override
    public void removeViewElementById(int id){
        View.getInstance().getElementById(id).remove();
        View.getInstance().removeElementById(id);
    }

    @Override
    public int getLevelTimer() {
        switch(Controller.getInstance().getLevel()){
            case 1 : return Level1.getInstance().getLevelTime();
            case 2 : return Level2.getInstance().getLevelTime();
            case 3 : return Level3.getInstance().getLevelTime();
        }
        return 0;
    }

    @Override
    public void setLevelTimer(int t) {
        switch(Controller.getInstance().getLevel()){
            case 1 : Level1.getInstance().setTime(t);break;
            case 2 : Level2.getInstance().setTime(t);break;
            case 3 : Level3.getInstance().setTime(t);break;
        }
    }

    @Override
    public void setScore(int score) {
        StatusBar.getInstance().setScore(score);
    }

    @Override
    public void addLife() {
        View.getInstance().addLife();
    }

    @Override
    public void setRateo(int i) {
        View.getInstance().setRateo(i);
    }
}
