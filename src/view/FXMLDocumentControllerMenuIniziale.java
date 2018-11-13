/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.SpaceImpactRevive;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


/**
 *
 * @author gabri
 */
public class FXMLDocumentControllerMenuIniziale implements Initializable{
    
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
   
        public void startGame(){
            Window.getInstance().menuLivelli();
        }
        public void continueGame(){
            System.out.println("continua gioco");
        }
        public void settings(){
        }
        public void records(){
            System.out.println("records");
        }
    
}
