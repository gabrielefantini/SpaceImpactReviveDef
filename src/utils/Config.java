/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;

/**
 *
 * @author gabri
 */
public class Config {
    private static Config instance = null;
    private Properties properties;
    private Config(){
    }
    public static Config getInstance(){
        if(instance==null)instance = new Config();
        return instance;
    }
    public String getRecord(){
        return new String();
    }
    public void setNewRecord(String name, int score){
        
    }
    public int getLevelTime(){
        return 1;
    }
    public void setTimeAtEnd(int levelTime){
        
    }
}

