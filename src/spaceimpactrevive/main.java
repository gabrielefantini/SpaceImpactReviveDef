/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceimpactrevivetemp;

import controller.SpaceImpactRevive;
import javafx.application.Application;
import javafx.stage.Stage;
import model.GameModel;
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
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
