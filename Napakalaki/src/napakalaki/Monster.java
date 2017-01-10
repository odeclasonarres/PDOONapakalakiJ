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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelAgainstCultistPlayer=0;

    public Monster(String name, int combatLevel, Prize prize, BadConsequence bc) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc; 
    }
    
    public Monster(String name, int combatLevel, Prize prize, BadConsequence bc, int lC) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc;
        this.levelAgainstCultistPlayer=lC;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevelAgainstCultistPlayer(){
        return this.levelAgainstCultistPlayer;
    }
    @Override
    public String toString() {
        return "Monster{" + "name=" + this.name + ", combatLevel=" + Integer.toString(combatLevel)+ "\nprize=" + prize.toString() + "bc=" + bc.toString() + "}\n";
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public Prize getPrize() {
        return prize;
    }

    public BadConsequence getBadConsequence() {
        return bc;
    }
    
    public int getBCLevels(){
        return bc.getLevels();
    }
    /*
    public ArrayList<TreasureKind> getBCSpecificHiddenTreasures(){
        return bc.getSpecificHiddenTreasures();
    }
    
    public ArrayList<TreasureKind> getBCSpecificVisibleTreasures(){
        return bc.getSpecificVisibleTreasures();
    }
    
    public int getBCNHiddenTreasures(){
        return bc.getnHiddenTreasures();
    }
    
    public int getBCNVisibleTreasures(){
        return bc.getnVisibleTreasures();
    }*/
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    /*
    public boolean isBCSpecificHiddenTreasure(TreasureKind t){
        return bc.isSpecificHiddenTreasure(t);
    }
    
    public boolean isBCSpecificVisibleTreasure(TreasureKind t){
        return bc.isSpecificVisibleTreasure(t);
    }
    
    public boolean isBCDeath(){
        return bc.isDeath();
    }
    
    public boolean isBCSpecificVisibleTreasureEmpty(){
        return bc.isSpecificVisibleTreasureEmpty();
    }
    
    public boolean isBCSpecificHiddenTreasureEmpty(){
        return bc.isSpecificHiddenTreasureEmpty();
    }*/
    
    public int getTreasuresGained(){
        return prize.getTreasure();
    }
}
