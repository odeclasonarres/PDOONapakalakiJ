/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificHiddenTreasures=new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures=new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> specificVisibleTreasures, ArrayList<TreasureKind> specificHiddenTreasures) {
        super(text,levels);
        this.specificVisibleTreasures = specificVisibleTreasures;
        this.specificHiddenTreasures = specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        if(isSpecificVisibleTreasureEmpty()&&isSpecificHiddenTreasureEmpty())
            return true;
        return false;
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
    
    @Override
    public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure>  h){
        SpecificBadConsequence retorno;
        ArrayList<TreasureKind> sV,sH;
        sV = adjustSpecific(specificVisibleTreasures, treasureToTreasureKind(v));
        sH = adjustSpecific(specificHiddenTreasures, treasureToTreasureKind(h));
        retorno = new SpecificBadConsequence(this.getText(), this.getLevels(), sV, sH);
        return retorno;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if(!specificVisibleTreasures.isEmpty() && specificVisibleTreasures.contains(t)){
            for(TreasureKind ty: specificVisibleTreasures){
                if(t.getType()==ty){
                    this.specificVisibleTreasures.remove(t.getType());
                }
            }
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if(!specificHiddenTreasures.isEmpty() && specificHiddenTreasures.contains(t)){
            for(TreasureKind ty: specificHiddenTreasures){
                if(t.getType()==ty){
                    this.specificHiddenTreasures.remove(t.getType());
                }
            }
        }
    }
    
    @Override
    public String toString(){
        String s; //= super.toString();;
        s= "Specific Visible Treasures = ";
        for (TreasureKind t : specificVisibleTreasures) {
            s += t + " ";
        }
        s+= "\nSpecific Hidden Treasures = ";
        
        for (TreasureKind t : specificHiddenTreasures){
            s += t + " ";
        }
        return s;
    }
    
}
