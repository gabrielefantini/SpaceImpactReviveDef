/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;


/**
 *
 * @author gabri
 */
public class Bonus1Model extends BonusModel{
    public Bonus1Model(){
        super();
        life = 1;
        IMMUNITY = 0;
        type = "Bonus1";
    }
    @Override
    public void die() {
        int n = Player.getInstance().getLife();
        if(n<3){
            Player.getInstance().setLife(n+1);
            Controller.getInstance().addLife();
        }
        Controller.getInstance().removeViewElementById(this.getHashId());
    }
}
