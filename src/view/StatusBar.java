/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SpaceImpactRevive;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


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
    private Button menu;
    private Button audio;
    
    private StatusBar(){
        try {
            heart = new Image(StatusBar.class.getResourceAsStream("/img/heart.png"));
        } catch (Exception e) {
            System.err.println(e);
        }
        score = new Label(" Score: ");
        menu = new Button("Menu");
        audio = new Button("Audio");
        audio.setFocusTraversable(false);
        menu.setFocusTraversable(false);
        menu.setCancelButton(true);
        menu.setOnAction((event) -> {
            switch(SpaceImpactRevive.getInstance().getLevel()){
                case 1: Level1.getInstance().stop();break;
                case 2: Level2.getInstance().stop();break;
                case 3: Level3.getInstance().stop();break;
            }
            Window.getInstance().menuPiccolo();
        });
        audio.setOnAction((event) -> {SpaceImpactRevive.getInstance().setSound();});
        this.add(menu,0,0);
        this.add(audio, 1, 0);
        this.add(score,2,0);
        score.setMinWidth(100);
        position = 3;
        this.setMargin(menu,new Insets(0, 5,0,5));
        this.setMargin(audio, new Insets(0,400,0,0));
        this.setMargin(score,new Insets(0,50,0,0));
        
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
        this.add(menu,0,0);
        this.add(audio,1,0);
        this.add(score,2,0);
        position--;
        for(int i=3; i<position; i++){
            this.add(new ImageView(heart),i,0);
            System.out.println(i);
        }
    }
    public void score(){
        punteggio++;
        score.setText("Score: "+punteggio+" ");
    }
}
