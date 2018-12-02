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
 * @author gabriele fantini
 */
public class BackgroundView extends GameView{
    private int c;
    public BackgroundView(){
        super();
        try {
            imageNormal = new Image(BackgroundView.class.getResourceAsStream("/img/Background1.png"));
        } catch (Exception e) {
        }
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(0,0);
        c=1;
    }

    @Override
    public void stopBackground(){
        c=0;
    }
    @Override
    public void animationLoop(){
       
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }
    @Override
    public void setBackground(int n){
        try{
        switch(n){
            case 1: imageDisplayed.setImage(new Image(BackgroundView.class.getResourceAsStream("/img/Background1.png")));break;
            case 2: imageDisplayed.setImage(new Image(BackgroundView.class.getResourceAsStream("/img/Background2.png")));break;
            case 3: imageDisplayed.setImage(new Image(BackgroundView.class.getResourceAsStream("/img/Background3.png")));break;
        }
        }catch(Exception e){
            System.out.println("view.BackgroundView.setBackground()");
        }
    }
}
