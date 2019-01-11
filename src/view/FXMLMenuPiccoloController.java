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
        Controller.getInstance().start();
    }

    public void SalvaEdEsci(){
        Controller.getInstance().setCurrentLevel(Controller.getInstance().getLevel());
        Controller.getInstance().setCurrentLife(Controller.getInstance().getLife());
        Controller.getInstance().setCurrentTime(Controller.getInstance().getLevelTimer());
        Controller.getInstance().setPlayerName();
        System.exit(0);
    }
}
