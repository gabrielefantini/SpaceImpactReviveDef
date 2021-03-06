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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLMenuPiccoloController implements Initializable {
    @FXML
    private Text text;
    @FXML
    private Button button;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPlayerStatus();
    }   
    public void Riassumi(){
        Window.getInstance().gameWindow();
        if(Controller.getInstance().getLife()!=0)Controller.getInstance().start();
    }

    public void SalvaEdEsci(){
        Controller.getInstance().setCurrentLevel(Controller.getInstance().getLevel());
        Controller.getInstance().setCurrentLife(Controller.getInstance().getLife());
        Controller.getInstance().setCurrentTime(Controller.getInstance().getLevelTimer());
        Controller.getInstance().setPlayerName();
        Controller.getInstance().setCurrentScore(Controller.getInstance().getScore());
        System.exit(0);
    }
    public void Esci(){
        System.exit(0);
    }
    public void setPlayerStatus(){
        String status = null;
        if(Controller.getInstance().PlayerStatus()==1)status = "You Win";
        if(Controller.getInstance().PlayerStatus()==2)status = "You Loose";
        if(Controller.getInstance().PlayerStatus()==0)status= "";
        text.setText(status);
    }
}
