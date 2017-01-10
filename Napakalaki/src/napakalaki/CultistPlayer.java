/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Random;

/**
 *
 * @author Charlie
 */
public class CultistPlayer extends Player{
    private Cultist myCultistCard;
    private static int totalCultistPlayer=0;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p.getName());
        this.myCultistCard=c;
        totalCultistPlayer++;
    }
    
    @Override
    protected int getCombatLevel(){
        double numero=super.getCombatLevel()+(super.getCombatLevel()*0.7)+(myCultistCard.getGainedLevels()*totalCultistPlayer);
        return (int)numero;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){return false;}
    
    private Treasure giveMeATreasure(){
        if(canYouGiveMeATreasure()){
            Random rnd=new Random();
            int tamano=super.getEnemy().getVisibleTreasures().size();
            return super.getEnemy().getVisibleTreasures().get(rnd.nextInt(tamano));
        }return null;
    }
    
    private boolean canYouGiveMeATreasure(){
        if(super.getVisibleTreasures().size()>0){
            return true;
        }else return false;}
    
    public static int getTotalCultistPlayer(){return totalCultistPlayer;}



}
