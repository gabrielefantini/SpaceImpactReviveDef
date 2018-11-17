/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author gabri
 */
public class EnemyView extends GameView{
    private int a;
    private int b;
    public EnemyView(){
        super();
        a=0;
        b=0;
        
        this.imageNormal = new Image(EnemyView.class.getResourceAsStream("/img/enemy2.png"));
        //this.imageFlicker = new Image(EnemyView.class.getResourceAsStream("/img/enemy2.png"));
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(800,0);
        
    }
    @Override
    public void animationLoop(){
        ondeggia();
    }
    
    public void ondeggia(){
        int c = 0;
        int d=0;
        if(a<300){
            c = -1; d=+1;
            a++;
        }
        if(a == 300 && b<300){
            c = -1; d = -1;
            b++;
        }
        if(a==300 && b == 300){
            a=0;
            b=0;
        }
        
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()+c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY()+d;
        imageDisplayed.relocate(x,y);
    }
    
}
