/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javafx.scene.layout.Pane;


/**
 *
 * @author gabri
 */
public class Space extends Pane{
    public static final int SceneWidth = 800;
    public static final int SceneHeight = 400;
    private static Space instance = null;
    
            
    private Space(){
        this.setWidth(SceneHeight);
        this.setHeight(SceneHeight);
        
    }
    public static Space getInstance() {
        if(instance == null)instance = new Space();
        return instance;
    }
    public void clear(){
        instance.getChildren().clear();
    }
}
