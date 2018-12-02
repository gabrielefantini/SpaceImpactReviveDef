/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SpaceImpactRevive;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLMenuPiccoloController implements Initializable {

    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    public void Riassumi(){
        Window.getInstance().gameWindow();
        switch (SpaceImpactRevive.getInstance().getLevel()){
            case 1: Level1.getInstance().start();break;
            case 2: Level2.getInstance().start();break;
            case 3: Level3.getInstance().start();break;
        }
        
    }

    public void SalvaEdEsci(){
        
    }
    public void SalvaEMenuIniziale(){
        
    }
}
