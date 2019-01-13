/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



/**
 *
 * @author gabri
 */
public class FXMLControllerMenuIniziale implements Initializable{
    
    @FXML
    private Button button;
    
    @FXML
    private Text topPlayer;
    
    @FXML
    private Text topScore;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTopPlayer();
    }
   
        public void startGame(){
            Window.getInstance().menuLivelli();
        }
        public void continueGame(){
            Controller.getInstance().setName(Controller.getInstance().getCurrentName());
            int level = Controller.getInstance().getCurrentLevel();
            Controller.getInstance().setLevel(level);
            
            int t = Controller.getInstance().getCurrentTime();
            if(t<200)
                Controller.getInstance().setLevelTimer(t);
                else
                    Controller.getInstance().setLevelTimer(t-200);
            
            Window.getInstance().gameWindow();
            
            switch(level) {
                case 1 : Level1.getInstance();break;
                case 2 : Level2.getInstance();break;
                case 3 : Level3.getInstance();break;
            }
            
            switch (Controller.getInstance().getCurrentLife()){
                case 2 : Controller.getInstance().setLife(2);Controller.getInstance().removeHeart();break;
                case 1 :Controller.getInstance().setLife(1); Controller.getInstance().removeHeart();Controller.getInstance().removeHeart();break;
                case 0 :Controller.getInstance().setLife(0);Controller.getInstance().GameOver();break;
            }
            Controller.getInstance().setScore(Controller.getInstance().getCurrentScore());
        }
        public void selectShip(){
            Window.getInstance().menuNavicella();
        }
        public void records(){
            Window.getInstance().menuRecords();
        }
        
        private void setTopPlayer(){
            String topP = Controller.getInstance().getTopPlayer();
            String topS = Controller.getInstance().getTopScore();
            topPlayer.setText(topP);
            topScore.setText(topS);
        }
    
}
