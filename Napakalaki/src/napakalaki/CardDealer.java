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
public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    
    private CardDealer(){
        
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
        
    }
    
    private void initMonsterCardDeck(){
        
    }
    
    private void shuffleTreasures(){
        
    }
    
    private void shuffleMonster(){
        
    }
    
    public Treasure nextTreasure(){
        return null;
    }
    
    public Monster nextMonster(){
        return null;
    }
    
    public void giveTreasureBack(Treasure t){
        
    }
    
    public void giveMonsterBack(Monster m){
        
    }
    
    public void initCards(){
        
    }
}
