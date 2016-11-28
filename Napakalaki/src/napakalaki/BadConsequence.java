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
    
    public boolean isSpecificVisibleTreasure(TreasureKind t){
        for(TreasureKind t2: specificVisibleTreasures){
            if(t2.equals(t))
                return true;
        }
        return false;
    }
    
    public boolean isSpecificHiddenTreasure(TreasureKind t){
        for(TreasureKind t2: specificHiddenTreasures){
            if(t2.equals(t))
                return true;
        }
        return false;
    }
    
    public boolean isSpecificVisibleTreasureEmpty(){
        return specificVisibleTreasures.isEmpty();
    }
    
    public boolean isSpecificHiddenTreasureEmpty(){
        return specificHiddenTreasures.isEmpty();
    }
    
    public boolean isEmpty(){
        if(nVisibleTreasures==0&&nHiddenTreasures==0&&isSpecificVisibleTreasureEmpty()&&isSpecificHiddenTreasureEmpty())
            return true;
        return false;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<TreasureKind> v,ArrayList<TreasureKind>  h){
        /*
        Numericos
            nv=min(pendin, equipado)
            nh=min(pendin, equipado)
            bc=newNumeric
        
        
        Especificos
            Metodo nuevo: devuelve lo común entre los dos arrays
            sv=metodo(array pendin, array equipado)
            sh=metodo(array pendin, array equipado)
            bc=newSpecific
        */
        
        return this;
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

    public void substractVisibleTreasure(Treasure t) {
        if(this.nVisibleTreasures>0){
            this.nVisibleTreasures--;
        }
        for(TreasureKind ty:this.specificVisibleTreasures){
            if(t.getType()==ty){
                this.specificVisibleTreasures.remove(t.getType());
            }
        }
        
    }
    
    public void substractHiddenTreasure(Treasure t) {
        if(this.nHiddenTreasures>0){
            this.nHiddenTreasures--;
        }
        for(TreasureKind ty:this.specificHiddenTreasures){
            if(t.getType()==ty){
                this.specificHiddenTreasures.remove(t.getType());
            }
        }
    }
}
