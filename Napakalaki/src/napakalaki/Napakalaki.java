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
public class Napakalaki {
     private static Napakalaki instancia = new Napakalaki();
     private CardDealer cd = CardDealer.getInstance();
     private Monster currentMonster;
     private Player currentPlayer;
     private ArrayList<Player> players;
     
     private Napakalaki(){
         
     }
    
     
     public static Napakalaki getInstance(){
         return instancia;
     }
     
     private void initPlayers(ArrayList<String> names){
         
     }
     
     
     private Player nextPlayer(){
         return null;
     }
     
     
     private boolean nextTurnAllowed(){
         return true;
     }
     
     private void setEnemies(){
         
     }
     
     public CombatResult developCombat(){
         return null;
     }
     
     public void discardVisibleTreasures(ArrayList<Treasure> treasures){
         
     }
     
     public void discardHiddenTreasures(ArrayList<Treasure> treasures){
         
     }

     public void makeTreasureVisible(ArrayList<Treasure> treasures){
         
     }
     
     public void initGame(){
         
     }
     
     
     public Player getCurrentPlayer(){
         return currentPlayer;
     }
     
     public Monster getCurrentMonster(){
         return currentMonster;
     }
     
     public boolean nextTurn(){
         return false;
     }
     
     public boolean endOfGame(CombatResult result){
         return false;
     }
}
