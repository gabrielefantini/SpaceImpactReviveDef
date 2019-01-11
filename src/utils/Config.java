/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

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
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(
                new InputStreamReader(
                    this.getClass().getResourceAsStream("config.txt"),"ISO-8859-1"));
            
            this.properties = new Properties();
            this.properties.load(buffRead);
        }
        catch(FileNotFoundException fnfe) {
            /*
            JOptionPane.showMessageDialog(null,
                        "Configuration file not found, the program will be closed.",
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
            */
        }
        catch(IOException ioe) {
            /*
            JOptionPane.showMessageDialog(null,
                        "Unable to read the configuration file, the program will be closed.",
                        "Serious ERROR",
                        JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
            */
        }
        finally {
            try {
                if (buffRead != null)
                    buffRead.close();
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        } // end finally
    } // end constructor
    
    public void changeConfigurationFile(String path){
        
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(
                new InputStreamReader(
                    this.getClass().getResourceAsStream(path),"ISO-8859-1"));
            
            this.properties = new Properties();
            this.properties.load(buffRead);
        }
        catch(FileNotFoundException fnfe) {
            
        JOptionPane.showMessageDialog(null,
            "Configuration file not found, the program will be closed. "+this.getConfigFileFullPath(path),
            "Serious ERROR",
            JOptionPane.ERROR_MESSAGE);
            System.exit(-1);

        }
        catch(IOException ioe) {
            
            JOptionPane.showMessageDialog(null,
            "Unable to read the configuration file, the program will be closed.",
            "Serious ERROR",
            JOptionPane.ERROR_MESSAGE);
            System.exit(-1);

        }
        finally {
            try {
                if (buffRead != null)
                    buffRead.close();
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        } // end finally
        
    }
    
    private String getConfigFileFullPath(String path) {
        String fileName = Config.class.getResource(path).toString();
        
        if (fileName.contains("//"))
            fileName = fileName.substring("file:/".length()); //Windows version
        else if (fileName.contains("/"))
            fileName = fileName.substring("file:/".length()); //Linux version
        fileName = fileName.replaceAll("%20", " ");
        return fileName;
    }
    public static Config getInstance(){
        if(config == null)config = new Config();
        return config;
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
    public void setSpaceShip(int n){
        String number = Integer.toString(n);
        this.properties.setProperty("SpaceShip", number);
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

