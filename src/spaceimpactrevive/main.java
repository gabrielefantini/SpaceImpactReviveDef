package spaceimpactrevive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.stage.Stage;
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
