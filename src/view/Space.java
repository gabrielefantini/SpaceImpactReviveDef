/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 *
 * @author gabri
 */
public class Space extends Pane{
    public static final int SceneWidth = 800;
    public static final int SceneHeight = 400;
    private static Space instance = null;
    private Image ProjectileDx;
    private Image ProjectileSx;
    private Image SpaceShipNormal;
    private Image SpaceShipFlicker;
    private Image Background;
    
            
    private Space(){
        this.setWidth(SceneHeight);
        this.setHeight(SceneHeight);
        try {
            ProjectileDx = new Image(Space.class.getResourceAsStream("/img/ProjectileDx.png"));
            ProjectileSx = new Image(Space.class.getResourceAsStream("/img/ProjectileSx.png"));
            SpaceShipNormal = new Image(Space.class.getResourceAsStream("/img/SpaceShipNormal.png"));
            SpaceShipFlicker = new Image(Space.class.getResourceAsStream("/img/SpaceShipFlicker.png"));
            Background = new Image(Space.class.getResourceAsStream("/img/Background.png"));
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    public static Space getInstance() {
        if(instance == null)instance = new Space();
        return instance;
    }
    public Bounds addChildAndRelocate(String img,Bounds oldBounds,double x,double y){
            Image image = SpaceShipNormal;
            if(img == "ProjectileDx")image = ProjectileDx;
            if(img == "ProjectileSx")image = ProjectileSx;
            if(img == "SpaceShipNormal")image = SpaceShipNormal;
            if(img == "SpaceShipFlicker")image = SpaceShipFlicker;
            if(img == "Background")image = Background;
            ImageView newnode = new ImageView(image);
            instance.getChildren().add(newnode);
            newnode.relocate(oldBounds.getMinX(),oldBounds.getMinY());   
            return newnode.getBoundsInParent();
    }
    public void clear(){
        instance.getChildren().clear();
    }
}
