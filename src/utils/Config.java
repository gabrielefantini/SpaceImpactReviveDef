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
    
    public void setTime(int time) throws IOException{
        String t = Integer.toString(time);
        this.properties.setProperty("Time",t);
        save();
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
    public void setCurrentLevel(int n) throws IOException{
        String number = Integer.toString(n);
        this.properties.setProperty("Level", number);
        save();
    }
    public int getCurrentLife(){
        return Integer.valueOf(this.properties.getProperty("Life"));
    }
    public void setCurrentLife(int n) throws IOException{
        String number = Integer.toString(n);
        this.properties.setProperty("Life", number);
        save();
    }
    public int getCurrentScore(){
        return Integer.valueOf(this.properties.getProperty("CurrentScore"));
    }
    public void setCurrentScore(int n) throws IOException{
        String number = Integer.toString(n);
        this.properties.setProperty("CurrentScore", number);
        save();
    }
    public void setPlayerName(String name) throws IOException{
        this.properties.setProperty("Player", name);
        save();
    }
    public String getCurrentName(){
        return this.properties.getProperty("Player");
    }

    public void setScore(int currentScore, int i,String name) {
        String b = Integer.toString(i);
        String f = Integer.toString(currentScore);
        this.properties.setProperty("Score"+b, f);
        this.properties.setProperty("Player"+b, name);
    }

    public String getTopPlayer() {
        return this.properties.getProperty("TopPlayer");
    }

    public String getTopScore() {
        System.out.println(this.properties.getProperty("TopScore"));
        return this.properties.getProperty("TopScore");
    }

    public void setTopPlayer(String name) throws IOException {
        this.properties.setProperty("TopPlayer", name);
        save();
    }

    public void setTopScore(String s) throws IOException {
        this.properties.setProperty("TopScore", s);
        save();
    }
}

