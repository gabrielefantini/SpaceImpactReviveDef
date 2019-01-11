/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author gabri
 */
public class Config {
    //STATIC FIELDS
    private static Config config = null;

    //INSTANCE FIELDS
    private Properties properties;
    
    
    private Config() {
        try {
            this.properties = new Properties();
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        }
        catch(IOException e) {
            
        }

    } // end constructor
    

    public static Config getInstance(){
        if(config == null)config = new Config();
        return config;
    }
    private void save() throws IOException{
        FileOutputStream out = new FileOutputStream("config.properties");
        properties.store(out, null);
        out.close();
    }
    
    public void setTime(int time){
        String t = Integer.toString(time);
        this.properties.setProperty("Time",t);
    }
    public int getTime(){
        return Integer.valueOf(this.properties.getProperty("Time"));
    }
    public int getSpaceShip(){
        return Integer.valueOf(this.properties.getProperty("SpaceShip"));
    }
    public void setSpaceShip(int n) throws IOException{
        String number = Integer.toString(n);
        this.properties.setProperty("SpaceShip", number);
        save();
    }
    public int getCurrentLevel(){
        return Integer.valueOf(this.properties.getProperty("Level"));
    }
    public void setCurrentLevel(int n){
        String number = Integer.toString(n);
        this.properties.setProperty("Level", number);
    }
    public int getCurrentLife(){
        return Integer.valueOf(this.properties.getProperty("Life"));
    }
    public void setCurrentLife(int n){
        String number = Integer.toString(n);
        this.properties.setProperty("Score", number);
    }
    public int getCurrentScore(){
        return Integer.valueOf(this.properties.getProperty("Level"));
    }
    public void setCurrentScore(int n){
        String number = Integer.toString(n);
        this.properties.setProperty("Score", number);
    }
}

