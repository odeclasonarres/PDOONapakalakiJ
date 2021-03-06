/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


/** 
 *  JOSÉ CARLOS BAENA ARIZA 
 *  JUAN MANUEL SALCEDO SERRANO
 */
public class Napakalaki {
     private static Napakalaki instancia = new Napakalaki();
     private CardDealer cd = CardDealer.getInstance();
     private Monster currentMonster;
     private Player currentPlayer;
     private ArrayList<Player> players = new ArrayList();
     
     
     private Napakalaki(){
         
     }
    
     
     public static Napakalaki getInstance(){
         return instancia;
     }
     
     public ArrayList<Player> getPlayers(){
         return this.players;
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
     
     private void setEnemies(){ //REVISAR ---> hacer con %
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
        CombatResult retorno=this.currentPlayer.combat(currentMonster);
        cd.giveMonsterBack(currentMonster);
        if(retorno==CombatResult.LOSEANDCONVERT){
            Cultist carta=cd.nextCultist();
            CultistPlayer cp= new CultistPlayer(currentPlayer, carta);
            
            for(Player p:players){
                if(p.getEnemy()==currentPlayer)
                    p.setEnemy(cp);
            }
            int index = players.indexOf(currentPlayer);
            players.set(index, cp);
            currentPlayer = cp;
        }
        return retorno;    
     }
     
     public void discardVisibleTreasures(ArrayList<Treasure> treasures){
         /*
         He tenido que usar el otro bucle porque si no teniamos java.util.ConcurrentModificationException
         
         for(Treasure t:treasures){  
            this.currentPlayer.discardVisibleTreasure(t);
             //this.cd.giveTreasureBack(t);
         }*/
         for(int i=treasures.size()-1;i>=0;i--){
             this.currentPlayer.discardVisibleTreasure(treasures.get(i));
         }
     }
     
     public void discardHiddenTreasures(ArrayList<Treasure> treasures){
         /*
         He tenido que usar el otro bucle porque si no teniamos java.util.ConcurrentModificationException
         for(Treasure t:treasures){ 
             this.currentPlayer.discardHiddenTreasure(t);
             //this.cd.giveTreasureBack(t);
         }*/
         for(int i=treasures.size()-1;i>=0;i--){
             this.currentPlayer.discardHiddenTreasure(treasures.get(i));
         }
     }

     public void makeTreasureVisible(ArrayList<Treasure> treasures){
         for(Treasure t: treasures){
             this.currentPlayer.makeTreasureVisible(t);   
         }
     }
     
     public void initGame(ArrayList<String> names){
         initPlayers(names);
         setEnemies();
         cd.initCards();
         nextTurn();
         
     }
     
     public Player getCurrentPlayer(){
         return currentPlayer;
     }
     
     public Monster getCurrentMonster(){
         return currentMonster;
     }
     
     public boolean nextTurn(){
        boolean stateOk=nextTurnAllowed(); 
        if(stateOk){
            this.currentMonster=cd.nextMonster();
            this.currentPlayer=nextPlayer();
            boolean dead=currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOk;
     }
     
     public boolean endOfGame(CombatResult result){
         if(result==CombatResult.WINGAME)
            return true;
         else
             return false;
     }
}
