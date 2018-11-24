/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SpaceImpactRevive;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


/**
 *
 * @author gabri
 */
public class StatusBar extends GridPane{
    private static StatusBar instance = null;
    private Image heart;
    private int position;
    private int punteggio = 0;
    private Label score;
    
    private StatusBar(){
        try {
            heart = new Image(StatusBar.class.getResourceAsStream("/img/heart.png"));
        } catch (Exception e) {
            System.err.println(e);
        }
        score = new Label(" Score: ");
        this.add(score,0,0);
        position = 1;
        
    }
    public static StatusBar getInstance() {
        if(instance == null)instance = new StatusBar();
        return instance;
    }
    public void addLife(){
        ImageView image = new ImageView(heart);
        this.add(image,position,0);
        position++;
    }
    public void removeLife(){
        this.getChildren().clear();
        score.setText("Score: "+punteggio+" ");
        this.add(score,0,0);
        position--;
        for(int i=1; i<position; i++){
            this.add(new ImageView(heart),i,0);
            System.out.println(i);
        }
    }
    public void score(){
        punteggio++;
        score.setText("Score: "+punteggio+" ");
    }
}
