/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObstacleView extends EnemyView{
    private int frameRate;
    private int counter;
    public ObstacleView(int y){
        super();
        try {
            this.imageNormal = new Image(ObstacleView.class.getResourceAsStream("/img/1 (1).png"));

        } catch (Exception e) {
            System.out.println(e);
        }
        this.imageDisplayed = new ImageView(imageNormal);
        Space.getInstance().getChildren().add(imageDisplayed);
        imageDisplayed.relocate(805,y);
        counter = 1;
        frameRate = 0;
    }
    @Override
    public void animationLoop(){
        int c=1;
        if(counter==120)counter = 1;
        if(frameRate==0){
            imageDisplayed.setImage(new Image(ObstacleView.class.getResourceAsStream("/img/1 ("+counter+").png")));
            counter++;; 
            frameRate = 4;}
        frameRate--;
        int x = (int)imageDisplayed.getBoundsInParent().getMinX()-c;
        int y =(int)imageDisplayed.getBoundsInParent().getMinY();
        imageDisplayed.relocate(x,y);
    }
}
