/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.GameModel;
import model.SpaceShipModel;

/**
 *
 * @author gabri
 */
class Level1 {
    private static Level1 instance = null;
    private Level1(){
    }
    public static Level1 getInstance() {
        if(instance == null)instance = new Level1();
        return instance;
    }
    
}
