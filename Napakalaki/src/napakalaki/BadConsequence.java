/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;


/**
 *
 * @author OdeclasOnarres
 */
public abstract class BadConsequence {
    private String text;
    private int levels;
    //private boolean death;
    protected static final int MAXTREASURES = 10;

    public BadConsequence(String text, int levels) {
        this.text = text;
        this.levels = levels;
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }
    
    public abstract boolean isEmpty();

    abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure>  h);
    
    abstract void substractVisibleTreasure(Treasure t);
    
    abstract void substractHiddenTreasure(Treasure t);
    
    @Override
    public String toString(){
        String s;
        s= text + "\nlevels = " + Integer.toString(levels);          
        return s;           
    }
}
