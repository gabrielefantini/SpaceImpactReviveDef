/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author gabriele fantini
 */
public class Model implements IModel{
    private static Model instance = null;
    private ArrayList<GameModel> array;
    
    private Model(){
        array = new ArrayList<GameModel>();
    }
    public static IModel getInstance(){
        if(instance==null)instance=new Model();
        return instance;
    }
    public int addElement(GameModel x){
        array.add(x);
        return x.getHashId();
    }
    public GameModel getElementById(int hashId){
        for(int i = 0; i<array.size(); i++)
            if(array.get(i).getHashId()==hashId)return array.get(i);
        return null;
    }

    @Override
    public void toDo() {
        for(int i = 0; i<array.size(); i++)
            array.get(i).loop();
    }

    @Override
    public void score() {
        Player.getInstance().score();
    }

    @Override
    public int getLevel() {
        return Player.getInstance().getLevel();
    }

    @Override
    public void setLevel(int i) {
        Player.getInstance().setLevel(i);
    }
    
}
