/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author gabri
 */
public class GameView {
    public GameView(){
        
    }
    public void animationLoop(){
        
    }

    public boolean outOfSpace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void remove(){
        Space.getInstance().getChildren().remove(this);
    }
}
