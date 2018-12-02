/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


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
            System.out.println("continua gioco");
        }
        public void selectShip(){
            Window.getInstance().menuNavicella();
        }
        public void records(){
            Window.getInstance().menuRecords();
        }
    
}
