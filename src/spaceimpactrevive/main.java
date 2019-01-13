package spaceimpactrevive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import utils.Config;
import view.Window;

/**
 *
 * @author gabri
 */
public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Window.getInstance();
        Window.getInstance().menuIniziale();
        if(Config.getInstance().getCurrentName()== null){
            Config.getInstance().setCurrentLevel(0);
            Config.getInstance().setCurrentLife(0);
            Config.getInstance().setCurrentScore(0);
            Config.getInstance().setPlayerName("Sconosciuto");
            Config.getInstance().setTime(0);
            Config.getInstance().setTopPlayer("Sconosciuto");
            Config.getInstance().setTopScore("0");
            Config.getInstance().setSpaceShip(1);
        }
            
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
