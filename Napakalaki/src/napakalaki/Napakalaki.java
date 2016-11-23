/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

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
         for(String s: names){
             players.add(new Player(s));
         }
     }
     
     
     private Player nextPlayer(){
         int x;
         if(currentPlayer==null){
            Random rnd = new Random();
            x = rnd.nextInt(players.size());
         }else{
            x = players.indexOf(currentPlayer);
            x = (x+1)%players.size();
         }
        return players.get(x);
     }
     
     
     private boolean nextTurnAllowed(){
         boolean retorno;
         if(currentPlayer==null)
            retorno = true;
         else
            retorno = currentPlayer.validState();
         return retorno;
     }
     
     private void setEnemies(){
        Random rnd = new Random();
        int x;
        for(Player p: players){
            x = rnd.nextInt(players.size());
            if(x==players.indexOf(p)){
                if(players.indexOf(p)==players.size()-1)
                    x=0;
                else
                    x+=1;
            }
            p.setEnemy(players.get(x));
        }
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
         if(result==CombatResult.WINGAME)
            return true;
         else
             return false;
     }
}
