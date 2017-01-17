/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author Charlie
 */
public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    
    private CardDealer(){
        
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));    
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11,prize, badConsequence));

        badConsequence=new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 1, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize= new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de la biodanza", 8, prize, badConsequence) );

        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan",2,prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto");
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, prize, badConsequence));
        
        badConsequence =  new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList())); //Preguntar por los tesoros
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        badConsequence=new SpecificBadConsequence("EL primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList(Arrays.asList()));
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,prize, badConsequence));
        
        badConsequence=new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize=new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",13,prize, badConsequence));
        
        badConsequence=new SpecificBadConsequence("Sientes bichos bajo la ropa. Pierdes la armadura visibles", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, prize, badConsequence));
        
        badConsequence=new NumericBadConsequence("Toses los pulmones y perdes 2 niveles", 2, 0, 0);
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("Fletcher", 2, prize, badConsequence));
        
        badConsequence=new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize=new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas de Cthulhu", 4, prize, badConsequence));
        
        badConsequence=new NumericBadConsequence("Da mucho asquito.Pierdes 3 niveles", 3, 0, 0);
        prize=new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
        
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize= new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10, prize, badConsequence, -2));
        
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, prize, badConsequence, 2));
        
        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres");
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, prize, badConsequence, 4));
        
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente politico",8, prize, badConsequence, -2));
        
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, prize, badConsequence, 5));
        
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, prize, badConsequence, -4));
        
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, prize, badConsequence, 3));
    }
    
    private void initCultistCardDeck(){
        Cultist c = new Cultist("Sectario", 1);
        unusedCultist.add(c);
        
        c = new Cultist("Sectario", 2);
        unusedCultist.add(c);
        
        c = new Cultist("Sectario", 1);
        unusedCultist.add(c);
        
        c = new Cultist("Sectario", 2);
        unusedCultist.add(c);
        
        c = new Cultist("Sectario", 1);
        unusedCultist.add(c);
        
        c = new Cultist("Sectario", 1);
        unusedCultist.add(c);
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures); 
    }
    
    private void shuffleMonster(){
        Collections.shuffle(unusedMonsters);
    }
    private void shuffleCultist(){
        Collections.shuffle(unusedCultist);
    }
    
    public Treasure nextTreasure(){
        Treasure retorno;
        if(unusedTreasures.isEmpty()){
            unusedTreasures=usedTreasures;
            shuffleTreasures();
            usedTreasures.clear();
            retorno=unusedTreasures.remove(0);
        }else{
            retorno=unusedTreasures.remove(0);
        }
        return retorno;
    }
    
    public Monster nextMonster(){
        Monster retorno;
        if(unusedMonsters.isEmpty()){
            unusedMonsters=usedMonsters;
            shuffleMonster();
            usedMonsters.clear();
            retorno=unusedMonsters.remove(0);
        }else{
            retorno=unusedMonsters.remove(0);
        }
        return retorno;
    }
    
    public Cultist nextCultist(){
        return unusedCultist.remove(0);
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        shuffleTreasures();
        shuffleMonster();
        shuffleCultist();
    }
}
