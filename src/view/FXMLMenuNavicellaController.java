/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import utils.Config;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLMenuNavicellaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void selectSpaceShip1(){
        Config.getInstance().setSpaceShip(1);
    }
    public void selectSpaceShip2(){
        Config.getInstance().setSpaceShip(2);
    }
    public void selectSpaceShip3(){
        Config.getInstance().setSpaceShip(3);
    }
    public void goBack(){
        Window.getInstance().menuIniziale();
    }
}
