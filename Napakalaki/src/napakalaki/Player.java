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
        
    }

    private int getCombatLevel() {
        return 0;
    }

    private void incrementLevels(int l){
        
    }
    
    private void decrementLevels(int l){
        
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        return false;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        return 0;
    }
    
    private void dieIfNoTreasures(){
        
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
        return false;
    }
    
    private boolean canYouGiveMeATreasure(){
        return false;
    }
    
    private void haveStolen(){
        
    }
    
    public void discardAllTreasures(){
        
    }
}
