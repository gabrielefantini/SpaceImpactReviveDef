package controller;

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


public class Controller implements IController{
    private static Controller instance=null;
    private Controller(){
        Model.getInstance();
        View.getInstance();
        
    }
    
    public static Controller getInstance(){
        if(instance==null)instance = new Controller();
        return instance;
    }
    public void addElement(String type){
        int id;
        switch (type){
            case "SpaceShip" :  id = Model.getInstance().addElement(new SpaceShipModel()); 
                                        View.getInstance().addElement(new SpaceShipView(),id);break;
            case "Enemy" :  id = Model.getInstance().addElement(new EnemyModel()); 
                                        View.getInstance().addElement(new EnemyView(),id);break;
            case "Enemy1" : id = Model.getInstance().addElement(new Enemy1Model()); 
                                        View.getInstance().addElement(new Enemy1View(),id);break;
            case "Enemy2" : id = Model.getInstance().addElement(new Enemy2Model()); 
                                        View.getInstance().addElement(new Enemy2View(),id);break;
            case "ProjectileDx" :   id = Model.getInstance().addElement(new ProjectileDxModel()); 
                                        View.getInstance().addElement(new ProjectileDxView(),id);break;
            case "ProjectileSx" :   id = Model.getInstance().addElement(new ProjectileSxModel()); 
                                        View.getInstance().addElement(new ProjectileSxView(0),id);break;
            case "ProjectileSx1" :   id = Model.getInstance().addElement(new ProjectileSxModel()); 
                                        View.getInstance().addElement(new ProjectileSxView(1),id);break;
            case "Background" : id = Model.getInstance().addElement(new BackgroundModel()); 
                                        View.getInstance().addElement(new BackgroundView(),id);break;
            case "Obstacle0" :  id = Model.getInstance().addElement(new ObstacleModel()); 
                                        View.getInstance().addElement(new ObstacleView(0),id);break;
            case "Obstacle140" :    id = Model.getInstance().addElement(new ObstacleModel()); 
                                        View.getInstance().addElement(new ObstacleView(140),id);break;
            case "Obstacle270" :    id = Model.getInstance().addElement(new ObstacleModel()); 
                                        View.getInstance().addElement(new ObstacleView(270),id);break;
        }
    }
    public void removeViewElementById(int id){
        View.getInstance().getElementById(id).remove();
        View.getInstance().removeElementById(id);
    }

    public void GameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void startFlicker(int id){
        View.getInstance().getElementById(id).startFlicker();
    }
    public void stopFlicker(int id){
        View.getInstance().getElementById(id).stopFlicker();
    }
    public void score(){
        Player.getInstance().score();
        StatusBar.getInstance().score();
    }
}
