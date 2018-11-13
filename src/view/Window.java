/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class Window {
    private static Window instance = null;
    private Scene scene;
    private Stage primaryStage;
    private Group root;
    
    private Window(){
        this.root = new Group();
        this.scene = new Scene(root, 800,400);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static Window getInstance(){
        if(instance == null)instance = new Window();
        return instance;
    }
    public void clear(){
        root.getChildren().clear();
    }
    public void menuIniziale(){
        clear();
        try {
            this.root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/FXMLDocumentMenuIniziale.fxml")));
        } catch (Exception e) {
        }
    }
    public void menuLivelli(){
        clear();
        try {
            this.root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/FXMLDocumentLivelli.fxml")));
        } catch (Exception e) {
        }
    }
    public void menuSettings(){
        
    }
    public void records(){
        
    }
    public void gameWindow(){
        primaryStage.close();
        GameWindow.getInstance();
    }
}
