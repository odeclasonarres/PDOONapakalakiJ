/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author Charlie
 */
public class Dice {
    
    private static Dice instance = new Dice();
    
    private Dice(){
        
    }
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random rnd = new Random();    
        return rnd.nextInt(6)+1;
    }
}
