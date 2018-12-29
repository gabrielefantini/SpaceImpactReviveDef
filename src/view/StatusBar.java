/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Player;


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
    private Label playerName;
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
        playerName = new Label(Player.getInstance().getName());
        audio.setFocusTraversable(false);
        menu.setFocusTraversable(false);
        menu.setCancelButton(true);
        menu.setOnAction((event) -> {
            Controller.getInstance().stop();
            Window.getInstance().menuPiccolo();
        });
        audio.setOnAction((event) -> {View.getInstance().setSound();});
        this.add(menu,0,0);
        this.add(audio, 1, 0);
        this.add(playerName, 2, 0);
        this.add(score,3,0);
        score.setMinWidth(100);
        playerName.setMinWidth(100);
        playerName.setMaxWidth(100);
        position = 4;
        this.setMargin(menu,new Insets(0, 5,0,5));
        this.setMargin(audio, new Insets(0,5,0,0));
        this.setMargin(playerName,  new Insets(0,295,0,5));
        this.setMargin(score,new Insets(0,50,0,0));
        playerName.setFont(Font.font ("Arial"));
        
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
        this.add(playerName, 2, 0);
        this.add(score,3,0);
        position--;
        for(int i=4; i<position; i++){
            this.add(new ImageView(heart),i,0);
            System.out.println(i);
        }
    }
    public void score(){
        punteggio++;
        score.setText("Score: "+punteggio+" ");
    }
    public void gameOver(){
        this.menu.setDisable(true);
    }
}
