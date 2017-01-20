/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;
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
    protected Player enemy;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence = null;
    
    public Player(String name){
        this.name=name;
        this.level = 1;
    }
    
    public Player(Player p){
        this.name=p.getName();
        this.level=p.getLevels();
        this.dead=p.isDead();
        this.canISteal=p.canISteal();
        this.enemy=p.getEnemy();
        this.hiddenTreasures=p.getHiddenTreasures();
        this.visibleTreasures=p.getVisibleTreasures();
        this.pendingBadConsequence=p.getBadConsequence();
    }

    public BadConsequence getBadConsequence(){
        return this.pendingBadConsequence;
    }
    protected int  getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice=Dice.getInstance();
        int number=dice.nextNumber();
        boolean retorno=false;
        if(number==6)
            retorno=true;
        return retorno;
    }

    
    public String getName() {
        return name;
    }
    
    private void bringToLife(){
        dead=false;
        pendingBadConsequence=null;  //no seguro
    }

    public int getCombatLevel() {
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
        level-=l;
        if(level<1)
            level=1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0){
            CardDealer dealer= CardDealer.getInstance();
            Treasure t;
            for(int i=0;i<nTreasures;i++){
                t = dealer.nextTreasure();
                hiddenTreasures.add(t);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence bC = m.getBadConsequence();
        int nLevels = bC.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = bC.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
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
        CombatResult cr;
        int myLevel=this.getCombatLevel();
        int monsterLevel=getOponentLevel(m);
        if(!canISteal){
            Dice dice=Dice.getInstance();
            int number=dice.nextNumber();
            if(number<3){
                int enemyLevel=this.enemy.getCombatLevel();
                monsterLevel+=enemyLevel;
            }
        }
        if(myLevel>monsterLevel){
            applyPrize(m);
            if(level>=MAXLEVEL){
                cr=CombatResult.WINGAME;
            }else{
                cr=CombatResult.WIN;
            }    
        }else{
            if(this.shouldConvert()){
                cr=CombatResult.LOSEANDCONVERT;
            }else{
                applyBadConsequence(m);
                cr=CombatResult.LOSE;
            }
        }
        return cr;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI= canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
            
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t);
        if((this.pendingBadConsequence!=null)&&(!this.pendingBadConsequence.isEmpty())){
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
    }
    
    public void discardHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t);
        if((this.pendingBadConsequence!=null)&&(!this.pendingBadConsequence.isEmpty())){
            this.pendingBadConsequence.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
        CardDealer dealer = CardDealer.getInstance();
        dealer.giveTreasureBack(t);
    }
    
    public boolean validState(){
        //boolean valid=false;
        /*if( pendingBadConsequence == null || pendingBadConsequence.isEmpty() )
            if(hiddenTreasures.size()<=4)
                return true;*/
        return this.pendingBadConsequence == null || (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4);
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure t = dealer.nextTreasure();
        hiddenTreasures.add(t);
        int number = dice.nextNumber();
        if(number>1){
            t=dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
        if(number==6){
            t=dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Treasure stealTreasure(){
        Treasure t = null;
        boolean canI = canISteal();
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                t = enemy.giveMeATreasure();
                hiddenTreasures.add(t);
                haveStolen();
            }
        }
        return t;
    }
    public Player getEnemy(){
        return this.enemy;
    }
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    private Treasure giveMeATreasure(){
        Random rnd = new Random();
        int x = rnd.nextInt(hiddenTreasures.size());
        return hiddenTreasures.remove(x);
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
        while(!visibleTreasures.isEmpty()){
            discardVisibleTreasure(visibleTreasures.get(0));
        }
        while(!hiddenTreasures.isEmpty()){
            discardHiddenTreasure(hiddenTreasures.get(0));
        }
    }
    
    @Override
    public String toString(){
        return this.name + " Level: " + Integer.toString(level);
    }
}
