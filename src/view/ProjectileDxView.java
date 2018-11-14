/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;
import model.ProjectileModel;

/**
 *
 * @author gabri
 */
public class ProjectileDxView extends ProjectileView{
    public ProjectileDxView(){
        super();
        this.imageDisplayed = new ImageView(new Image(ProjectileDxView.class.getResourceAsStream("/img/ProjectileDx.png")));
    }
}
