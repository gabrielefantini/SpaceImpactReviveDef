
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/**
 *
 * @author gabri
 */
public class FXMLControllerLivelli implements Initializable{
    
    @FXML
    private Text text;
    @FXML
    private TextField playerName;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }
   
    public void goBack(){
        Window.getInstance().menuIniziale();
    }
    
    public void selectLevel1(){
       Controller.getInstance().setLevel(1);
       Window.getInstance().gameWindow();
       Level1.getInstance();
    }
    public void selectLevel2(){
        Controller.getInstance().setLevel(2);
        Window.getInstance().gameWindow();
        Level2.getInstance();
    }
    public void selectLevel3(){ 
        Controller.getInstance().setLevel(3);
        Window.getInstance().gameWindow();
        Level3.getInstance();
    }
    public void setPlayerName(){
        String name = playerName.getText();
        if(name.length()>=20)name = name.substring(0, 19);
        if(name.equals(""))name="Sconosciuto";
        Controller.getInstance().setName(name);
        text.setText(Controller.getInstance().getName());
    }
    
}
