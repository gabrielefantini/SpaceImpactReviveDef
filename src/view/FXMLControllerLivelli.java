
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import model.Player;

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
       Window.getInstance().gameWindow();
       Player.getInstance().setLevel(1);
       Level1.getInstance();
    }
    public void selectLevel2(){
        Window.getInstance().gameWindow();
        Player.getInstance().setLevel(2);
        Level2.getInstance();
    }
    public void selectLevel3(){        
        Window.getInstance().gameWindow();
        Player.getInstance().setLevel(3);
        Level3.getInstance();
    }
    public void setPlayerName(){
        String name = playerName.getText();
        if(name.length()>=20)name = name.substring(0, 19);
        if(name.equals(""))name="Sconosciuto";
        Player.getInstance().setName(name);
        text.setText(Player.getInstance().getName());
        System.out.println(Player.getInstance().getName());
    }
    
}
