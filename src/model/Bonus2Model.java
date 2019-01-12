/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;

/**
 *
 * @author gabriele fantini
 */
public class Bonus2Model extends BonusModel{
    public Bonus2Model(){
        super();
        life = 1;
        IMMUNITY = 0;
        type = "Bonus2";
    }
    @Override
    public void die() {
        Controller.getInstance().setRateo(3);
        Controller.getInstance().removeViewElementById(this.getHashId());
    }
}

