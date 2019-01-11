package controller;

import javafx.animation.AnimationTimer;


public class Controller implements IController{
    private static Controller instance=null;
    private AnimationTimer timer;
   
    private Controller(){
        ControllerForModel.getInstance();
        ControllerForView.getInstance();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameLoop();
            }
        };
    }
    public static IController getInstance(){
        if(instance==null)instance = new Controller();
        return instance;
    }
    @Override
    public int addElement(String type){
        int id = 0;
        switch (type){
            case "SpaceShip" :  id = ControllerForModel.getInstance().addElement("SpaceShip"); 
                                        ControllerForView.getInstance().addElement(id,"SpaceShip");break;
            case "Enemy" :  id = ControllerForModel.getInstance().addElement("Enemy"); 
                                        ControllerForView.getInstance().addElement(id,"Enemy");break;
            case "Enemy1" : id = ControllerForModel.getInstance().addElement("Enemy1"); 
                                        ControllerForView.getInstance().addElement(id,"Enemy1");break;
            case "Enemy2" : id = ControllerForModel.getInstance().addElement("Enemy2"); 
                                        ControllerForView.getInstance().addElement(id,"Enemy2");break;
            case "ProjectileDx" :   id = ControllerForModel.getInstance().addElement("ProjectileDx"); 
                                        ControllerForView.getInstance().addElement(id,"ProjectileDx");break;
            case "ProjectileSx" :   id = ControllerForModel.getInstance().addElement("ProjectileSx"); 
                                        ControllerForView.getInstance().addElement(id,"ProjectileSx");break;
            case "ProjectileSx1" :   id = ControllerForModel.getInstance().addElement("ProjectileSx1"); 
                                        ControllerForView.getInstance().addElement(id,"ProjectileSx1");break;
            case "Background" : id = ControllerForModel.getInstance().addElement("Background"); 
                                        ControllerForView.getInstance().addElement(id,"Background");break;
            case "Obstacle0" :  id = ControllerForModel.getInstance().addElement("Obstacle0"); 
                                        ControllerForView.getInstance().addElement(id,"Obstacle0");break;
            case "Obstacle140" :    id = ControllerForModel.getInstance().addElement("Obstacle140"); 
                                        ControllerForView.getInstance().addElement(id,"Obstacle140");break;
            case "Obstacle270" :    id = ControllerForModel.getInstance().addElement("Obstacle270"); 
                                        ControllerForView.getInstance().addElement(id,"Obstacle270");break;
        }
        return id;
    }
    @Override
    public void removeViewElementById(int id){
        ControllerForView.getInstance().removeViewElementById(id);
    }

    @Override

    public void GameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void startFlicker(int id){
        ControllerForView.getInstance().startFlicker(id);
    }
    @Override
    public void stopFlicker(int id){
        ControllerForView.getInstance().stopFlicker(id);
    }
    @Override
    public void score(){
        ControllerForModel.getInstance().score();
        ControllerForView.getInstance().score();
    }
    @Override
    public void start(){
        timer.start();
    }
    @Override

    public void stop(){
        timer.stop();
    }
    @Override
    public void gameLoop(){
        levelTimer();
        ControllerForModel.getInstance().toDo();
        ControllerForView.getInstance().toDo();
    }
    @Override
    public void collide(int id){
        ControllerForModel.getInstance().collide(id);
    }
    @Override
    public void levelTimer(){
        int i = ControllerForModel.getInstance().getLevel();
        ControllerForView.getInstance().levelTimer(i);
    }
    @Override
    public void setLevelTimer(int t){
        ControllerForView.getInstance().setLevelTimer(t);
    }
    @Override
    public void setLevel(int i){
        ControllerForModel.getInstance().setLevel(i);
    }
    @Override
    public int getCurrentLevel(){
        return ControllerForModel.getInstance().getCurrentLevel();
    }

    @Override
    public void removeHeart() {
        ControllerForView.getInstance().removeLife();
    }

    @Override
    public void setName(String name) {
        ControllerForModel.getInstance().setName(name);
    }

    @Override
    public String getName() {
        return ControllerForModel.getInstance().getName();
    }

    @Override
    public void setSpaceShip(int n) {
        ControllerForModel.getInstance().setSpaceShip(n);
    }
    @Override
    public int getCurrentLife(){
        return ControllerForModel.getInstance().getCurrentLife();
    }
    @Override
    public void setLife(int n){
        ControllerForModel.getInstance().setLife(n);
    }
    @Override
    public int getLife(){
        return ControllerForModel.getInstance().getLife();
    }
    @Override
    public int getLevel() {
        return ControllerForModel.getInstance().getLevel();
    }
    @Override
    public void setCurrentLevel(int n){
        ControllerForModel.getInstance().setCurrentLevel(n);
    }
    @Override
    public void setCurrentLife(int n){
        ControllerForModel.getInstance().setCurrentLife(n);
    }

    @Override
    public int getLevelTimer() {
        return ControllerForView.getInstance().getLevelTimer();
    }

    @Override
    public void setCurrentTime(int levelTimer) {
        ControllerForModel.getInstance().setCurrentTime(levelTimer);
    }
    @Override
    public int getCurrentTime() {
        return ControllerForModel.getInstance().getCurrentTime();
    }

    @Override
    public void setPlayerName() {
        ControllerForModel.getInstance().setPlayerName();
    }

    @Override
    public String getCurrentName() {
        return ControllerForModel.getInstance().getCurrentName();
    }
}

