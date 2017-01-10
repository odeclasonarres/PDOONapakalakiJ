/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import static java.lang.Integer.min;
import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class NumericBadConsequence extends BadConsequence{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        super(text,levels);
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    } 
    
    @Override
    public boolean isEmpty(){
        if(nVisibleTreasures==0&&nHiddenTreasures==0)
            return true;
        return false;
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure>  h){
        NumericBadConsequence retorno;
        int nV,nH;
        nV=min(nVisibleTreasures,v.size());
        nH=min(nHiddenTreasures,h.size());
        retorno = new NumericBadConsequence(this.getText(), this.getLevels(), nV, nH);
        return retorno;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if(this.nVisibleTreasures>0){
            this.nVisibleTreasures--;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if(this.nHiddenTreasures>0){
            this.nHiddenTreasures--;
        }
    }
    
    @Override
    public String toString(){
        String s = super.toString();
        s += " Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                " Hidden Treasures = " + Integer.toString(nHiddenTreasures);
        return s;
    }
}
