/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utils.Config;


/**
 *
 * @author gabri
 */
public class FXMLControllerMenuIniziale implements Initializable{
    
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
   
        public void startGame(){
            Window.getInstance().menuLivelli();
        }
        public void continueGame(){
            int level = Config.getInstance().getCurrentLevel();
            Controller.getInstance().setLevel(level);
            Window.getInstance().gameWindow();
            switch(level) {
                case 1 : Level1.getInstance();break;
                case 2 : Level2.getInstance();break;
                case 3 : Level3.getInstance();break;
            }
        }
        public void selectShip(){
            Window.getInstance().menuNavicella();
        }
        public void records(){
            Window.getInstance().menuRecords();
        }
    
}
