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
public class FXMLDocumentControllerLivelli implements Initializable{
    
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
   
    public void goBack(){
        Window.getInstance().menuIniziale();
    }
    
    public void selectLevel1(){
       Window.getInstance().gameWindow();
       Level1.getInstance();
    }
    public void selectLevel2(){
        Window.getInstance().gameWindow();
        Level2.getInstance();
    }
    public void selectLevel3(){        
        Window.getInstance().gameWindow();
        Level3.getInstance();
    }
}
