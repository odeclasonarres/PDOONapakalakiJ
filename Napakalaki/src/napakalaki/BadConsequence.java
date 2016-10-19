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
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();

    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }

    public BadConsequence(String text, int levels, ArrayList<TreasureKind> specificVisibleTreasures, ArrayList<TreasureKind> specificHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = specificVisibleTreasures;
        this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public boolean isSpecificVisibleTreasure(String t){
        for(TreasureKind t2: specificVisibleTreasures){
            if(t2.toString()==t)
                return true;
        }
        return false;
    }
    
    public boolean isSpecificHiddenTreasure(String t){
        for(TreasureKind t2: specificHiddenTreasures){
            if(t2.toString()==t)
                return true;
        }
        return false;
    }
    
    public String toString(){
        String s;
        s= text + "\nlevels = " + Integer.toString(levels) +
                " Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                " Hidden Treasures = " + Integer.toString(nHiddenTreasures) +
                "\nSpecific Visible Treasures = ";
        for (TreasureKind t : specificVisibleTreasures) {
            s += t + " ";
        }
        s+= " Specific Hidden Treasures = ";
        
        for (TreasureKind t : specificHiddenTreasures){
            s += t + " ";
        }
        return s + "\nDeath = " + Boolean.toString(death)+ " )";             
    }
}
