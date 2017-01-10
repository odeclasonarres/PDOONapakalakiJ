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
public class DeathBadConsequence extends NumericBadConsequence{
    
    public DeathBadConsequence(String text){
        super(text,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
    }
    
    @Override
    public String toString(){
        String s = super.toString();
        s += "\nDeath = true";
        return s;
    }
}
