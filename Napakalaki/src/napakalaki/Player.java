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
public class Player {
    protected static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead=true;
    private boolean canISteal=true;
    private Player enemy;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    
    private void bringToLife(){
        dead=false;
    }

    private int getCombatLevel() {
        int l = getLevels();
        for(Treasure v: visibleTreasures){
            l= l+ v.getBonus();
        }
        return l;
    }

    private void incrementLevels(int l){
        if(level<MAXLEVEL)
            level+=l;
    }
    
    private void decrementLevels(int l){
        if(level>0)
            level-=l;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        if(t.getType()==TreasureKind.BOTHHANDS){
            for(Treasure tv: visibleTreasures){
                if(tv.getType()==TreasureKind.BOTHHANDS||tv.getType()==TreasureKind.ONEHAND)
                    return false;
            }
        }else if(t.getType()==TreasureKind.ONEHAND){
            int cont=0;
            for(Treasure tv: visibleTreasures){
                if(tv.getType()==TreasureKind.BOTHHANDS)
                    return false;
                if(tv.getType()==TreasureKind.ONEHAND)
                    cont++;
                if(cont==2)
                    return false;
            }
        }else{
            for(Treasure tv: visibleTreasures){
                if(tv.getType()==t.getType())
                    return false;
            }
        }
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int cont=0;
        for(Treasure t: visibleTreasures){
            if(t.getType()==tKind)
                cont++;
        }
        return cont;
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty()&&hiddenTreasures.isEmpty())
            dead=true;
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        return null;
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    public boolean validState(){
        boolean valid=false;
        if(pendingBadConsequence.isEmpty())
            if(hiddenTreasures.size()>4)
                return true;
        return false;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Treasure stealTreasure(){
        return null;
    }
    
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    private Treasure giveMeATreasure(){
        return null;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        boolean retorno = false;
        if(!visibleTreasures.isEmpty()||!hiddenTreasures.isEmpty())
            retorno = true;
        return retorno;
    }
    
    private void haveStolen(){
        canISteal=false;
    }
    
    public void discardAllTreasures(){
        
    }
}
