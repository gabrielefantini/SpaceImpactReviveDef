/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class GameWindow {
    private static GameWindow instance = null;
    private Stage primaryStage;
    private BorderPane window;
    public static boolean UP,DOWN,LEFT,RIGHT,FIRE;
    
    private GameWindow(){
        window = new BorderPane();      
        window.setTop(StatusBar.getInstance());
        window.setCenter(Space.getInstance());
        Scene scene = new Scene(window,800,428);
        //event listener
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:    UP = true; break;
                case DOWN:  DOWN = true; break;
                case LEFT:  LEFT  = true; break;
                case RIGHT: RIGHT  = true; break; 
                case SPACE: FIRE  = true; break; 
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:    UP = false; break;
                case DOWN:  DOWN = false; break;
                case LEFT:  LEFT  = false; break;
                case RIGHT: RIGHT  = false; break; 
                case SPACE: FIRE  = false; break; 
            }
        });
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static GameWindow getInstance() {
        if(instance == null)instance = new GameWindow();
        return instance;
    }
    
    public void close(){
        instance = null;
        primaryStage.hide();
    }
}
