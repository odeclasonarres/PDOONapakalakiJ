/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.Iterator;

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
    private static final int MAXTREASURES = 4;

    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
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
    
    private ArrayList<TreasureKind> adjustSpecific(ArrayList<TreasureKind> tb, ArrayList<TreasureKind> tj){
        ArrayList<TreasureKind> retorno = new ArrayList();
        int x=0;
        for(TreasureKind tipo: tb){ 
            x=tj.indexOf(tipo);
            if(x>=0){
                retorno.add(tj.remove(x));  
            }
        }
        return retorno;
    }
    
    private ArrayList<TreasureKind> treasureToTreasureKind(ArrayList<Treasure> t){
        ArrayList<TreasureKind> retorno = new ArrayList();
        for(Treasure tesoro: t){
            retorno.add(tesoro.getType());
        }
        return retorno;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure>  h){
        BadConsequence retorno;
        if(nVisibleTreasures!=0 || nHiddenTreasures!=0){
            int nV,nH;
            nV=min(nVisibleTreasures,v.size());
            nH=min(nHiddenTreasures,h.size());
            retorno = new BadConsequence(text, levels, nV, nH);
        }else{
            ArrayList<TreasureKind> sV,sH;
            sV = adjustSpecific(specificVisibleTreasures, treasureToTreasureKind(v));
            sH = adjustSpecific(specificHiddenTreasures, treasureToTreasureKind(h));
            retorno = new BadConsequence(text, levels, sV, sH);
        }   
        return retorno;
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
        if(!specificVisibleTreasures.isEmpty() && specificVisibleTreasures.contains(t)){
            for(TreasureKind ty: specificVisibleTreasures){
                if(t.getType()==ty){
                    this.specificVisibleTreasures.remove(t.getType());
                }
            }
        }
        
    }
    
    public void substractHiddenTreasure(Treasure t) {
        if(this.nHiddenTreasures>0){
            this.nHiddenTreasures--;
        }
        if(!specificHiddenTreasures.isEmpty() && specificHiddenTreasures.contains(t)){
            for(TreasureKind ty: specificHiddenTreasures){
                if(t.getType()==ty){
                    this.specificHiddenTreasures.remove(t.getType());
                }
            }
        }
    }
}
