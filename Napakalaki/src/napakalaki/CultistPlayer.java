/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

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
    }
    
    protected int getCombatLevel(){return 0;}
    protected int getOponentLevel(Monster m){return 0;}
    protected boolean shouldConvert(){return false;}
    private Treasure giveMeATreasure(){return null;}
    private boolean canYouGiveMeATreasure(){return false;}
    public static int getTotalCultistPlayer(){return totalCultistPlayer;}



}
