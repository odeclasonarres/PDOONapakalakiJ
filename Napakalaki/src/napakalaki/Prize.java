/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author OdeclasOnarres
 */
public class Prize {
    private int treasures;
    private int level;
    //hola

    public Prize(int treasure, int level) {
        this.treasures = treasure;
        this.level = level;
    }

    public int getTreasure() {
        return this.treasures;
    }

    public int getLevel() {
        return this.level;
    }
    
    public String toString(){
        return "treasures = " + Integer.toString(treasures) + 
                " levels = " + Integer.toString(level) + " \n";
    }
}
